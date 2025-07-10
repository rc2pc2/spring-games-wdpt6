package org.lessons.java.spring.wdpt6.spring_games_wdpt6.model;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Name cannot be null or empty")
    private String name;

    @JsonBackReference
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    
    // Getter per id
    public Integer getId() {
        return id;
    }

    // Setter per id
    public void setId(Integer id) {
        this.id = id;
    }

        // Getter per name
    public String getName() {
        return name;
    }

    // Setter per name
    public void setName(String name) {
        this.name = name;
    }
}
