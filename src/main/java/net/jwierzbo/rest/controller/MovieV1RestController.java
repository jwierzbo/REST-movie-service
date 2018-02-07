package net.jwierzbo.rest.controller;

import java.util.List;

import net.jwierzbo.rest.dao.MovieDAO;
import net.jwierzbo.rest.exception.MovieNotFoundException;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieV1RestController {

    @Autowired
    private MovieDAO movieDAO;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<Movie> getMovies() {
        return movieDAO.list();
    }

    @ResponseBody // is redundant: @RestController adds it automatically
    @GetMapping("/movies/{id}") // shortcut for @RequestMapping
    public Movie getMovie(@PathVariable("id") Long id) {
        Movie movie = checkIfMovieExist(id);
        return movie;
    }

    // Example of use generic ResponseEntity instead of @ResponseStatus and @ResponseBody
    @PostMapping(value = "/movies")
    public ResponseEntity createMovie(@RequestBody Movie movie) {
        movieDAO.create(movie);
        return new ResponseEntity(movie, HttpStatus.CREATED);
    }

    @DeleteMapping("/movies/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteMovie(@PathVariable Long id) {
        checkIfMovieExist(id);
        movieDAO.delete(id);
    }

    @PutMapping("/movies/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        checkIfMovieExist(id);
        return movieDAO.update(id, movie);
    }

    private Movie checkIfMovieExist(Long id) {
        return movieDAO.get(id).orElseThrow(() -> new MovieNotFoundException(id));
    }

}