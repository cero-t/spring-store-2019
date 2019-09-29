package ninja.cero.store.config;

import ninja.cero.store.cart.client.CartClient;
import ninja.cero.store.item.client.ItemClient;
import ninja.cero.store.order.client.OrderClient;
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
	ItemClient itemClient(RestTemplate restTemplate) {
		return new ItemClient(restTemplate);
	}

	@Bean
	StockClient stockClient(RestTemplate restTemplate) {
		return new StockClient(restTemplate);
	}

	@Bean
	CartClient cartClient(RestTemplate restTemplate) {
		return new CartClient(restTemplate);
	}

	@Bean
	OrderClient orderClient(RestTemplate restTemplate) {
		return new OrderClient(restTemplate);
	}
}
