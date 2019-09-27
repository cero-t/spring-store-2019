package ninja.cero.store.payment.client;

import ninja.cero.store.payment.domain.Payment;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

public class PaymentClient {
    private static final String PAYMENT_URL = "http://payment-service";

    WebClient webClient;

    public PaymentClient(WebClient webClient) {
        this.webClient = webClient;
    }

    public void check(Payment payment) {
        webClient.post()
                .uri(PAYMENT_URL + "/check")
                .syncBody(payment)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public void processPayment(Payment payment) {
        webClient.post()
                .uri(PAYMENT_URL)
                .syncBody(payment)
                .retrieve()
                .bodyToMono(Void.class)
                .block();
    }

    public List<Payment> findAll() {
        return webClient.get()
                .uri(PAYMENT_URL)
                .retrieve()
                .bodyToFlux(Payment.class)
                .collectList()
                .block();
    }
}
