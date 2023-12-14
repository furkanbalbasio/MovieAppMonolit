package com.balbasio.SpringMovieApp.repository;

import com.balbasio.SpringMovieApp.repository.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<Movie,Long> {
}
