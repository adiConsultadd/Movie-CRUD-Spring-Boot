package com.example.moviemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieUpdateDTO {
    private String title;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    private String description;

    private LocalDate releaseDate;

    private String director;

    private Set<String> genres;

    @Min(value = 0, message = "Rating must be at least 0")
    @Max(value = 10, message = "Rating must not exceed 10")
    private Double rating;

    @Min(value = 1, message = "Duration must be at least 1 minute")
    private Integer durationMinutes;

    private String language;

    private String posterUrl;
}