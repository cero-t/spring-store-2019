package ninja.cero.store;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServer {
	public static void main(String[] args) {
		ElasticApmAttacher.attach();
		SpringApplication.run(GatewayServer.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/api/**")
						.filters(f -> f.rewritePath("/api/(?<path>.*)", "/${path}"))
						.uri("lb://store-web")
				)
				.route(r -> (r.path("/**"))
						.filters(f -> f.rewritePath("/?<path>.*", "/${path}"))
						.uri("http://localhost:8000")
				)
				.build();
	}
}
