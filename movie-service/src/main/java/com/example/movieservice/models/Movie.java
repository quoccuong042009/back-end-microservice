package com.example.movieservice.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Movie")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Movie {
	@Id
	@GeneratedValue
	@Column(name = "movie_id", nullable = false)
	private long movieId;

	@Column(name = "title")
	private String movieTitle;

	@Column(name = "description")
	private String description;

	@ManyToOne
	@JoinColumn(name = "genre_id")
	private Genre genre;

	@Column(name = "start_date")
	private Date startDate;

	@Column(name = "end_date")
	private Date endDate;

	@Column(name = "picUrl")
	private String picUrl;

	public Movie() {

	}

	public Movie(long movieId, String movieTitle, String description, Genre genre, Date startDate, Date endDate,
			String picUrl) {
		super();
		this.movieId = movieId;
		this.movieTitle = movieTitle;
		this.description = description;
		this.genre = genre;
		this.startDate = startDate;
		this.endDate = endDate;
		this.picUrl = picUrl;
	}

	public long getMovieId() {
		return movieId;
	}

	public void setMovieId(long movieId) {
		this.movieId = movieId;
	}

	public String getMovieTitle() {
		return movieTitle;
	}

	public void setMovieTitle(String movieTitle) {
		this.movieTitle = movieTitle;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Genre getGenre() {
		return genre;
	}

	public void setGenre(Genre genre) {
		this.genre = genre;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	@Override
	public String toString() {
		return "Movie [movieId=" + movieId + ", movieTitle=" + movieTitle + ", description=" + description + ", genre="
				+ genre + ", startDate=" + startDate + ", endDate=" + endDate + ", picUrl=" + picUrl + "]";
	}

}
