package ninja.cero.store.cart.config;

import ninja.cero.store.item.client.ItemClient;
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
}
