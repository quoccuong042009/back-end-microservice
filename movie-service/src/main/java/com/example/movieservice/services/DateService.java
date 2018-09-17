package com.example.movieservice.services;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class DateService {
	public List<Date> getNextNDate(int n){
		List<Date> dates = new ArrayList<>();
		
		Date now = new Date( new java.util.Date().getTime() );
		for(int i = 1 ; i <= n ; i++) {
			Date nextDate = new Date(now.getTime() + i*24*60*60*1000);
			dates.add(nextDate);
		}
		
		return dates;
	}
}
