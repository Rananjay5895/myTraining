package co.incubyte.co.incubyte;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SubscriptionControllerShould {

    @Mock
    SubscriptionService subscriptionService;

    @Test
    @DisplayName("Should invoke save method of service")
    public void should_invoke_save_method_of_service() {
        SubscriptionController subscriptionController = new SubscriptionController(subscriptionService);
        Subscriber subscriber = new Subscriber("rananjay.singh5895@gmail.com" , "Rananjay" , "Singh");
        subscriptionController.save(subscriber);
        verify(subscriptionService).save(subscriber);
    }

    @Test
    @DisplayName("should invoke get by id method of service")
    public void should_invoke_get_by_id_method_of_service() {
        SubscriptionController subscriptionController = new SubscriptionController(subscriptionService);
        Subscriber subscriber = new Subscriber("rananjay.singh5895@gmail.com" , "Rananjay" , "Singh");
        when(subscriptionService.findById(1L)).thenReturn(subscriber);
        Subscriber mySubscriber = subscriptionController.findByID(1L);
        verify(subscriptionService).findById(1L);
        assertThat(mySubscriber.getFirstName()).isNotNull();

    }
}
