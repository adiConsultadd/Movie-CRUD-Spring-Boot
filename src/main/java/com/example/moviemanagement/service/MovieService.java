package com.example.moviemanagement.service;

import com.example.moviemanagement.dto.MovieCreateDTO;
import com.example.moviemanagement.dto.MovieDTO;
import com.example.moviemanagement.dto.MoviePatchDTO;
import com.example.moviemanagement.dto.MovieUpdateDTO;

import java.util.List;

public interface MovieService {

    // Create a new movie
    MovieDTO createMovie(MovieCreateDTO movieCreateDTO);

    // Get all movies
    List<MovieDTO> getAllMovies();

    // Get movie by ID
    MovieDTO getMovieById(Long id);

    // Update movie (PUT)
    MovieDTO updateMovie(Long id, MovieUpdateDTO movieUpdateDTO);

    // Partially update movie (PATCH)
    MovieDTO patchMovie(Long id, MoviePatchDTO moviePatchDTO);

    // Delete movie
    void deleteMovie(Long id);

    // Search movies by title
    List<MovieDTO> searchMoviesByTitle(String title);

}