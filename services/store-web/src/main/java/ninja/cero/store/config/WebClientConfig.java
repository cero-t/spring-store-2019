package ninja.cero.store.config;

import ninja.cero.store.cart.client.CartClient;
import ninja.cero.store.item.client.ItemClient;
import ninja.cero.store.order.client.OrderClient;
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
	ItemClient itemClient(WebClient webClient) {
		return new ItemClient(webClient);
	}

	@Bean
	StockClient stockClient(WebClient webClient) {
		return new StockClient(webClient);
	}

	@Bean
	CartClient cartClient(WebClient webClient) {
		return new CartClient(webClient);
	}

	@Bean
	OrderClient orderClient(WebClient webClient) {
		return new OrderClient(webClient);
	}
}
