package com.forfuture.repeatsecurity.services;

import com.forfuture.repeatsecurity.entities.Role;
import com.forfuture.repeatsecurity.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public List<Role> getRoles() {
        return roleRepository.findAll();
    }

    public Role getRoleById(Long id) {
        return roleRepository.findById(id).get();
    }

    public boolean addRole(Role role) {
        roleRepository.save(role);
        return true;
    }

}
