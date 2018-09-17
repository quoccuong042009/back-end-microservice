package com.example.theaterservice.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.theaterservice.models.Theater;
import com.example.theaterservice.services.TheaterService;

@RestController
public class TheaterControllers {
	@Autowired
	TheaterService theaterService;
	
	@RequestMapping(value = "/theaters", method = RequestMethod.GET)
//	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STANDARD_USER')")
	public List<Theater> getAllTheaters() {
		return theaterService.getAllTheaters();
	}
	
	@RequestMapping(value = "/theater/{id}", method = RequestMethod.GET)
//	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STANDARD_USER')")
	public Theater getTheaterById(@PathVariable(value = "id") long id) {
		return theaterService.findById(id);
	}
	
	@RequestMapping(value = "/theater/add", method = RequestMethod.POST)
//	@PreAuthorize("hasAuthority('ADMIN')")
	public String addTheater(@Valid @RequestBody Theater theaterDetails) {
		if(theaterService.getTheaterByName(theaterDetails.getName()) != null) {
			return "This theater has already exsisted";
		}
		else {
			theaterService.save(theaterDetails);
			return "success";
		}
	}
	@RequestMapping(value = "/theater/edit/{id}", method = RequestMethod.PUT)
//	@PreAuthorize("hasAuthority('ADMIN')")
	public String addTheater(@PathVariable(value = "id") long id, @Valid @RequestBody Theater theaterDetails) {
		
		Theater theater = theaterService.findById(id);
		theater = theaterDetails;
		
		theaterService.save(theater);
		return "success";
	}
}
