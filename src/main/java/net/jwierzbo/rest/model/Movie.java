package net.jwierzbo.rest.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import net.jwierzbo.rest.validation.Name;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;


@ApiModel(value = "Movie")
public class Movie {

    @ApiModelProperty(notes = "The database generated product ID")
    private Long id;

    // example of default Bean validation
    @NotNull(message = "title can not be null")
    private String title;

    // example of custom Bean validation
    @Name(message = "Invalid director name - it has to start with uppercase!")
    private String director;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(notes = "Movie premiere date", example = "2018-02-28")
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