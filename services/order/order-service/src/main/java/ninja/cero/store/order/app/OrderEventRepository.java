package ninja.cero.store.order.app;

import ninja.cero.store.order.domain.OrderEvent;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface OrderEventRepository extends CrudRepository<OrderEvent, String> {
}
