package net.jwierzbo.rest.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.jwierzbo.rest.dao.MovieDAO;
import net.jwierzbo.rest.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/*
* This is example Controller class with extended description for SwaggerApi
*  These @Api*** annotations are not necessary if we use @ResponseStatus
*  and @ResponseBody objects instead of generic response
*/

@Api(value="MovieController", description="List of favourite Movies")
@RestController
@RequestMapping("/v2")
public class MovieV2SwaggerController {

    @Autowired
    private MovieDAO movieDAO;

    @ApiOperation(value = "View a list of Movies", response = Movie.class, responseContainer = "List")
    @GetMapping("/movies")
    public List<Movie> getMovies() {
        return movieDAO.list();
    }

    @ApiOperation(value = "Search a Movie by ID",response = Movie.class)
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Not Found")})
    @GetMapping("/movies/{id}")
    public Movie getMovie(@PathVariable("id") Long id) {
        return movieDAO.get(id).get();
    }

    @ApiOperation(value = "Add new Movie",response = Movie.class)
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid input"),
            @ApiResponse(code = 404, message = "Not Found")})
    @ApiImplicitParams({
            // This can be write also as inline @ApiParam - example below in "deleteMovie"
            @ApiImplicitParam(name = "movie", value = "Movie object to add", required = true, dataType = "Movie",
                    paramType = "body")
    })
    @PostMapping(value = "/movies")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Movie createMovie(@RequestBody Movie movie) {
        return movieDAO.create(movie);
    }

    @ApiOperation(value = "Delete specific movie")
    @ApiResponses(value = {@ApiResponse(code = 404, message = "Not Found")})
    @DeleteMapping("/movies/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void deleteMovie(@ApiParam(value = "Movie ID", required = true) @PathVariable Long id) {
        movieDAO.delete(id);
    }

    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Invalid input"),
            @ApiResponse(code = 404, message = "Not Found")})
    @PutMapping("/movies/{id}")
    public Movie updateMovie(@PathVariable Long id, @RequestBody Movie movie) {
        return movieDAO.update(id, movie);
    }
}