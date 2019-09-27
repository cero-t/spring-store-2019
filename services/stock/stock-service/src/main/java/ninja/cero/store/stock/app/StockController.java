package ninja.cero.store.stock.app;

import ninja.cero.store.stock.domain.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockController {
	@Autowired
	StockRepository stockRepository;

	@GetMapping
	public Iterable<Stock> findAll() {
		return stockRepository.findAll();
	}

	@GetMapping("/{ids}")
	public Iterable<Stock> findByIds(@PathVariable List<Long> ids) {
		return stockRepository.findAllById(ids);
	}

	@PostMapping
	public void keepStock(@RequestBody List<Stock> keeps) {
		keeps.stream().forEach(s -> {
			int count = stockRepository.subtractIfPossible(s.itemId, s.quantity);
			if (count == 0) {
				throw new RuntimeException("Not enough stocks.");
			}
		});
	}
}
