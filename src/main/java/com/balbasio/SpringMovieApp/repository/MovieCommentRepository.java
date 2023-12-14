package com.balbasio.SpringMovieApp.repository;

import com.balbasio.SpringMovieApp.repository.entity.MovieComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieCommentRepository extends JpaRepository<MovieComment,Long> {
}
