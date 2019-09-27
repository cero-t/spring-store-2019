package ninja.cero.store.order.client;

import ninja.cero.store.order.domain.OrderEvent;
import ninja.cero.store.order.domain.OrderInfo;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public class OrderClient {
	private static final String ORDER_URL = "http://order-service";

	WebClient webClient;

	public OrderClient(WebClient webClient) {
		this.webClient = webClient;
	}

	public void createOrder(OrderInfo order) {
		webClient.post().uri(ORDER_URL).syncBody(order).exchange().block();
	}

	public void createEvent(OrderEvent orderEvent) {
		webClient.post().uri(ORDER_URL + "/" + orderEvent.orderId + "/event").syncBody(orderEvent).exchange().block();
	}

	public List<OrderEvent> findAllEvents() {
		return webClient.get().uri(ORDER_URL + "/events").retrieve().bodyToFlux(OrderEvent.class).collectList().block();
	}
}
