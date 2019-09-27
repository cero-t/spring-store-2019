package ninja.cero.store.order.app;

import ninja.cero.store.order.domain.OrderInfo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface OrderRepository extends CrudRepository<OrderInfo, String> {
}
