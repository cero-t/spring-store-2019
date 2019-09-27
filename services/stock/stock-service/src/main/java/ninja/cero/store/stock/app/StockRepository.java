package ninja.cero.store.stock.app;

import ninja.cero.store.stock.domain.Stock;
import org.springframework.data.jdbc.repository.query.Modifying;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface StockRepository extends CrudRepository<Stock, Long> {
	@Modifying
	@Query("update stock s set s.quantity = s.quantity + :quantity where s.item_id = :id")
	public Integer add(@Param("id") Long id, @Param("quantity") int quantity);

	@Modifying
	@Query("update stock s set s.quantity = s.quantity - :quantity where s.item_id = :id and s.quantity > :quantity")
	public Integer subtractIfPossible(@Param("id") Long id, @Param("quantity") int quantity);
}
