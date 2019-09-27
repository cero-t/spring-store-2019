package ninja.cero.store.item.client;

import ninja.cero.store.item.domain.Item;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class ItemClient {
	private static final String ITEM_URL = "http://item-service";

	WebClient webClient;

	public ItemClient(WebClient webClient) {
		this.webClient = webClient;
	}

	public List<Item> findAll() {
		return webClient.get()
				.uri(ITEM_URL)
				.retrieve()
				.bodyToFlux(Item.class)
				.collectList()
				.block();
	}

	public List<Item> findByIds(Collection<Long> ids) {
		String idString = ids.stream().map(Object::toString)
				.collect(Collectors.joining(","));
		return webClient.get()
				.uri(ITEM_URL + "/" + idString)
				.retrieve()
				.bodyToFlux(Item.class)
				.collectList()
				.block();
	}
}
