package com.example.movieservice.DAO;

import java.util.List;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.movieservice.models.Theater;

@FeignClient(name="theater-service")
@RibbonClient(name="theater-service")
public interface TheaterProxy {
	
	@RequestMapping(value = "/theaters", method = RequestMethod.GET)
	public List<Theater> getAllTheaters();
	
	@RequestMapping(value = "/theater/{id}", method = RequestMethod.GET)
	public Theater getTheaterById(@PathVariable(value = "id") long id);
}
