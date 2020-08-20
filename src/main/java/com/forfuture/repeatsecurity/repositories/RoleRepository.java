package com.forfuture.repeatsecurity.repositories;

import com.forfuture.repeatsecurity.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
