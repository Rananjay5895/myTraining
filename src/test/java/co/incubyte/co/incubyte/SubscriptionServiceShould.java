package co.incubyte.co.incubyte;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SubscriptionServiceShould {
    @Mock
    private SubscriptionRepository subscriptionRepository;

    @Test
    @DisplayName("Should invoke save method of repository")
    public void should_invoke_save_method_of_repository() {
        SubscriptionService subscriptionService = new SubscriptionService(subscriptionRepository);
        Subscriber subscriber = new Subscriber("rananjay.singh5895@gmail.com" , "Rananjay" , "Singh");
        subscriptionService.save(subscriber);
        verify(subscriptionRepository).save(subscriber);
    }

    @Test
    @DisplayName("Should invoke find by id method of Subscription Repository")
    public void should_invoke_find_by_id_method_of_subscription_repository() {
        when(subscriptionRepository.findById(1L)).thenReturn(Optional.of(new Subscriber()));
        SubscriptionService subscriptionService = new SubscriptionService(subscriptionRepository);
        subscriptionService.findById(1L);
        verify(subscriptionRepository).findById(1L);
    }
}
