package com.example.theaterservice.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.theaterservice.models.Theater;

@Repository
public interface TheaterRepository extends JpaRepository<Theater, Long>{
	public Theater findByName(String name);
}
