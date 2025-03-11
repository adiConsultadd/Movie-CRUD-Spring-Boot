package com.example.moviemanagement.service;

import com.example.moviemanagement.dto.MovieCreateDTO;
import com.example.moviemanagement.dto.MovieDTO;
import com.example.moviemanagement.dto.MoviePatchDTO;
import com.example.moviemanagement.dto.MovieUpdateDTO;
import com.example.moviemanagement.entity.Movie;
import com.example.moviemanagement.exception.ResourceNotFoundException;
import com.example.moviemanagement.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    @Autowired
    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public MovieDTO createMovie(MovieCreateDTO movieCreateDTO) {
        Movie movie = new Movie();
        movie.setTitle(movieCreateDTO.getTitle());
        movie.setDescription(movieCreateDTO.getDescription());
        movie.setReleaseDate(movieCreateDTO.getReleaseDate());
        movie.setDirector(movieCreateDTO.getDirector());
        movie.setGenres(movieCreateDTO.getGenres());
        movie.setRating(movieCreateDTO.getRating());
        movie.setDurationMinutes(movieCreateDTO.getDurationMinutes());
        movie.setLanguage(movieCreateDTO.getLanguage());
        movie.setPosterUrl(movieCreateDTO.getPosterUrl());


        Movie savedMovie = movieRepository.save(movie);
        return convertToDTO(savedMovie);
    }

    @Override
    public List<MovieDTO> getAllMovies() {
        return movieRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MovieDTO getMovieById(Long id) {
        Movie movie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));
        return convertToDTO(movie);
    }

    @Override
    public MovieDTO updateMovie(Long id, MovieUpdateDTO movieUpdateDTO) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));

        existingMovie.setTitle(movieUpdateDTO.getTitle());
        existingMovie.setDescription(movieUpdateDTO.getDescription());
        existingMovie.setReleaseDate(movieUpdateDTO.getReleaseDate());
        existingMovie.setDirector(movieUpdateDTO.getDirector());
        existingMovie.setGenres(movieUpdateDTO.getGenres());
        existingMovie.setRating(movieUpdateDTO.getRating());
        existingMovie.setDurationMinutes(movieUpdateDTO.getDurationMinutes());
        existingMovie.setLanguage(movieUpdateDTO.getLanguage());
        existingMovie.setPosterUrl(movieUpdateDTO.getPosterUrl());

        Movie updatedMovie = movieRepository.save(existingMovie);
        return convertToDTO(updatedMovie);
    }

    @Override
    public MovieDTO patchMovie(Long id, MoviePatchDTO moviePatchDTO) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found with id: " + id));

        if (moviePatchDTO.getTitle() != null) {
            existingMovie.setTitle(moviePatchDTO.getTitle());
        }
        if (moviePatchDTO.getDescription() != null) {
            existingMovie.setDescription(moviePatchDTO.getDescription());
        }
        if (moviePatchDTO.getReleaseDate() != null) {
            existingMovie.setReleaseDate(moviePatchDTO.getReleaseDate());
        }
        if (moviePatchDTO.getDirector() != null) {
            existingMovie.setDirector(moviePatchDTO.getDirector());
        }
        if (moviePatchDTO.getGenres() != null) {
            existingMovie.setGenres(moviePatchDTO.getGenres());
        }
        if (moviePatchDTO.getRating() != null) {
            existingMovie.setRating(moviePatchDTO.getRating());
        }
        if (moviePatchDTO.getDurationMinutes() != null) {
            existingMovie.setDurationMinutes(moviePatchDTO.getDurationMinutes());
        }
        if (moviePatchDTO.getLanguage() != null) {
            existingMovie.setLanguage(moviePatchDTO.getLanguage());
        }
        if (moviePatchDTO.getPosterUrl() != null) {
            existingMovie.setPosterUrl(moviePatchDTO.getPosterUrl());
        }

        Movie updatedMovie = movieRepository.save(existingMovie);
        return convertToDTO(updatedMovie);
    }

    @Override
    public void deleteMovie(Long id) {
        if (!movieRepository.existsById(id)) {
            throw new ResourceNotFoundException("Movie not found with id: " + id);
        }
        movieRepository.deleteById(id);
    }

    @Override
    public List<MovieDTO> searchMoviesByTitle(String title) {
        return movieRepository.findByTitleContainingIgnoreCase(title).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    //This converts Movie Entity To MovieDTO
    private MovieDTO convertToDTO(Movie movie) {
        MovieDTO movieDTO = new MovieDTO();
        movieDTO.setId(movie.getId());
        movieDTO.setTitle(movie.getTitle());
        movieDTO.setDescription(movie.getDescription());
        movieDTO.setReleaseDate(movie.getReleaseDate());
        movieDTO.setDirector(movie.getDirector());
        movieDTO.setGenres(movie.getGenres());
        movieDTO.setRating(movie.getRating());
        movieDTO.setDurationMinutes(movie.getDurationMinutes());
        movieDTO.setLanguage(movie.getLanguage());
        movieDTO.setPosterUrl(movie.getPosterUrl());
        movieDTO.setCreatedAt(movie.getCreatedAt());
        movieDTO.setUpdatedAt(movie.getUpdatedAt());
        return movieDTO;
    }
}