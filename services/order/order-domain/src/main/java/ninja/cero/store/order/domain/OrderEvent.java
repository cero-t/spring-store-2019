package ninja.cero.store.order.domain;

import org.springframework.data.annotation.Id;

import java.sql.Timestamp;

public class OrderEvent {
	@Id
	public Long id;

	public Long orderId;

	public String eventType;

	public Timestamp eventTime;
}
