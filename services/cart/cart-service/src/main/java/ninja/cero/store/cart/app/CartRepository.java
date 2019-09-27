package ninja.cero.store.cart.app;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface CartRepository extends CrudRepository<CartEntity, Long> {
}
