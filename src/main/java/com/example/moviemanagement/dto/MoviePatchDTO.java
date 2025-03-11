package com.example.moviemanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;
import java.util.Set;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class MoviePatchDTO {
    private String title;
    private String description;
    private LocalDate releaseDate;
    private String director;
    private Set<String> genres;
    private Double rating;
    private Integer durationMinutes;
    private String language;
    private String posterUrl;
}