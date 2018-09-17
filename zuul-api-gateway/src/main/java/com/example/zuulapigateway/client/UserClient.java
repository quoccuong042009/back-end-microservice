package com.example.zuulapigateway.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.zuulapigateway.models.User;


@FeignClient(name="user-service")
public interface UserClient {
	
	@RequestMapping(value = "/protected/user/{email}", method = RequestMethod.GET)
	public User getUserByEmail(@PathVariable("email") String email);
}
