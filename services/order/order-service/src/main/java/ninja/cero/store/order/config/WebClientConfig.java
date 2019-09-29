package ninja.cero.store.order.config;

import ninja.cero.store.cart.client.CartClient;
import ninja.cero.store.payment.client.PaymentClient;
import ninja.cero.store.stock.client.StockClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class WebClientConfig {
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

	@Bean
	CartClient cartClient(RestTemplate restTemplate) {
		return new CartClient(restTemplate);
	}

	@Bean
	StockClient stockClient(RestTemplate restTemplate) {
		return new StockClient(restTemplate);
	}

	@Bean
	PaymentClient paymentClient(RestTemplate restTemplate) {
		return new PaymentClient(restTemplate);
	}
}
