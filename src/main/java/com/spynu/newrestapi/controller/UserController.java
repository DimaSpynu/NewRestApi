package com.spynu.newrestapi.controller;
import com.spynu.newrestapi.entity.User;
import com.spynu.newrestapi.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
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
        try {
            model.addAttribute("users", users);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return "product/user-list-new";
    }

    @ApiOperation(value = "Показать форму создания пользователя")
    @GetMapping("/users/new")
    public String showCreateForm(Model model) {
        model.addAttribute("user", new User());
        return "user-create";
    }

    @ApiOperation(value = "Создать нового пользователя")
    @PostMapping("/createUsers")
    public String createUser(@ModelAttribute User user) {
        userService.createNewUserService(new User());
        return "redirect:/users";
    }

    @ApiOperation(value = "Показать форму редактирования пользователя")
    @GetMapping("/users/{id}/edit")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        User user = userService.showUserByIdService(id);
        model.addAttribute("user", user);
        return "user-edit";
    }

    @ApiOperation(value = "Обновить пользователя")
    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable("id") Long id, @ModelAttribute User user) {
        User updatedUser = userService.showUserByIdService(id);
        if(updatedUser != null) {
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            updatedUser.setAge(user.getAge());
            updatedUser.setEmail(user.getEmail());

            userService.updateUserService(updatedUser);
        }
        return "redirect:/users";
    }

    @ApiOperation(value = "Удалить пользователя")
    @DeleteMapping("/users/{id}/delete")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.deleteUserService(id);
        return "redirect:/users";
    }
}
