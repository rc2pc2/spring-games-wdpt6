package org.lessons.java.spring.wdpt6.spring_games_wdpt6.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "games")
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Size(min = 2, message = "Title must contain at least 2 characters")
    @NotBlank(message = "The tilte must not be blank, empty or null")
    private String title;

    @Size(min = 2, message = "Developer must contain at least 2 characters")
    @NotBlank(message = "The developer field must not be blank, empty or null")
    private String developer;

    @Size(min = 2, message = "Genre must contain at least 2 characters")
    @NotBlank(message = "The genre field must not be blank, empty or null")
    private String genre;

    @NotNull(message = "Release date must be filled")
    private LocalDate releaseDate;

    @Lob
    @Size(min = 10, max = 2000, message = "Description must contain at least 10 characters and not more than 2000")
    @NotBlank(message = "The developer field must not be blank, empty or null")
    private String description;

    @Lob
    @Size(min = 10, max = 1000, message = "Image url must contain at least 10 characters and not more than 1000")
    private String imageUrl;

    @NotNull(message = "Price cannot be null")
    private float price;


    public float getPrice() {
        return this.price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeveloper() {
        return this.developer;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public LocalDate getReleaseDate() {
        return this.releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
