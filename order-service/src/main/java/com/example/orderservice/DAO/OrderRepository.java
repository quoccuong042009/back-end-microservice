package com.example.orderservice.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.orderservice.models.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

	List<Order> findByShowtimeId(long showtimeId);

	List<Order> findByUserId(long userId);
	
	List<Order> findByUserIdAndShowtimeId(long userId, long showtimeId);

}
