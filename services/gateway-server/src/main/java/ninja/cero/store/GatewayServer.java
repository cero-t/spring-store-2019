package ninja.cero.store;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewayServer {
	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(GatewayServer.class, args);
	}
}
