package com.example.movieservice.controllers;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.movieservice.models.Genre;
import com.example.movieservice.models.Movie;
import com.example.movieservice.services.DateService;
import com.example.movieservice.services.GenreService;
import com.example.movieservice.services.MovieService;

@RestController
public class MovieServiceController {
	@Autowired
	MovieService movieService;
	
	@Autowired
	DateService dateService;
	
	@Autowired
	GenreService genreService;

//	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STANDARD_USER')")
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public List<Movie> getAllMovies() {
		return movieService.findAll();
	}
	
	@RequestMapping(value = "/avai-movies", method = RequestMethod.GET)
	public List<Movie> getAvaiMovies() {
		return movieService.getAgetAvailableMovieByShowtime();
	}
	
	@RequestMapping(value = "/avai-movies/genreId/{genreId}", method = RequestMethod.GET)
	public List<Movie> getAvaiMoviesByGenreId(@PathVariable(value = "genreId") long genreId) {
		return movieService.getAgetAvailableMovieByShowtimeAndGenreId(genreId);
	}
	
	@RequestMapping(value = "/avai-movies/range-date/{startDate}/{endDate}", method = RequestMethod.GET)
	public List<Movie> getAgetAvailableMovieByShowtimeAndDate(@PathVariable Date startDate, @PathVariable Date endDate) {
		return movieService.getAgetAvailableMovieByShowtimeAndDate(startDate,endDate);
	}
	
//	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STANDARD_USER')")
	@RequestMapping(value = "/movies/genre/{id}", method = RequestMethod.GET)
	public List<Movie> getMovieByGenreId(@PathVariable(value = "id") long id) {
		return movieService.findByGenreId(id);
	}
	
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
	public Movie getMovieById(@PathVariable(value = "id") long id) {
		return movieService.findMovieById(id);
	}

	
	
	@RequestMapping(value = "/movie/title/{movieTitle}", method = RequestMethod.GET)
	public Movie getMovieByMovieTitle(@PathVariable(value = "movieTitle") String movieTitle) {
		return movieService.findMovieByTitle(movieTitle);
	}
	
	@RequestMapping(value = "movies/range-date/{startDate}/{endDate}", method = RequestMethod.GET)
	public List<Movie> getMovieByRangeDate(@PathVariable Date startDate, @PathVariable Date endDate) {
		return movieService.findMovieByRangeDate(startDate,endDate);
	}
	//================EDIT AND ADD===============================
	@RequestMapping(value = "admin/movie/add", method = RequestMethod.POST)
	public String addMovie(@Valid @RequestBody Movie movieDetails) {
		if(movieService.findMovieByTitle(movieDetails.getMovieTitle()) != null)
			return "This movie has already exsisted";
		else {
			movieService.save(movieDetails);
			return "success";
		}
	}

	@RequestMapping(value = "admin/movie/edit/{id}", method = RequestMethod.PUT)
	public String editMovie(@PathVariable(value = "id") long id,
            @Valid @RequestBody Movie movieDetails) {
		Movie movie = movieService.findMovieById(id);
		movie = movieDetails;
		
		movieService.save(movie);
		return null;
	}
	
	@RequestMapping(value = "admin/movies/date/{date}", method = RequestMethod.GET)
	public List<Movie> getAvailableMovieByDate(@PathVariable(value = "date") Date date){
		return movieService.getAvailableMovieByDate(date);
	}
	
	//================ GENRE ====================================
	@RequestMapping(value = "/genres", method = RequestMethod.GET)
	public List<Genre> getAllGenres() {
		return genreService.findAll();
	}
	
	@RequestMapping(value = "/genre/{genreId}", method = RequestMethod.GET)
	public Genre getGenreByGenreId(@PathVariable long genreId) {
		return genreService.findGenreByGenreId(genreId);
	}
 	
	//================ DATE ====================================
	@RequestMapping(value = "/dates/{n}", method = RequestMethod.GET)
	public List<Date> getNNextDate(@PathVariable int n) {
		return dateService.getNextNDate(n);
	}
	
	//================ GET AVAI MOVIE IN N DATE ====================================
	@RequestMapping(value = "/movies/next-date/{n}", method = RequestMethod.GET)
	public List<List<List<Movie>>> getAvaiMoviesForNextNdate(@PathVariable int n) {
		return movieService.getNdayAvailableMovie(n);
	}
}
