package co.incubyte.co.incubyte;

import io.micronaut.context.annotation.Bean;

import java.util.List;

@Bean
public class MovieService {
    private MovieGateway movieGateway;

    public MovieService(MovieGateway movieGateway) {

        this.movieGateway = movieGateway;
    }

    public List<Movie> find(String name) {
        TmdbResponse response = movieGateway.find(name);
        return response.getResults();
    }

    public MovieDetail findById(int id) {
       return movieGateway.findById(id);
    }
}
