package ninja.cero.store.catalog;

import ninja.cero.store.item.client.ItemClient;
import ninja.cero.store.item.domain.Item;
import ninja.cero.store.stock.client.StockClient;
import ninja.cero.store.stock.domain.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
@CrossOrigin
public class CatalogController {
    @Autowired
    ItemClient itemClient;

    @Autowired
    StockClient stockClient;

    @GetMapping
    public List<CatalogItem> findCatalog() {
        List<Item> items = itemClient.findAll();
        List<Long> ids = items.stream()
                .map(i -> i.id)
                .collect(Collectors.toList());

        List<Stock> stocks = stockClient.findByIds(ids);
        Map<Long, Integer> stockMap = stocks.stream()
                .collect(Collectors.toMap(s -> s.itemId, s -> s.quantity));

        // Filter items by stock
        return items.stream().map(item -> {
            CatalogItem catalogItem = new CatalogItem();
            catalogItem.id = item.id;
            catalogItem.name = item.name;
            catalogItem.media = item.media;
            catalogItem.author = item.author;
            catalogItem.release = item.release;
            catalogItem.unitPrice = item.unitPrice;
            catalogItem.image = item.image;
            catalogItem.inStock = stockMap.getOrDefault(item.id, 0) > 0;
            return catalogItem;
        }).collect(Collectors.toList());
    }
}
