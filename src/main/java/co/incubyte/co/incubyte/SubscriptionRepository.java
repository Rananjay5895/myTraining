package co.incubyte.co.incubyte;

import io.micronaut.data.annotation.Repository;
import io.micronaut.data.repository.CrudRepository;

@Repository
public interface SubscriptionRepository extends CrudRepository <Subscriber , Long> {
}
