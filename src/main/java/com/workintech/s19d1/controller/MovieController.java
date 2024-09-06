package com.workintech.s19d1.controller;

import com.workintech.s19d1.dto.MovieActorRequest;
import com.workintech.s19d1.entity.Actor;
import com.workintech.s19d1.entity.Movie;
import com.workintech.s19d1.service.ActorService;
import com.workintech.s19d1.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private final MovieService manager;

    private final ActorService actorService;

    @Autowired
    public MovieController(MovieService manager, ActorService actorService) {
        this.manager = manager;
        this.actorService = actorService;
    }

    @GetMapping
    public List<Movie> getAllMovies() {
        return manager.findAll();
    }

    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable("id") Long id) {
        return manager.findById(id);
    }

    @PostMapping("/")
    public Movie saveMovieWithActor(@RequestBody MovieActorRequest request) {
        Movie movie = request.getMovie();
        Actor actor = request.getActor();

        movie.addActor(actor);
        actor.addMovie(movie);

        actorService.save(actor);

        Movie savedMovie = manager.save(movie);

        return savedMovie;
    }
}
