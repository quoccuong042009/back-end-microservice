package com.example.orderservice.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.orderservice.DAO.MovieProxy;
import com.example.orderservice.DAO.ShowtimeProxy;
import com.example.orderservice.DAO.TheaterProxy;
import com.example.orderservice.DAO.UserProxy;
import com.example.orderservice.models.Movie;
import com.example.orderservice.models.Order;
import com.example.orderservice.models.OrderDetail;
import com.example.orderservice.models.Showtime;
import com.example.orderservice.models.Theater;
import com.example.orderservice.models.User;

@Service
public class OrderDetailService {
	@Autowired
	MovieProxy movieProxy;
	
	@Autowired
	ShowtimeProxy showtimeProxy;
	
	@Autowired
	TheaterProxy theaterProxy;
	
	@Autowired
	UserProxy userProxy;
	
	@Autowired
	OrderService orderService;
	
//	public OrderDetail getOrderDetailByOrder(long orderId) {
//		Order order = orderService.getOrderByOrderId(orderId);
//		Showtime showtime = showtimeProxy.getShowtimeByShowtimeId(order.getShowtimeId());
//		Movie movie = movieProxy.getMovieById(showtime.getMovieId());
//		Theater theater = theaterProxy.getTheaterById(showtime.getTheaterId());
//		
//		OrderDetail orderDetail = new OrderDetail(order.getOrderId(),
//				movie.getMovieTitle(),
//				movie.getGenre().getGenre(),
//				showtime.getDate(),
//				theater.getName(), 
//				showtime.getSlot(), 
//				order.getSeats());
//		
//		return orderDetail;
//	}
	
	public List<OrderDetail> getOrderDetailByOrder(List<Order> orders) {
		List<OrderDetail> res = new ArrayList<>();
		
		for(Order o : orders) {
			Showtime showtime = showtimeProxy.getShowtimeByShowtimeId(o.getShowtimeId());
			Movie movie = movieProxy.getMovieById(showtime.getMovieId());
			Theater theater = theaterProxy.getTheaterById(showtime.getTheaterId());
			User user = userProxy.getUserByUserId(o.getUserId());
			
			OrderDetail orderDetail = new OrderDetail(o.getOrderId(),
					user.getEmail(),
					movie.getMovieTitle(),
					movie.getGenre().getGenre(),
					showtime.getDate(),
					theater.getName(), 
					showtime.getSlot(), 
					o.getSeats(),
					o.getStatusId());
			
			res.add(orderDetail);
		}
		
		return res;
	}
}
