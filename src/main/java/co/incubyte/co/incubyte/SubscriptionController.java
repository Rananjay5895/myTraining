package co.incubyte.co.incubyte;

import io.micronaut.http.annotation.*;

@Controller("subscribe")
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    public SubscriptionController(SubscriptionService subscriptionService) {

        this.subscriptionService = subscriptionService;
    }
    @Post
    public Subscriber save(@Body Subscriber subscriber) {
       return subscriptionService.save(subscriber);
    }

    @Get("/subscriber/{id}")
    public Subscriber findByID(Long id) {
        return subscriptionService.findById(id);
    }
}
