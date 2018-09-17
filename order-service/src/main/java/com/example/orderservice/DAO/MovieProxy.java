package com.example.orderservice.DAO;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.orderservice.models.Movie;


@FeignClient(name="movie-service")
@RibbonClient(name="movie-service")
public interface MovieProxy {
	
	@RequestMapping(value = "/movie/{id}", method = RequestMethod.GET)
	public Movie getMovieById(@PathVariable(value = "id") long id);
	
	@RequestMapping(value = "/movies/genre/{id}", method = RequestMethod.GET)
	public List<Movie> getMovieByGenreId(@PathVariable(value = "id") long id);
	
	@RequestMapping(value = "/movie/title/{movieTitle}", method = RequestMethod.GET)
	public Movie getMovieByMovieTitle(@PathVariable(value = "movieTitle") String movieTitle);
}
