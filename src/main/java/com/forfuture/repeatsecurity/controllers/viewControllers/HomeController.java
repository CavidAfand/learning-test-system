package com.forfuture.repeatsecurity.controllers.viewControllers;

import com.forfuture.repeatsecurity.entities.Role;
import com.forfuture.repeatsecurity.entities.Word;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/")
public class HomeController {

//    @GetMapping
//    public String getHomeController(Authentication authentication, Model model) {
//        List<Role> roles = (List<Role>) authentication.getAuthorities();
//        model.addAttribute("admin", roles.get(0).getAuthority().equalsIgnoreCase("admin"));
//        return "home";
//    }

    @GetMapping
    public String GoHomePage() {
        return "It work";
    }

}
