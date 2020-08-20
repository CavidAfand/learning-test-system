package com.forfuture.repeatsecurity.controllers.formContollers;

import com.forfuture.repeatsecurity.entities.Role;
import com.forfuture.repeatsecurity.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/a/role_add")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @GetMapping
    public String addRoleGet() {
        return "/admin/roleAdd";
    }

    @PostMapping
    public String addRolePost(@RequestParam("role") String role) {
        roleService.addRole(new Role(role));
        return "redirect:/logout";
    }

}
