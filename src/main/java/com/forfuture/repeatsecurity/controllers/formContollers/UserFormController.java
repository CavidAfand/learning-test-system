package com.forfuture.repeatsecurity.controllers.formContollers;

import com.forfuture.repeatsecurity.entities.Role;
import com.forfuture.repeatsecurity.entities.User;
import com.forfuture.repeatsecurity.services.RoleService;
import com.forfuture.repeatsecurity.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/a/user_add")
public class UserFormController {

    private RoleService roleService;
    private UserService userService;

    @Autowired
    public UserFormController (RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }

    @GetMapping
    public String getUserAddPage(Model model) {
        model.addAttribute("roles", roleService.getRoles());
        model.addAttribute("newUser", new User());
        return "/admin/userAdd";
    }

    @PostMapping
    public String postUserAddPage(User user, @RequestParam("role") Long roleId) {
        Role role = roleService.getRoleById(roleId);
        user.setRole(role);
        userService.saveUser(user);
        return "redirect:/logout";
    }

}
