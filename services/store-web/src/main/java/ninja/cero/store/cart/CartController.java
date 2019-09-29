package ninja.cero.store.cart;

import ninja.cero.store.cart.client.CartClient;
import ninja.cero.store.cart.domain.Cart;
import ninja.cero.store.cart.domain.CartDetail;
import ninja.cero.store.cart.domain.CartEvent;
import ninja.cero.store.stock.client.StockClient;
import ninja.cero.store.stock.domain.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/cart")
@CrossOrigin
public class CartController {
    @Autowired
    CartClient cartClient;

    @Autowired
    StockClient stockClient;

    @PostMapping
    public Cart createCart() {
        return cartClient.createCart();
    }

    @GetMapping("/{cartId}")
    public CartDetail findCart(@PathVariable String cartId) {
        return cartClient.findCartDetailById(cartId);
    }

    @PostMapping("/{cartId}")
    public CartDetail addEvent(@PathVariable String cartId, @RequestBody CartEvent cartEvent) {
        Cart cart = cartClient.findCartById(cartId);
        if (cart == null) {
            throw new RuntimeException("No valid cart");
        }

        List<Stock> stocks = stockClient.findByIds(Collections.singletonList(cartEvent.itemId));
        if (stocks.isEmpty()) {
            throw new RuntimeException("No stock info!");
        }

        if (stocks.get(0).quantity < cartEvent.quantity) {
            throw new RuntimeException("Not enough stock!");
        }

        cartClient.addItem(cartId, cartEvent);
        return cartClient.findCartDetailById(cartId);
    }

    @DeleteMapping("/{cartId}/{itemId}")
    public CartDetail removeItem(@PathVariable String cartId, @PathVariable Long itemId) {
        cartClient.removeItem(cartId, itemId);
        return cartClient.findCartDetailById(cartId);
    }
}
