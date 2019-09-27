package ninja.cero.store;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class StoreApplication {
	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(StoreApplication.class, args);
	}
}
