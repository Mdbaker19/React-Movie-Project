package com.movie.reactspringmovie.repository;

import com.movie.reactspringmovie.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {

}
