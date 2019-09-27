package ninja.cero.store.payment.app;

import ninja.cero.store.payment.domain.Payment;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface PaymentRepository extends CrudRepository<Payment, String> {
}
