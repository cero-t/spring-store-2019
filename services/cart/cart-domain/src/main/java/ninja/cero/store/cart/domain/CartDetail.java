package ninja.cero.store.cart.domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class CartDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	public Long cartId;

	public List<CartItem> items;

	public BigDecimal total;
}
