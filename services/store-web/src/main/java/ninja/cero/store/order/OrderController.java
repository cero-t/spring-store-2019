package ninja.cero.store.order;

import ninja.cero.store.order.client.OrderClient;
import ninja.cero.store.order.domain.OrderInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
@CrossOrigin
public class OrderController {
	@Autowired
	OrderClient orderClient;

	@PostMapping
	public void checkout(@RequestBody OrderInfo order) {
		orderClient.createOrder(order);
	}
}
