package ninja.cero.store.payment.client;

import ninja.cero.store.payment.domain.Payment;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class PaymentClient {
    private static final String PAYMENT_URL = "http://payment-service";

    RestTemplate restTemplate;

    ParameterizedTypeReference<List<Payment>> type = new ParameterizedTypeReference<>() {
    };

    public PaymentClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public void check(Payment payment) {
        restTemplate.postForObject(PAYMENT_URL + "/check", payment, Void.class);
    }

    public void processPayment(Payment payment) {
        restTemplate.postForObject(PAYMENT_URL, payment, Void.class);
    }

    public List<Payment> findAll() {
        return restTemplate.exchange(PAYMENT_URL, HttpMethod.GET, null, type).getBody();
    }
}
