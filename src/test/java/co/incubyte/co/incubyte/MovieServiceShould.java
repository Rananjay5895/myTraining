package co.incubyte.co.incubyte;

import org.assertj.core.api.Assertions;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceShould {

    @Mock
    MovieGateway movieGateway;


    @Test
    @DisplayName("Should return list of movies on find method ")
    public void should_return_list_of_movies_on_find_method() {
        // arrange
//        MovieService movieService = new MovieService(movieGateway);
//        Movie movie = new Movie("Forrest Gump", "snfhfh", "12-01-02",1.2f,12);
//        TmdbResponse response = new TmdbResponse(1, Lists.list(movie));
//        when(movieGateway.find("Forrest Gump")).thenReturn(response);

        // act
//        List<Movie> movies = movieService.find("Forrest Gump");

        //
//        assertThat();


        // arrange
        MovieService service = new MovieService(movieGateway);
        Movie movie = new Movie("Forrest Gump", "snfhfh", "12-01-02",1.2f,12,1);
        TmdbResponse response = new TmdbResponse(1, Lists.list(movie));
        when(movieGateway.find("Forrest Gump")).thenReturn(response);

        // act
        List<Movie> movies = service.find("Forrest Gump");

        // assert
        verify(movieGateway).find("Forrest Gump");
        assertThat(movies).isNotNull();
        assertThat(movies.get(0)).isEqualTo(movie);
    }

    @Test
    @DisplayName("Should invoke find by id method of gateway")
    public void should_invoke_find_by_id_method_of_gateway() {
        MovieService service = new MovieService(movieGateway);
        MovieDetail movieDetail = new MovieDetail(13, "Forrest Gump", "/9xjZS2rlVxm8SFx8kPC3aIGCOYQ.jpg", "1997-11-18", 7.876f, 21628, "abchdhjd", "/3WjbxaqYB4vAbdUfdr5vbglD2JZ.jpg", 149.117f, "en");
        when(movieGateway.findById(13)).thenReturn(movieDetail);
       MovieDetail movie = service.findById(13);
        verify(movieGateway).findById(13);
        assertThat(movie.getLanguage()).isNotNull();

    }
}
