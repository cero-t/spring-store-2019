package ninja.cero.store.item;

import co.elastic.apm.attach.ElasticApmAttacher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;

@SpringBootApplication
@EnableDiscoveryClient
@EnableJdbcRepositories
public class ItemApplication {
    public static void main(String[] args) {
        ElasticApmAttacher.attach();
        SpringApplication.run(ItemApplication.class, args);
    }
}
