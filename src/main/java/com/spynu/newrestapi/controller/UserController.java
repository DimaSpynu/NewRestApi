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
@RequestMapping("/api/users")
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

    @ApiOperation(value = "Показать форму создания пользователя")
    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "user/user-create";
    }

    @ApiOperation(value = "Создать пользователя")
    @PostMapping("/createUsers")
    public String createUser(@ModelAttribute User user) {
        userService.createNewUserService(user);
        return "redirect:/api/users/getUserList";
    }

    @ApiOperation(value = "Показать форму редактирования пользователя")
    @GetMapping("/{id}/edit")
    public String showEditFormUser(@PathVariable("id") Long id, Model model) {
        User user = userService.showUserByIdService(id).orElse(new User());
        model.addAttribute("user", user);
        return "user/user-edit";
    }

    @ApiOperation(value = "Редактировать пользователя")
    @PostMapping("/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute User user) {
        User updatedUser = userService.showUserByIdService(id).orElse(null);
        if (updatedUser != null) {
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setAge(user.getAge());
            updatedUser.setEmail(user.getEmail());
            userService.updateUserService(updatedUser);
        }
        return "redirect:/api/users/getUserList";
    }

    @ApiOperation(value = "Удалить пользователя")
    @PostMapping("/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserService(id);
        return "redirect:/api/users/getUserList";
    }
}
