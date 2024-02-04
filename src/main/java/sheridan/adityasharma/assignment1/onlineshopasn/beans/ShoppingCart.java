package sheridan.adityasharma.assignment1.onlineshopasn.beans;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class ShoppingCart {
    public List<Product> items = new ArrayList<>();

    // Add a product to the shopping cart
    public void addItem(Product product) {
        items.add(product);
    }

    // Remove a product from the shopping cart
    public void removeItem(Product product) {
        items.remove(product);
    }

    // Get the total price of items in the shopping cart
    public double getTotal() {
        return items.stream().mapToDouble(Product::getPrice).sum();
    }

    // Get the list of items in the shopping cart
    public List<Product> getItems() {
        return Collections.unmodifiableList(items);
    }
}
