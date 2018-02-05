package net.jwierzbo.rest.controller;

import java.util.List;

import net.jwierzbo.rest.dao.MovieDAO;
import net.jwierzbo.rest.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieRestController {

	@Autowired
	private MovieDAO movieDAO;
	
	@GetMapping("/movies")
	public List getMovies() {
		return movieDAO.list();
	}

	@GetMapping("/movies/{id}")
	public ResponseEntity getMovie(@PathVariable("id") Long id) {
		Movie movie = movieDAO.get(id);
		if (movie == null) {
			return new ResponseEntity("No Movie found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(movie, HttpStatus.OK);
	}

	@PostMapping(value = "/movies")
	public ResponseEntity createCustomer(@RequestBody Movie movie) {
		movieDAO.create(movie);

		return new ResponseEntity(movie, HttpStatus.OK);
	}

	@DeleteMapping("/movies/{id}")
	public ResponseEntity deleteMovie(@PathVariable Long id) {
		if (null == movieDAO.delete(id)) {
			return new ResponseEntity("No Movie found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(id, HttpStatus.OK);

	}

	@PutMapping("/movies/{id}")
	public ResponseEntity updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
		movie = movieDAO.update(id, movie);

		if (null == movie) {
			return new ResponseEntity("No Movie found for ID " + id, HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity(movie, HttpStatus.OK);
	}

}