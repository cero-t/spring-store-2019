package ninja.cero.store.cart.app;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;

@Table("cart")
public class CartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	String items;
}
