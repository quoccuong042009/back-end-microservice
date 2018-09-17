package com.example.movieservice.DAO;

import java.sql.Date;
import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.movieservice.models.Showtime;

@FeignClient(name = "showtime-service")
@RibbonClient(name = "showtime-service")
public interface ShowtimeProxy {

	@RequestMapping(value = "/showtime/{showtimeId}", method = RequestMethod.GET)
	public Showtime getShowtimeByShowtimeId(@PathVariable(value = "showtimeId") long showtimeId);

	@RequestMapping(value = "/showtimes/movieId/{id}", method = RequestMethod.GET)
	public List<Showtime> getShowtimesByMovieId(@PathVariable(value = "id") long id);

	@RequestMapping(value = "/showtimes/range-date/{startDate}/{endDate}", method = RequestMethod.GET)
	public List<Showtime> getShowtimeByRangeDate(@PathVariable(value = "startDate") Date startDate,
			@PathVariable(value = "endDate") Date endDate);

	@RequestMapping(value = "/avai-showtimes", method = RequestMethod.GET)
	public List<Showtime> getAvaiShowtimes();
	
	@RequestMapping(value = "/avai-showtimes/range-date/{startDate}/{endDate}", method = RequestMethod.GET)
	public List<Showtime> getAvaiShowtimesByRangeDate(@PathVariable(value = "startDate") Date startDate, @PathVariable(value = "endDate") Date endDate);
	
	@RequestMapping(value = "/showtimes/{theaterId}/{date}", method = RequestMethod.GET)
	public List<String> findAvailableTimeWithDateAndTheater(@PathVariable(value = "theaterId") long theaterId, @PathVariable(value = "date") Date date);
}
