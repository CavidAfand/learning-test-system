package com.forfuture.repeatsecurity.entities;

import com.forfuture.repeatsecurity.formModels.RoleModel;
import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "role_table")
@Getter
@Setter
public class Role implements GrantedAuthority, Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;

    @Column(name = "role", nullable = false)
    private String role;

    @OneToMany(mappedBy = "role")
    private List<User> users;

    @Override
    public String getAuthority() {
        return role;
    }

    public Role() {}

    public Role (RoleModel roleModel) {
        this.role = roleModel.getRole();
    }

    public Role (String role) {
        this.role = role;
    }
}
