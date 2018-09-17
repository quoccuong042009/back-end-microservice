/**
 * 
 */
/**
 * @author cuonglam
 *
 */
package com.example.userservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userservice.DAO.UserRepository;
import com.example.userservice.models.User;

@Service
public class UserService{
	@Autowired
	UserRepository userRepository;
	
	public List<User> findAllButAdmin(){
		List<User> user = userRepository.findAll();
		
		user.removeIf(res -> res.getRole().getRoleId() == 1);
		
		return user;
	}
	
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
//	@Override
//	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//		User user = userRepository.findByEmail(email);
//
//        if(user == null) {
//            throw new UsernameNotFoundException(String.format("The username %s doesn't exist", email));
//        }
//
//        List<GrantedAuthority> authorities = new ArrayList<>();
//        authorities.add(new SimpleGrantedAuthority(user.getRole().getRole()));
//
//        UserDetails userDetails = new org.springframework.security.core.userdetails.
//                User(user.getEmail(), user.getPassword(), authorities);
//
//        return userDetails;
//	}
	public User save(User user) {
		return userRepository.save(user);
	}
	
	public User findUserById(long id) {
		return userRepository.getOne(id);
	}
	
	
}