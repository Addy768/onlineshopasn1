package sheridan.adityasharma.assignment1.onlineshopasn.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sheridan.adityasharma.assignment1.onlineshopasn.beans.Product;
import sheridan.adityasharma.assignment1.onlineshopasn.beans.ShoppingCart;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    // Assuming you have a ShoppingCart instance to pass to the view
    private ShoppingCart shoppingCart = new ShoppingCart();

    @GetMapping("/")
    public String index(Model model) {
        // Initializing product data (Replace this with your actual product initialization logic)
        List<Product> productList = initializeProductData();

        // Adding a message to be displayed in the index page
        model.addAttribute("message", "Welcome to our online store!");

        // Adding the shopping cart to be displayed in the index page
        model.addAttribute("shoppingCart", shoppingCart);

        // Adding the product list to be displayed in the index page
        model.addAttribute("productList", productList);

        return "index";
    }

    // Method to initialize product data (Replace this with your actual product initialization logic)
    private List<Product> initializeProductData() {
        List<Product> productList = new ArrayList<>();
        productList.add(new Product(1234, "Product A", 10.99));
        productList.add(new Product(2341, "Product B", 19.99));
        // Add more products as needed
        return productList;
    }
}
