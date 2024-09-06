package com.workintech.s19d1.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "movie", schema = "movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "movie_id")
    private Long id;

    @Column(name = "name")
    @NotNull
    @NotBlank
    @Size(min = 10, max = 150)
    private String name;

    @Column(name = "director_name")
    @NotNull
    @NotBlank
    @Size(min = 10, max = 50)
    private String directorName;

    @Column(name = "rating")
    @Positive
    private Integer rating;

    @Column(name = "release_date")
    @NotNull
    private LocalDate releaseDate;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "movies")
    private List<Actor> actors = new ArrayList<>();

    public void addActor(Actor actor) {
        actors.add(actor);
    }
}
