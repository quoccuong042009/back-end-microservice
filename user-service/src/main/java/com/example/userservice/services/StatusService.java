package com.example.userservice.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.userservice.DAO.StatusRepository;

@Service
public class StatusService {
	@Autowired
	StatusRepository statusRepository;
}
