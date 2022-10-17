package co.incubyte.co.incubyte;

import io.micronaut.context.annotation.Bean;

@Bean
public class SubscriptionService {

    private SubscriptionRepository subscriptionRepository;

    public SubscriptionService(SubscriptionRepository subscriptionRepository) {

        this.subscriptionRepository = subscriptionRepository;
    }

    public Subscriber save(Subscriber subscriber) {
       return subscriptionRepository.save(subscriber);
    }

    public Subscriber findById(Long id) {
        return subscriptionRepository.findById(id).get();
    }
}
