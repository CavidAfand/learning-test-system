package com.forfuture.repeatsecurity.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "user_table")
@Getter
@Setter
@NoArgsConstructor
public class User implements Serializable {

    @Id
    private String username;

    @Column(name = "pass", length = 200, nullable = false)
    private String password;

    @Column(name="active", nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    public User (String username, String password, Role role) {
        this.username = username;
        this.password = password;
        this.active = true;
        this.role = role;
    }

}
