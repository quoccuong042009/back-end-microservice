/**
 * 
 */
/**
 * @author cuonglam
 *
 */
package com.example.userservice.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.userservice.models.User;
import com.example.userservice.services.UserService;

@RestController
public class UserServiceController {
	UserService userService;

	@Autowired
	public void UserController(UserService u) {
		userService = u;
	}	
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
//	PROTECTED

	@RequestMapping(value = "/protected/users", method = RequestMethod.GET)
//	@PreAuthorize("hasAuthority('ADMIN')")
	public List<User> getAllUser() {
		return userService.findAllButAdmin();
	}
	
	@RequestMapping(value = "/protected/user/password/{id}", method = RequestMethod.PUT)
//	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STANDARD_USER')")
	public String updatePassword(@PathVariable(value = "id") long id,
            @Valid @RequestBody User userDetails) {
		User user = userService.findUserById(id);

		user.setPassword(encoder().encode(userDetails.getPassword()));

		userService.save(user);
	    return "Success";
	}
	
	@RequestMapping(value = "/protected/user/status/{id}", method = RequestMethod.PUT)
//	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STANDARD_USER')")
	public String updateStatus(@PathVariable(value = "id") long id,
            @Valid @RequestBody User userDetails) {
		User user = userService.findUserById(id);
		user.setStatus_id(userDetails.getStatus());

		userService.save(user);
	    return "Success";
	}
	

//	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STANDARD_USER')")
	@RequestMapping(value = "/protected/user/{email}", method = RequestMethod.GET)
	public User getUserByEmail(@PathVariable("email") String email) {
		return userService.findUserByEmail(email);
	}
	
	@RequestMapping(value = "/protected/user/id/{userId}", method = RequestMethod.GET)
//	@PreAuthorize("hasAuthority('ADMIN') or hasAuthority('STANDARD_USER')")
	public User getUserByUserId(@PathVariable("userId") long userId) {
		return userService.findUserById(userId);
	}
	
	
//	PUBLIC
	@RequestMapping(value = "/public/add-user", method = RequestMethod.POST)
	public String addUser(@Valid @RequestBody User user) {
		if(userService.findUserByEmail(user.getEmail()) != null){
	        return "Email have already existed";
	    }
	    else{
	    	user.setPassword(encoder().encode(user.getPassword()));
	    	userService.save(user);
	        return "Created";
	    }
	}
	
	
}