package com.example.showtimeservice.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.showtimeservice.DAO.MovieProxy;
import com.example.showtimeservice.DAO.OrderProxy;
import com.example.showtimeservice.DAO.ShowtimeRepository;
import com.example.showtimeservice.DAO.TheaterProxy;
import com.example.showtimeservice.models.Movie;
import com.example.showtimeservice.models.Order;
import com.example.showtimeservice.models.Showtime;
import com.example.showtimeservice.models.Status;

@Service
public class ShowtimeService {
	@Autowired
	ShowtimeRepository showtimeRepository;

	@Autowired
	MovieProxy movieProxy;

	@Autowired
	TheaterProxy theaterProxy;

	@Autowired
	OrderProxy orderProxy;

	public List<Showtime> findAll() {
		return showtimeRepository.findAll();
	}

	public List<Showtime> findShowtimeByMovieId(long id) {
		return showtimeRepository.findShowtimeByMovieId(id);
	}

	public Showtime getShowtimeByShowtimeId(long showtimeId) {
		return showtimeRepository.getOne(showtimeId);
	}

	public List<Showtime> getShowtimeByRangeDate(Date startDate, Date endDate) {
		return showtimeRepository.findByDateRange(startDate, endDate);
	}

	public List<Showtime> getShowtimesByGenreId(long genreId) {
		List<Movie> movies = movieProxy.getMovieByGenreId(genreId);
		List<Showtime> res = new ArrayList<>();

		for (Movie m : movies) {
			List<Showtime> temp = showtimeRepository.findShowtimeByMovieId(m.getMovieId());

			res.addAll(temp);
		}

		return res;
	}

	// ===========FOR BOOKING =========
	public List<Showtime> findTimeslotByMovieIdAndDate(long movieId, Date date) {
		// TODO Auto-generated method stub
		return showtimeRepository.findByMovieIdAndDate(movieId, date);
	}

	public List<Showtime> getTheatersByMovieIdAndDateAndTime(long movieId, Date date, String slot) {
		// TODO Auto-generated method stub
		return showtimeRepository.findByMovieIdAndDateAndSlot(movieId, date, slot);
	}

	public Showtime findShowtimeByRest(long movieId, long theaterId, Date date, String slot) {
		// TODO Auto-generated method stub
		return showtimeRepository.findByMovieIdAndTheaterIdAndDateAndSlot(movieId, theaterId, date, slot);
	}

	// ===============FOR ADDING SHOWTIME====================================
	public List<String> findAvailableTimeWithDateAndTheater(long theaterId, Date date) {
		// TODO Auto-generated method stub
		List<Showtime> showtime = showtimeRepository.findByTheaterIdAndDate(theaterId, date);
		// Only get enable showtime
		showtime.removeIf(s -> s.getStatus().getStatusID() == 2);

		if (showtime.size() != 4) {
			List<String> availableTime = new ArrayList<>(Arrays.asList("1", "2", "3", "4"));

			for (Showtime s : showtime) {
				availableTime.remove(s.getSlot());
			}

			return availableTime;
		}

		return new ArrayList<>();
	}

	public String add(Showtime showtime) {
		Showtime temp = findShowtimeByRest(showtime.getMovieId(), showtime.getTheaterId(), showtime.getDate(),
				showtime.getSlot());

		if (temp != null) {
			Status status = new Status(1, "ENABLE");
			temp.setStatus(status);
			showtimeRepository.save(temp);
		} else {
			showtimeRepository.save(showtime);
		}

		return "Success";
	}

	// DISABLE SHOWTIME
	public String disableShowtime(Showtime showtime) {
		long time = System.currentTimeMillis();
		Date now = new Date(time);
		List<Order> orders = orderProxy.getOrdersByShowtimeId(showtime.getShowtimeId());

		if (orders.size() == 0 || showtime.getDate().before(now)) {
			showtimeRepository.save(showtime);
			return "Success";
		}
		return "Fail";
	}

	// GET AVAILABLE SHOWTIME
	public List<Showtime> getAvaiShowtimes() {
		return showtimeRepository.findAvaiShowtimes();
	}

	public List<Showtime> getAvaiShowtimesByRangeDate(Date startDate, Date endDate) {
		return showtimeRepository.findAvaiByDateRange(startDate, endDate);
	}
}
