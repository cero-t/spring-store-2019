package ninja.cero.store;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.beans.factory.annotation.Value;
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

	@Value("${ui.url}")
	private String uiURL;

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		System.out.println("★★★★★★" + uiURL);
		return builder.routes()
				.route(r -> r.path("/api/**")
						.filters(f -> f.rewritePath("/api/(?<path>.*)", "/${path}"))
						.uri("lb://store-web")
				)
				.route(r -> (r.path("/**"))
						.filters(f -> f.rewritePath("/(?<path>.*)", "/${path}"))
						.uri(uiURL)
				)
				.build();
	}
}
