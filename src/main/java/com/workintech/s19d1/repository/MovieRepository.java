package com.workintech.s19d1.repository;

import com.workintech.s19d1.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
