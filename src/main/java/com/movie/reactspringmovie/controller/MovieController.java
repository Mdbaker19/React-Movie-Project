package com.movie.reactspringmovie.controller;

import com.movie.reactspringmovie.exception.NotFound;
import com.movie.reactspringmovie.model.Movie;
import com.movie.reactspringmovie.repository.MovieRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movies-api")
public class MovieController {

    private MovieRepository movieDao;

    public MovieController(MovieRepository movieDao){
        this.movieDao = movieDao;
    }

    @GetMapping("/movies")
    public List<Movie> getAllMovies(){
        return movieDao.findAll();
    }

    @GetMapping("/movies/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable(name = "id") long id) {
        Movie movie = movieDao.findById(id).orElseThrow( () -> new NotFound("No Movie found with id " + id));
        return ResponseEntity.ok(movie);
    }

}
