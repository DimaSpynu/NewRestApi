package com.spynu.newrestapi.controller;

import com.spynu.newrestapi.entity.User;
import com.spynu.newrestapi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequestMapping
@Api(tags = "Пользователи")
@FieldDefaults(level = lombok.AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class UserController {
    UserService userService;

    @ApiOperation(value = "Показать список пользователей")
    @GetMapping("/getUserList")
    public String showUsers(Model model) {
        List<User> users = userService.showAllUsersService();
        model.addAttribute("users", users);
        return "user/user-list";
    }


    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "user/user-create";
    }

    @PostMapping("/createUsers")
    public String createUser(@ModelAttribute User user) {
        userService.createNewUserService(user);
        return "redirect:/users/getUserList";
    }

    @GetMapping("/{id}/edit")
    public String showEditFormUser(@PathVariable("id") Long id, Model model) {
        User user = userService.showUserByIdService(id);
        model.addAttribute("user", user);
        return "user/user-edit";
    }

    @PostMapping("/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute User user) {
        User updatedUser = userService.showUserByIdService(id);
        if (updatedUser != null) {
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setAge(user.getAge());
            updatedUser.setEmail(user.getEmail());
            userService.updateUserService(updatedUser);
        }
        return "redirect:/users/getUserList";
    }

    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserService(id);
        return "redirect:/users/getUserList";
    }
}
