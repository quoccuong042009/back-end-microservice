package com.example.movieservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieservice.DAO.GenreRepository;
import com.example.movieservice.models.Genre;

@Service
public class GenreService {
	@Autowired
	GenreRepository genreRepository;
	
	public List<Genre> findAll() {
		return genreRepository.findAll();
	}

	public Genre findGenreByGenreId(long genreId) {
		return genreRepository.getOne(genreId);
	}
}
