package co.incubyte.co.incubyte;

import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.PathVariable;
import io.micronaut.http.annotation.QueryValue;

import java.util.List;

@Controller("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {

        this.movieService = movieService;
    }
    @Get()
    public List<Movie> find(@QueryValue("query") String name) {
       return movieService.find(name);
    }

    @Get("/{id}")
    public MovieDetail findById(@PathVariable int id) {
       return movieService.findById(id);
    }
}
