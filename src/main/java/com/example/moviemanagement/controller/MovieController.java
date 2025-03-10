package com.example.moviemanagement.controller;

import com.example.moviemanagement.dto.MovieCreateDTO;
import com.example.moviemanagement.dto.MovieDTO;
import com.example.moviemanagement.dto.MoviePatchDTO;
import com.example.moviemanagement.dto.MovieUpdateDTO;
import com.example.moviemanagement.service.MovieService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    // CREATE - POST
    @PostMapping
    public ResponseEntity<MovieDTO> createMovie(@Valid @RequestBody MovieCreateDTO movieCreateDTO) {
        MovieDTO createdMovie = movieService.createMovie(movieCreateDTO);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }

    // READ - GET (all)
    @GetMapping
    public ResponseEntity<List<MovieDTO>> getAllMovies() {
        List<MovieDTO> movies = movieService.getAllMovies();
        return ResponseEntity.ok(movies);
    }

    // READ - GET (by id)
    @GetMapping("/{id}")
    public ResponseEntity<MovieDTO> getMovieById(@PathVariable Long id) {
        MovieDTO movie = movieService.getMovieById(id);
        return ResponseEntity.ok(movie);
    }

    // UPDATE - PUT
    @PutMapping("/{id}")
    public ResponseEntity<MovieDTO> updateMovie(
            @PathVariable Long id,
            @Valid @RequestBody MovieUpdateDTO movieUpdateDTO) {
        MovieDTO updatedMovie = movieService.updateMovie(id, movieUpdateDTO);
        return ResponseEntity.ok(updatedMovie);
    }

    // UPDATE - PATCH
    @PatchMapping("/{id}")
    public ResponseEntity<MovieDTO> patchMovie(
            @PathVariable Long id,
            @RequestBody MoviePatchDTO moviePatchDTO) {
        MovieDTO patchedMovie = movieService.patchMovie(id, moviePatchDTO);
        return ResponseEntity.ok(patchedMovie);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.noContent().build();
    }

    // SEARCH - by title
    @GetMapping("/search/title")
    public ResponseEntity<List<MovieDTO>> searchMoviesByTitle(@RequestParam String title) {
        List<MovieDTO> movies = movieService.searchMoviesByTitle(title);
        return ResponseEntity.ok(movies);
    }

}