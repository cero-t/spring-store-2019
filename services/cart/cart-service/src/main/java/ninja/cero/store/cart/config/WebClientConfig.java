package ninja.cero.store.cart.config;

import ninja.cero.store.item.client.ItemClient;
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
}
