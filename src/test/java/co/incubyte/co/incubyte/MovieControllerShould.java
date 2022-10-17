package co.incubyte.co.incubyte;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class MovieControllerShould {

    @Mock
    MovieService movieService;

    @Test
    @DisplayName("Should Invoke Find Method Of Service")
    public void should_invoke_find_method_of_service() {

        MovieController movieController = new MovieController(movieService);
        movieController.find("Forrest Gump");
        verify(movieService).find("Forrest Gump");
    }

    @Test
    @DisplayName("Should invoke find by id method of service")
    public void should_invoke_find_by_id_method_of_service() {
        MovieController movieController = new MovieController(movieService);
        movieController.findById(13);
        verify(movieService).findById(13);

    }
}
