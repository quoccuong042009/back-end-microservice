package com.example.showtimeservice.DAO;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.showtimeservice.models.Showtime;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

	List<Showtime> findShowtimeByMovieId(long id);

	List<Showtime> findByMovieIdAndDate(long movieId, Date date);

	List<Showtime> findByMovieIdAndDateAndSlot(long movieId, Date date, String slot);

	Showtime findByMovieIdAndTheaterIdAndDateAndSlot(long movieId, long theaterId, Date date, String slot);
	
	@Query("SELECT s FROM Showtime s WHERE s.date BETWEEN :startDate AND :endDate") 
	public List<Showtime> findByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);

	List<Showtime> findByTheaterIdAndDate(long theaterId, Date date);
	
	@Query("SELECT s FROM Showtime s WHERE s.date >= CURRENT_DATE AND s.status.statusID = 1") 
	List<Showtime> findAvaiShowtimes();
	
	@Query("SELECT s FROM Showtime s WHERE s.date BETWEEN :startDate AND :endDate AND s.date >= CURRENT_DATE  AND s.status.statusID = 1") 
	public List<Showtime> findAvaiByDateRange(@Param("startDate") Date startDate, @Param("endDate") Date endDate);
}
