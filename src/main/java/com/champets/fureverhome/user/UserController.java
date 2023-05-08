package com.champets.fureverhome.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user-register")
    public String listUsers(Model model) {
        List<UserDto> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "user-registration";
    }

    @GetMapping("/users/{userId}")
    public String userDetail(@PathVariable("userId") Long userId, Model model) {
        UserDto userDto = userService.findUserById(userId);
        model.addAttribute("user", userDto);
        return "user-detail";
    }

    @GetMapping("/users/new")
    public String createUserForm(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "user-create";
    }

    @PostMapping("/users/new")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{userId}/delete")
    public String deleteUser(@PathVariable("userId") Long userId) {
        userService.delete(userId);
        return "redirect:/users";
    }

    @GetMapping("/users/search")
    public String searchUsers(@RequestParam(value = "query") String query, Model model) {
        List<UserDto> users = userService.searchUsers(query);
        model.addAttribute("users", users);
        return "user-list";
    }

    @GetMapping("/users/{userId}/edit")
    public String editUserForm(@PathVariable("userId") Long userId, Model model) {
        UserDto userDto = userService.findUserById(userId);
        model.addAttribute("user", userDto);
        return "user-edit";
    }

    @PostMapping("/users/{userId}/edit")
    public String updateUser(@PathVariable("userId") Long userId,
                             @Valid @ModelAttribute("user") UserDto userDto,
                             BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("user", userDto);
            return "user-edit";
        }
        userDto.setId(userId);
        userService.updateUser(userDto);
        return "redirect:/users";
    }
}
