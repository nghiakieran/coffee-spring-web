package com.nghia.coffee_spring_web.controller.admin;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.nghia.coffee_spring_web.domain.User;
import com.nghia.coffee_spring_web.service.UploadService;
import com.nghia.coffee_spring_web.service.UserService;

import jakarta.validation.Valid;

@Controller
public class UserController {

    private final UserService userService;
    private final UploadService uploadService;

    public UserController(UserService userService, UploadService uploadService) {
        this.userService = userService;
        this.uploadService = uploadService;
    }

    @GetMapping("/admin/user")
    public String getShowUserPage(Model model) {
        List<User> users = this.userService.findAllUser();
        model.addAttribute("users", users);
        return "admin/user/show";
    }

    @GetMapping("/admin/user/create")
    public String getCreateUserPage(Model model) {
        model.addAttribute("newUser", new User());
        return "admin/user/create";
    }

    @PostMapping(value = "/admin/user/create")
    public String createUserPage(Model model, @ModelAttribute("newUser") @Valid User user,
            BindingResult bindingResult, @RequestParam("userFile") MultipartFile file) {

        List<FieldError> errors = bindingResult.getFieldErrors();
        for (FieldError error : errors) {
            System.out.println(error.getField() + " - " + error.getDefaultMessage());
        }
        // Validate
        if (bindingResult.hasErrors()) {
            return "/admin/user/create";
        }

        String avatar = this.uploadService.handleSaveUploadFile(file, "avatar");
        // String password = this.passwordEncoder.encode(hoidanit.getPassword());
        user.setAvatar(avatar);
        user.setRole(this.userService.getRoleByName(user.getRole().getName()));

        this.userService.handleSaveAUser(user);
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/update/{id}")
    public String getUpdateUserPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("newUser", user);
        return "admin/user/update";
    }

    @PostMapping(value = "/admin/user/update")
    public String updateUserPage(Model model, @ModelAttribute("newUser") User userForm) {
        User user = this.userService.getUserById(userForm.getId());
        if (user != null) {
            user.setFullName(userForm.getFullName());
            user.setAddress(userForm.getAddress());
            user.setPhone(userForm.getPhone());
            this.userService.handleSaveAUser(user);
        }
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/delete/{id}")
    public String getDeleteUserPage(Model model, @PathVariable long id) {
        model.addAttribute("newUser", new User());
        model.addAttribute("id", id);
        return "admin/user/delete";
    }

    @PostMapping(value = "/admin/user/delete")
    public String deleteUserPage(Model model, @ModelAttribute("newUser") User user) {
        this.userService.deleteAUser(user.getId());
        return "redirect:/admin/user";
    }

    @GetMapping("/admin/user/{id}")
    public String getUserDetailPage(Model model, @PathVariable long id) {
        User user = this.userService.getUserById(id);
        model.addAttribute("user", user);
        model.addAttribute("id", id);
        return "admin/user/detail";
    }
}
