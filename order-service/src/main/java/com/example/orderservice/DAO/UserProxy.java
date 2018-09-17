package com.example.orderservice.DAO;

import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.orderservice.models.User;

@FeignClient(name="user-service")
@RibbonClient(name="user-service")
public interface UserProxy {
	
	@RequestMapping(value = "/protected/user/id/{userId}", method = RequestMethod.GET)
	public User getUserByUserId(@PathVariable("userId") long userId);
	
	@RequestMapping(value = "/protected/user/{email}", method = RequestMethod.GET)
	public User getUserByEmail(@PathVariable("email") String email);
}
