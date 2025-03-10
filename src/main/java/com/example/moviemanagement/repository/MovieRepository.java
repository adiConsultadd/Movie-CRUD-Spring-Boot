package com.example.moviemanagement.repository;

import com.example.moviemanagement.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

    // Find movies by title containing the given string (case insensitive)
    List<Movie> findByTitleContainingIgnoreCase(String title);

    // Find movies by director
    List<Movie> findByDirectorContainingIgnoreCase(String director);

    // Find movies by genre
    @Query("SELECT m FROM Movie m JOIN m.genres g WHERE LOWER(g) = LOWER(:genre)")
    List<Movie> findByGenre(String genre);

    // Find movies with rating greater than or equal to the given value
    List<Movie> findByRatingGreaterThanEqual(Double rating);

    // Find movies by language
    List<Movie> findByLanguageIgnoreCase(String language);
}