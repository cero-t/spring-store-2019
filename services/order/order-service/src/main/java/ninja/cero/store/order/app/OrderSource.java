package ninja.cero.store.order.app;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface OrderSource {
	@Output
	MessageChannel order();
}
