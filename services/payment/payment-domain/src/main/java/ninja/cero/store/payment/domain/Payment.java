package ninja.cero.store.payment.domain;

import org.springframework.data.annotation.Id;

import java.io.Serializable;
import java.math.BigDecimal;

public class Payment implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	public Long id;

	public String cardNumber;

	public String expire;

	public String name;

	public BigDecimal amount;
}
