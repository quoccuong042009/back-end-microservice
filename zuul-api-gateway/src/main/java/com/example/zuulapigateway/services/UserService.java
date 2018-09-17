package com.example.zuulapigateway.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.zuulapigateway.client.UserClient;
import com.example.zuulapigateway.models.User;

@Service
public class UserService implements UserDetailsService{
	@Autowired
	UserClient userClient;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		System.out.println(email);
		User user = userClient.getUserByEmail(email);

        if(user == null || user.getStatus().getStatusID() == 2) {
            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", email));
        }

        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));

        UserDetails userDetails = new org.springframework.security.core.userdetails.
                User(user.getEmail(), user.getPassword(), authorities);

        return userDetails;
	}
}