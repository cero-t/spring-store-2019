package ninja.cero.store.item.client;

import ninja.cero.store.item.domain.Item;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ItemClient {
    private static final String ITEM_URL = "http://item-service";

    RestTemplate restTemplate;

    ParameterizedTypeReference<List<Item>> type = new ParameterizedTypeReference<>() {
    };

    public ItemClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Item> findAll() {
        return restTemplate.exchange(ITEM_URL, HttpMethod.GET, null, type).getBody();
    }

    public List<Item> findByIds(Collection<Long> ids) {
        String idString = ids.stream().map(Object::toString)
                .collect(Collectors.joining(","));
        return restTemplate.exchange(ITEM_URL + "/" + idString, HttpMethod.GET, null, type).getBody();
    }
}
