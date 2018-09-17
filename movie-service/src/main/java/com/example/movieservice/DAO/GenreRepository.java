package com.example.movieservice.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.movieservice.models.Genre;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
	
}
