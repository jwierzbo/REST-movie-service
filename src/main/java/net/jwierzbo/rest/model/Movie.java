package net.jwierzbo.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Movie {

	private Long id;
	private String title;
	private String director;

	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate releaseDate;

	public Movie(long id, String title, String director, LocalDate releaseDate) {
		this.id = id;
		this.title = title;
		this.director = director;
		this.releaseDate = releaseDate;
	}

	public Movie() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public LocalDate getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(LocalDate releaseDate) {
		this.releaseDate = releaseDate;
	}

}