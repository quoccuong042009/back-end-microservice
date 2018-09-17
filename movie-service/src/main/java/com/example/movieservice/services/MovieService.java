package com.example.movieservice.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.movieservice.DAO.MovieRepository;
import com.example.movieservice.DAO.ShowtimeProxy;
import com.example.movieservice.DAO.TheaterProxy;
import com.example.movieservice.models.Movie;
import com.example.movieservice.models.Showtime;
import com.example.movieservice.models.Theater;

@Service
public class MovieService {
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	DateService dateService;
	
	@Autowired
	ShowtimeProxy showtimeProxy;
	
	@Autowired
	TheaterProxy theaterProxy;

	public List<Movie> findAll() {
		return movieRepository.findAll();
	}

	public Movie findMovieById(long id) {
		return movieRepository.getOne(id);
	}
	
	public Movie findMovieByTitle(String title) {
		return movieRepository.findByMovieTitle(title);
	}

	public Movie save(Movie movie) {
		return movieRepository.save(movie);
	}

	public List<Movie> findByGenreId(long id) {
		return movieRepository.findByGenreId(id);
	}

	public List<Movie> findMovieByRangeDate(Date startDate, Date endDate) {
		return movieRepository.findMovieByRangeDate(startDate,endDate);
	}

	public List<Movie> getAvailableMovieByDate(Date date) {
		// TODO Auto-generated method stub
		return movieRepository.getAvailableMovieByDate(date);
	}
	
	public List<Movie> getAgetAvailableMovieByShowtime(){
		List<Showtime> showtimes = showtimeProxy.getAvaiShowtimes();
		List<Movie> movies = new ArrayList<>();
		
		for(Showtime s : showtimes) {
			Movie movie = movieRepository.getOne(s.getMovieId());
			
			if(!movies.contains(movie)) {
				movies.add(movie);
			}
		}
		
		return movies;
	}
	
	public List<Movie>  getAgetAvailableMovieByShowtimeAndGenreId(long genreId){
		List<Movie> movies = getAgetAvailableMovieByShowtime();
		
		movies.removeIf(m -> m.getGenre().getGenre_id() != genreId);
		
		return movies;
	}
	
	public List<Movie>  getAgetAvailableMovieByShowtimeAndDate(Date startDate, Date endDate){
		List<Showtime> showtimes = showtimeProxy.getAvaiShowtimesByRangeDate(startDate, endDate);
		
		List<Movie> movies = new ArrayList<>();
		
		for(Showtime s : showtimes) {
			Movie movie = movieRepository.getOne(s.getMovieId());
			
			if(!movies.contains(movie)) {
				movies.add(movie);
			}
		}
		
		return movies;
	}
	
	//==============GET Next day availble movie======
	public List<List<List<Movie>>> getNdayAvailableMovie(int n){
		List<List<List<Movie>>> res = new ArrayList<>();
		
		List<Theater> theaters = theaterProxy.getAllTheaters();
		
		List<Date> dates = dateService.getNextNDate(n);
		
		for(Theater t: theaters) {
			List<List<Movie>> theaterList = new ArrayList<>();
			for(Date d: dates) {
				List<Movie> movies = new ArrayList<>();
				List<String> avaiSlot = showtimeProxy.findAvailableTimeWithDateAndTheater(t.getTheaterId(), d);
				
				if(avaiSlot.size() != 0) {
					movies = getAvailableMovieByDate(d);
				}
				theaterList.add(movies);
			}
			
			res.add(theaterList);
		}
		
		return res;
	}
}
