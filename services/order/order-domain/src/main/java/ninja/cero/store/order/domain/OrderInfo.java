package ninja.cero.store.order.domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;

public class OrderInfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	public String name;
	public String address;
	public String telephone;
	public String mailAddress;

	public String cardNumber;
	public String cardExpire;
	public String cardName;

	public String cartId;
}
