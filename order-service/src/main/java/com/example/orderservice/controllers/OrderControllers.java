package com.example.orderservice.controllers;

import java.sql.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.orderservice.models.Order;
import com.example.orderservice.models.OrderDetail;
import com.example.orderservice.services.OrderDetailService;
import com.example.orderservice.services.OrderService;

@RestController
// @CrossOrigin(origins = "http://localhost:4200")
public class OrderControllers {
	@Autowired
	OrderService orderService;

	@Autowired
	OrderDetailService orderDetailService;

	// protected
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	// @PreAuthorize("hasAuthority('ADMIN')")
	public List<Order> getAllOrders() {
		return orderService.getAllOrders();
	}

	@RequestMapping(value = "/protected/orders/user-id/{userId}", method = RequestMethod.GET)
	// @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STANDARD_USER')")
	public List<Order> getOrdersByUserId(@PathVariable long userId) {
		return orderService.getOrdersByUserId(userId);
	}

	@RequestMapping(value = "/protected/create-order", method = RequestMethod.POST)
	// @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STANDARD_USER')")
	public String createOrder(@Valid @RequestBody Order order) {
		return orderService.save(order);
	}

	// non-protected
	
	@RequestMapping(value = "/orders/showtime/{showtimeId}", method = RequestMethod.GET)
	public List<Order> getOrdersByShowtimeId(@PathVariable long showtimeId) {
		return orderService.getOrdersByShowtimeId(showtimeId);
	}
	//========================ORDER BY ELSE=====================================
	@RequestMapping(value = "/protected/orders/movie-title/{userId}/{movieTitle}", method = RequestMethod.GET)
	public List<Order> getOrdersByMovieTitle(@PathVariable long userId, @PathVariable String movieTitle) {
		return orderService.getOrdersByMovieTitle(userId, movieTitle);
	}
	
	@RequestMapping(value = "/protected/orders/genre/{userId}/{genreId}", method = RequestMethod.GET)
	public List<Order> getOrdersByGenreId(@PathVariable long userId, @PathVariable long genreId) {
		return orderService.getOrdersByGenreId(userId, genreId);
	}
	
	@RequestMapping(value = "/protected/orders/range-date/{userId}/{startDate}/{endDate}", method = RequestMethod.GET)
	public List<Order> getOrdersByDate(@PathVariable long userId, @PathVariable Date startDate, @PathVariable Date endDate) {
		return orderService.getOrdersByDate(userId, startDate, endDate);
	}
	//========================ORDER DETAIL=====================================
	
//	@RequestMapping(value = "/protected/orderdetail/{orderId}", method = RequestMethod.GET)
//	public OrderDetail getOrderDetailByOrder(@PathVariable long orderId) {
//		return orderDetailService.getOrderDetailByOrder(orderId);
//	}
	
	@RequestMapping(value = "/protected/orderdetail", method = RequestMethod.POST)
	public List<OrderDetail> getOrderDetailByOrder(@Valid @RequestBody List<Order> order) {
		return orderDetailService.getOrderDetailByOrder(order);
	}
		
	//========================ADMIN=====================================
	@RequestMapping(value = "/protected/order/cancel-order", method = RequestMethod.PUT)
	public String getOrderDetailByOrder(@Valid @RequestBody Order order) {
		return orderService.cancelOrder(order);
	}
	
	@RequestMapping(value = "/protected/orders/user-email/{email}", method = RequestMethod.GET)
	// @PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STANDARD_USER')")
	public List<Order> getOrdersByUserId(@PathVariable String email) {
		return orderService.getOrdersByEmail(email);
	}
	
	@RequestMapping(value = "/protected/orders/email-range-date/{email}/{startDate}/{endDate}", method = RequestMethod.GET)
	public List<Order> getOrdersByUserId(@PathVariable String email,@PathVariable Date startDate, @PathVariable Date endDate) {
		return orderService.getOrdersByDateRangeAndEmail(email, startDate, endDate);
	}
	
	@RequestMapping(value = "/protected/orders/date/{startDate}/{endDate}", method = RequestMethod.GET)
	public List<Order> getOrderByRangeDate(@PathVariable Date startDate, @PathVariable Date endDate){
		return orderService.getOrdersByDate(startDate, endDate);
	}
}
