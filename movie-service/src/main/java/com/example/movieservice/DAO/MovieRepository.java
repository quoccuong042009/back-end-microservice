package com.example.movieservice.DAO;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.movieservice.models.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

	public Movie findByMovieTitle(String title);
	
	@Query("SELECT m FROM Movie m where m.genre.genre_id = :id") 
	public List<Movie> findByGenreId(@Param("id") Long id);
	
	@Query("SELECT m FROM Movie m WHERE :startDate BETWEEN m.startDate AND m.endDate OR :endDate BETWEEN m.startDate AND m.endDate") 
	public List<Movie> findMovieByRangeDate(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
	
	@Query("SELECT m FROM Movie m WHERE :date BETWEEN m.startDate AND m.endDate") 
	public List<Movie> getAvailableMovieByDate(@Param("date") Date date);

}
