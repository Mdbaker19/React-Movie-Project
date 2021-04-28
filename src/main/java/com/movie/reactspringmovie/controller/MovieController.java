package com.movie.reactspringmovie.controller;

import com.movie.reactspringmovie.repository.MovieRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies-api/")
public class MovieController {

    private MovieRepository movieDao;

    public MovieController(MovieRepository movieDao){
        this.movieDao = movieDao;
    }

}
