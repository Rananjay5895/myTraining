package co.incubyte.co.incubyte;

import io.micronaut.core.type.Argument;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
public class MovieControllerTest {

    @Inject
    @Client("/movies")
    HttpClient client;

    @Test
    @DisplayName("Should return list of Movies on find method")
    public void should_return_list_of_movies_on_find_method() {
        List<Movie> movies = client.toBlocking().retrieve(HttpRequest.GET("?query=Forrest%20Gump"), Argument.listOf(Movie.class));
        assertThat(movies.size()).isGreaterThan(0);
        Movie movie = movies.get(0);
        assertThat(movie.getName()).isEqualTo("Forrest Gump");
        assertThat(movie.getImage()).isNotNull();
        assertThat(movie.getDate()).isNotNull();
        assertThat(movie.getRating()).isGreaterThan(0);
        assertThat(movie.getCount()).isGreaterThan(0);
        assertThat((movie.getId())).isNotNull();
    }

    @Test
    @DisplayName("Should find Movie details by id")
    public void should_find_movie_details_by_id() {
       MovieDetail movieDetail = client.toBlocking().retrieve(HttpRequest.GET("/13"),MovieDetail.class);
       assertThat(movieDetail).isNotNull();
       assertThat(movieDetail.getName()).isNotNull();
       assertThat(movieDetail.getImage()).isNotNull();
       assertThat(movieDetail.getDate()).isNotNull();
       assertThat(movieDetail.getCount()).isNotNull();
       assertThat(movieDetail.getRating()).isNotNull();
       assertThat(movieDetail.getDescription()).isNotNull();
       assertThat(movieDetail.getBackgroundImage()).isNotNull();
       assertThat(movieDetail.getPopularity()).isNotNull();
       assertThat(movieDetail.getLanguage()).isNotNull();
    }
}
