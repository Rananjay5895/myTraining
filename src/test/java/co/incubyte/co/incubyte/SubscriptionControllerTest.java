package co.incubyte.co.incubyte;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@MicronautTest
public class SubscriptionControllerTest {

    @Inject
    @Client("/subscribe")
    HttpClient client;

    @Test
    @DisplayName("Should return Subscriber object on subscribe or save")
    public void should_return_subscriber_object_on_subscribe_or_save() {
        Subscriber subscriber = new Subscriber("rananjay.singh5895@gmail.com" , "Rananjay" , "Singh");
       Subscriber subscriberResponse = client.toBlocking().retrieve(HttpRequest.POST("/", subscriber),Subscriber.class);
       assertThat(subscriberResponse).isNotNull();
       assertThat(subscriberResponse.getEmail()).isNotNull();
       assertThat(subscriberResponse.getId()).isNotNull();
       assertThat(subscriberResponse.getFirstName()).isNotNull();
       assertThat(subscriberResponse.getLastName()).isNotNull();

       Subscriber response = client.toBlocking().retrieve(HttpRequest.GET("/subscriber/"+subscriberResponse.getId()),Subscriber.class);
        assertThat(response.getId()).isNotNull();
        assertThat(response.getEmail()).isNotNull();
        assertThat(response.getFirstName()).isNotNull();
        assertThat(response.getLastName()).isNotNull();
    }

}
