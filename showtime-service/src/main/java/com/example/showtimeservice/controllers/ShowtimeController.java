package com.example.showtimeservice.controllers;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.showtimeservice.models.Showtime;
import com.example.showtimeservice.models.ShowtimeDetail;
import com.example.showtimeservice.services.ShowtimeDetailService;
import com.example.showtimeservice.services.ShowtimeService;

@RestController
public class ShowtimeController {
	@Autowired
	ShowtimeService showtimeService;

	@Autowired
	ShowtimeDetailService showtimeDetailService;

	@RequestMapping(value = "/showtimes", method = RequestMethod.GET)
	// @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STANDARD_USER')")
	public List<Showtime> getAllShowtimes() {
		return showtimeService.findAll();
	}
	
	@RequestMapping(value = "/avai-showtimes", method = RequestMethod.GET)
	// @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STANDARD_USER')")
	public List<Showtime> getAvaiShowtimes() {
		return showtimeService.getAvaiShowtimes();
	}
	
	@RequestMapping(value = "/avai-showtimes/range-date/{startDate}/{endDate}", method = RequestMethod.GET)
	// @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STANDARD_USER')")
	public List<Showtime> getAvaiShowtimesByRangeDate(@PathVariable Date startDate, @PathVariable Date endDate) {
		return showtimeService.getAvaiShowtimesByRangeDate(startDate, endDate);
	}

	@RequestMapping(value = "/showtime/{showtimeId}", method = RequestMethod.GET)
	// @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STANDARD_USER')")
	public Showtime getShowtimeByShowtimeId(@PathVariable long showtimeId) {
		return showtimeService.getShowtimeByShowtimeId(showtimeId);
	}

	@RequestMapping(value = "/showtimes/movieId/{id}", method = RequestMethod.GET)
	public List<Showtime> getShowtimesByMovieId(@PathVariable long id) {
		return showtimeService.findShowtimeByMovieId(id);
	}

	@RequestMapping(value = "/showtimes/range-date/{startDate}/{endDate}", method = RequestMethod.GET)
	public List<Showtime> getShowtimeByRangeDate(@PathVariable Date startDate, @PathVariable Date endDate) {
		return showtimeService.getShowtimeByRangeDate(startDate, endDate);
	}
	
	@RequestMapping(value = "/showtimes/genre/{genreId}", method = RequestMethod.GET)
	// @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STANDARD_USER')")
	public List<Showtime> getShowtimesByGenreId(@PathVariable long genreId) {
		return showtimeService.getShowtimesByGenreId(genreId);
	}
	// ==============FOR BOOKING==========================================
	@RequestMapping(value = "/showtimes/slots/{movieId}/{date}", method = RequestMethod.GET)
	public List<Showtime> getTimeslotByMovieIdAndDate(@PathVariable long movieId, @PathVariable Date date) {
		return showtimeService.findTimeslotByMovieIdAndDate(movieId, date);
	}

	@RequestMapping(value = "/showtimes/theaters/{movieId}/{date}/{slot}", method = RequestMethod.GET)
	public List<Showtime> getTheatersByMovieIdAndDateAndTime(@PathVariable long movieId, @PathVariable Date date,
			@PathVariable String slot) {
		return showtimeService.getTheatersByMovieIdAndDateAndTime(movieId, date, slot);
	}

	@RequestMapping(value = "/showtime/{movieId}/{theaterId}/{slot}/{date}", method = RequestMethod.GET)
	public Showtime getShowtimeByRest(@PathVariable long movieId, @PathVariable long theaterId, @PathVariable Date date,
			@PathVariable String slot) {
		return showtimeService.findShowtimeByRest(movieId, theaterId, date, slot);
	}

	//===============FOR ADDING SHOWTIME====================================
	@RequestMapping(value = "/showtimes/{theaterId}/{date}", method = RequestMethod.GET)
	public List<String> findAvailableTimeWithDateAndTheater(@PathVariable long theaterId, @PathVariable Date date) {
		return showtimeService.findAvailableTimeWithDateAndTheater(theaterId, date);
	}
	
	@RequestMapping(value = "/showtime/add", method = RequestMethod.POST)
	public String addShowtime(@Valid @RequestBody Showtime showtime) {
		return showtimeService.add(showtime);
	}
	//===============FOR DISABLE SHOWTIME====================================
	@RequestMapping(value = "/showtime/disable", method = RequestMethod.PUT)
	public String disableShowtime(@Valid @RequestBody Showtime showtime) {
		return showtimeService.disableShowtime(showtime);
	}
	// ==============SHOWTIMEDETAIL==========================================
	@RequestMapping(value = "/showtimes/showtimedetail", method = RequestMethod.POST)
	public List<ShowtimeDetail> getShowtimedetailByShowtimes(@Valid @RequestBody List<Showtime> showtimes) {
		return showtimeDetailService.getShowtimedetailByShowtimes(showtimes);
	}
}
