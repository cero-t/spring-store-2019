package ninja.cero.store.payment;

import co.elastic.apm.attach.ElasticApmAttacher;
import ninja.cero.store.payment.app.PaymentSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableBinding(PaymentSource.class)
@EnableJdbcRepositories
public class PaymentApplication {
	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(PaymentApplication.class, args);
	}
}
