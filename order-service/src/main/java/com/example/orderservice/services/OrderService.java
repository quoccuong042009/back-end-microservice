package com.example.orderservice.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderservice.DAO.MovieProxy;
import com.example.orderservice.DAO.OrderRepository;
import com.example.orderservice.DAO.ShowtimeProxy;
import com.example.orderservice.DAO.UserProxy;
import com.example.orderservice.models.Movie;
import com.example.orderservice.models.Order;
import com.example.orderservice.models.Showtime;
import com.example.orderservice.models.Status;
import com.example.orderservice.models.User;

@Service
public class OrderService {
	@Autowired
	OrderRepository orderRepository;

	@Autowired
	MovieProxy movieProxy;

	@Autowired
	ShowtimeProxy showtimeProxy;
	
	@Autowired
	UserProxy userProxy;

	public List<Order> getAllOrders() {
		return orderRepository.findAll();
	}

	//======================GET ENABLE ORDER FOR CALCULATING AVAILABLE SEAT=================
	public List<Order> getOrdersByShowtimeId(long showtimeId) {
		List<Order> orders = orderRepository.findByShowtimeId(showtimeId);
		orders.removeIf(p -> p.getStatusId().getStatusID() == 2);
	
		return orders;
	}
	//=======================================================================================
	public List<Order> getOrdersByUserId(long userId) {
		return orderRepository.findByUserId(userId);
	}

	public Order getOrderByOrderId(long orderId) {
		return orderRepository.getOne(orderId);
	}

	public String save(@Valid Order order) {
		List<Order> orders = getOrdersByShowtimeId(order.getShowtimeId());
		String[] selectedSeat = order.getSeats().split(",");
		
		for(Order o : orders) {
			String[] takenSeat = o.getSeats().split(",");
			if(Same(selectedSeat, takenSeat))
				return "Failed";
			
		}

		orderRepository.save(order);
		return "Success";
	}
	
	public boolean Same(String[] arr1, String[] arr2) {
		boolean res;
		
		if(arr1.length > arr2.length) {
			for(String s : arr1) {
				if(Arrays.asList(arr2).contains(s)) {
					return true;
				}
			}
		}
		else {
			for(String s : arr2) {
				if(Arrays.asList(arr1).contains(s)) {
					return true;
				}
			}
		}
		
	    return false;
	}

	public List<Order> getOrdersByGenreId(long userId, long genreId) {
		List<Movie> movies = movieProxy.getMovieByGenreId(genreId);
		List<Showtime> showtimes = new ArrayList<>();
		List<Order> result = new ArrayList<>();
		
		for (Movie m : movies) {
			showtimes.addAll(showtimeProxy.getShowtimesByMovieId(m.getMovieId()));
		}
		
		for(Showtime s : showtimes) {
			result.addAll(orderRepository.findByShowtimeId(s.getShowtimeId()));
		}
		
		result.removeIf(p -> p.getUserId() != userId);
		
		return result;
	}
	
	public List<Order> getOrdersByMovieTitle(long userId, String movieTitle) {
		Movie movie = movieProxy.getMovieByMovieTitle(movieTitle);
		List<Showtime> showtimes = new ArrayList<>();
		List<Order> result = new ArrayList<>();
		
		showtimes.addAll(showtimeProxy.getShowtimesByMovieId(movie.getMovieId()));
		
		for(Showtime s : showtimes) {
			result.addAll(orderRepository.findByShowtimeId(s.getShowtimeId()));
		}
		
		result.removeIf(p -> p.getUserId() != userId);
		return result;
	}
	
	public List<Order> getOrdersByDate(long userId, Date startDate, Date endDate) {
		List<Showtime> showtimes = showtimeProxy.getShowtimeByRangeDate(startDate, endDate);
		List<Order> result = new ArrayList<>();
		
		for(Showtime s : showtimes) {
			result.addAll(orderRepository.findByShowtimeId(s.getShowtimeId()));
		}
		
		result.removeIf(p -> p.getUserId() != userId);
		
		return result;
	}
	
	//==========================ADMIN=================================
	public List<Order> getOrdersByEmail(String email){
		User user = userProxy.getUserByEmail(email);
		if(user != null)
			return getOrdersByUserId(user.getUserId());
		else 
			return new ArrayList<>();
	}
	
	public String cancelOrder(Order order) {
		orderRepository.save(order);
		return "success";
	}
	
	
	public List<Order> getOrdersByDateRangeAndEmail(String email, Date startDate, Date endDate){
		User user = userProxy.getUserByEmail(email);
		
		if(user == null) {
			return new ArrayList<Order>();
		}
		else {
			List<Order> orders = getOrdersByUserId(user.getUserId());
			
			List<Showtime> showtimes = showtimeProxy.getShowtimeByRangeDate(startDate, endDate);
			
			for(Showtime s : showtimes) {
				orders.removeIf(order -> order.getShowtimeId() != s.getShowtimeId());
			}
			
			return orders;
		}
	}
	
	public List<Order> getOrdersByDate(Date startDate, Date endDate){
		List<Showtime> showtimes = showtimeProxy.getShowtimeByRangeDate(startDate, endDate);
		List<Order> orders = new ArrayList<>();
		
		for(Showtime s : showtimes) {
			List<Order> o = orderRepository.findByShowtimeId(s.getShowtimeId());
			orders.addAll(o);
		}
		
		return orders;
	}
	
}
