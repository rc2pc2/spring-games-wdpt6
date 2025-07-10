package org.lessons.java.spring.wdpt6.spring_games_wdpt6.model;

import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Username cannot be null or empty")
    private String username;

    @NotBlank(message = "Password cannot be null or empty")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "role_user",
        joinColumns = @JoinColumn(name="user_id"),
        inverseJoinColumns = @JoinColumn(name="role_id")
    )
    private Set<Role> roles;

        // Getter per roles
    public Set<Role> getRoles() {
        return roles;
    }

    // Setter per roles
    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }
    
    // Getter per id
    public Integer getId() {
        return id;
    }

    // Setter per id
    public void setId(Integer id) {
        this.id = id;
    }

    // Getter per username
    public String getUsername() {
        return username;
    }

    // Setter per username
    public void setUsername(String username) {
        this.username = username;
    }

    // Getter per password
    public String getPassword() {
        return password;
    }
}
