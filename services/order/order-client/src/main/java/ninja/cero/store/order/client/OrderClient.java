package ninja.cero.store.order.client;

import ninja.cero.store.order.domain.OrderEvent;
import ninja.cero.store.order.domain.OrderInfo;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class OrderClient {
    private static final String ORDER_URL = "http://order-service";

    RestTemplate restTemplate;

    ParameterizedTypeReference<List<OrderEvent>> type = new ParameterizedTypeReference<>() {
    };

    public OrderClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void createOrder(OrderInfo order) {
        restTemplate.postForObject(ORDER_URL, order, Void.class);
    }

    public void createEvent(OrderEvent orderEvent) {
        restTemplate.postForObject(ORDER_URL + "/" + orderEvent.orderId + "/event", orderEvent, Void.class);
    }

    public List<OrderEvent> findAllEvents() {
        return restTemplate.exchange(ORDER_URL + "/events", HttpMethod.GET, null, type).getBody();
    }
}
