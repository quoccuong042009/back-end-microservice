package com.example.showtimeservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.showtimeservice.DAO.MovieProxy;
import com.example.showtimeservice.DAO.ShowtimeRepository;
import com.example.showtimeservice.DAO.TheaterProxy;
import com.example.showtimeservice.models.Movie;
import com.example.showtimeservice.models.Showtime;
import com.example.showtimeservice.models.ShowtimeDetail;
import com.example.showtimeservice.models.Theater;

@Service 
public class ShowtimeDetailService {
	@Autowired
	ShowtimeRepository showtimeRepository;
	
	@Autowired
	MovieProxy movieProxy;
	
	@Autowired
	TheaterProxy theaterProxy;
	
	public List<ShowtimeDetail> getShowtimedetailByShowtimes(List<Showtime> showtimes){
		List<ShowtimeDetail> ShowtimeDetails = new ArrayList<>();
		
		for(Showtime s: showtimes) {
			Movie movie = movieProxy.getMovieById(s.getMovieId());
			Theater theater = theaterProxy.getTheaterById(s.getTheaterId());
			
			ShowtimeDetail temp = new ShowtimeDetail(
					s.getShowtimeId(),
					movie.getMovieTitle(),
					theater.getName(),
					movie.getGenre(),
					s.getDate(),
					s.getSlot(),
					s.getStatus());
			
			ShowtimeDetails.add(temp);
		}
		
		return ShowtimeDetails;
	}
}
