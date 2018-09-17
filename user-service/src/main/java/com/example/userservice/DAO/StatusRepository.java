package com.example.userservice.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.userservice.models.Status;


@Repository
public interface StatusRepository extends JpaRepository<Status, Long>  {
	
}
