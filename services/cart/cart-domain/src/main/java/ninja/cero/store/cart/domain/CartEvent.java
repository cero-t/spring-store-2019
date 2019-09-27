package ninja.cero.store.cart.domain;

import java.io.Serializable;

public class CartEvent implements Serializable {
	private static final long serialVersionUID = 1L;

	public Long itemId;

	public Integer quantity;
}
