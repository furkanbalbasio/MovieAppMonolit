package com.balbasio.SpringMovieApp.repository.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_movie")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String language;
    private String image;
    private String name;
    private String country;
    private double rating;
    @Size(max = 2048)
    private String summary;
    private LocalDate premiered;
    private String url;
    @ElementCollection
    private List<Long> genres;
    @ElementCollection(fetch = FetchType.EAGER)
    private List<Long> comments;


}
