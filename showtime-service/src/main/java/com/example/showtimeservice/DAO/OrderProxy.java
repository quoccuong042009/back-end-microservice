package com.example.showtimeservice.DAO;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.showtimeservice.models.Order;


@FeignClient(name="Order-service")
@RibbonClient(name="Order-service")
public interface OrderProxy {
	@RequestMapping(value = "/orders/showtime/{showtimeId}", method = RequestMethod.GET)
	public List<Order> getOrdersByShowtimeId(@PathVariable(value = "showtimeId") long showtimeId);
}
