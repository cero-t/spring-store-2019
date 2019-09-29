package ninja.cero.store.cart.client;

import ninja.cero.store.cart.domain.Cart;
import ninja.cero.store.cart.domain.CartDetail;
import ninja.cero.store.cart.domain.CartEvent;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class CartClient {
    private static final String CART_URL = "http://cart-service";

    RestTemplate restTemplate;

    ParameterizedTypeReference<List<Cart>> type = new ParameterizedTypeReference<>() {
    };

    public CartClient(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Cart> findAll() {
        return restTemplate.exchange(CART_URL, HttpMethod.GET, null, type).getBody();
    }

    public Cart findCartById(String cartId) {
        return restTemplate.getForObject(CART_URL + "/" + cartId, Cart.class);
    }

    public CartDetail findCartDetailById(String cartId) {
        return restTemplate.getForObject(CART_URL + "/" + cartId + "/detail", CartDetail.class);
    }

    public Cart createCart() {
        return restTemplate.postForObject(CART_URL, null, Cart.class);
    }

    public Cart addItem(String cartId, CartEvent cartEvent) {
        return restTemplate.postForObject(CART_URL + "/" + cartId, cartEvent, Cart.class);
    }

    public void removeItem(String cartId, Long itemId) {
        restTemplate.delete(CART_URL + "/" + cartId + "/" + "items" + "/" + itemId);
    }
}
