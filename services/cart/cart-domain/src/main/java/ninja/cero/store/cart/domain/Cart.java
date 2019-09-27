package ninja.cero.store.cart.domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;

public class Cart implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	public Long cartId;

	public Map<Long, Integer> items = new LinkedHashMap<>();
}
