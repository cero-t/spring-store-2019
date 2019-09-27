package ninja.cero.store.order.config;

import ninja.cero.store.cart.client.CartClient;
import ninja.cero.store.payment.client.PaymentClient;
import ninja.cero.store.stock.client.StockClient;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancerExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {
	@Bean
	WebClient webClient(LoadBalancerExchangeFilterFunction lbFunction) {
		return WebClient.builder().filter(lbFunction).build();
	}

	@Bean
	CartClient cartClient(WebClient webClient) {
		return new CartClient(webClient);
	}

	@Bean
	StockClient stockClient(WebClient webClient) {
		return new StockClient(webClient);
	}

	@Bean
	PaymentClient paymentClient(WebClient webClient) {
		return new PaymentClient(webClient);
	}
}
