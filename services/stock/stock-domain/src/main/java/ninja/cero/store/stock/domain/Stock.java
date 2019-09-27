package ninja.cero.store.stock.domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	public Long itemId;

	public Integer quantity;
}
