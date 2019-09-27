package ninja.cero.store.order;

import co.elastic.apm.attach.ElasticApmAttacher;
import ninja.cero.store.order.app.OrderSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(OrderSource.class)
@EnableJdbcRepositories
public class OrderApplication {
	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(OrderApplication.class, args);
	}
}
