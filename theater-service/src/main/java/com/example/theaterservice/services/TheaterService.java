package com.example.theaterservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.theaterservice.DAO.TheaterRepository;
import com.example.theaterservice.models.Theater;

@Service
public class TheaterService {
	@Autowired
	TheaterRepository theaterRepository;
	
	public List<Theater> getAllTheaters() {
		return theaterRepository.findAll();
	}

	public Theater getTheaterByName(String name) {
		return theaterRepository.findByName(name);
	}

	public void save(Theater theaterDetails) {
		theaterRepository.save(theaterDetails);
	}
	
	public Theater findById(long id) {
		return theaterRepository.getOne(id);
	}
}
