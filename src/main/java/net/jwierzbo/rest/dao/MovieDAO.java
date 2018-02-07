package net.jwierzbo.rest.dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import net.jwierzbo.rest.model.Movie;
import org.springframework.stereotype.Component;

@Component
public class MovieDAO {

    private final AtomicLong counter = new AtomicLong();

    private static List<Movie> movies;

    {
        movies = new ArrayList();
        movies.add(new Movie(counter.incrementAndGet(), "Django", "Quentin Tarantino",
                LocalDate.of(2012, 12, 11)));
        movies.add(new Movie(counter.incrementAndGet(), "Gran Torino", "Clint Eastwood",
                LocalDate.of(2008, 12, 9)));
        movies.add(new Movie(counter.incrementAndGet(), "Taxi Driver", "Martin Scorsese",
                LocalDate.of(1976, 02, 8)));
    }

    public List<Movie> list() {
        return movies;
    }

    public Optional<Movie> get(Long id) {

        for (Movie c : movies) {
            if (c.getId().equals(id)) {
                return Optional.of(c);
            }
        }
        return Optional.empty();
    }

    public Movie create(Movie movie) {
        movie.setId(counter.incrementAndGet());
        movies.add(movie);
        return movie;
    }

    public Long delete(Long id) {

        for (Movie c : movies) {
            if (c.getId().equals(id)) {
                movies.remove(c);
                return id;
            }
        }

        return null;
    }

    public Movie update(Long id, Movie movie) {

        for (Movie c : movies) {
            if (c.getId().equals(id)) {
                movie.setId(c.getId());
                movies.remove(c);
                movies.add(movie);
                return movie;
            }
        }

        return null;
    }

}