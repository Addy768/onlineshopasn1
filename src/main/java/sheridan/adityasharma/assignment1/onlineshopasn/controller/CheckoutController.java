package sheridan.adityasharma.assignment1.onlineshopasn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sheridan.adityasharma.assignment1.onlineshopasn.beans.Product;
import sheridan.adityasharma.assignment1.onlineshopasn.beans.ShoppingCart;

import java.util.List;

@Controller
public class CheckoutController {

    private ShoppingCart shoppingCart;  // Assuming you have a shopping cart instance

    @GetMapping("/checkout")
    public String showCheckoutPage(Model model) {
        List<Product> cartItems = shoppingCart.getItems();

        // Calculate subtotal, sale tax, and total
        double subtotal = calculateSubtotal(cartItems);
        double saleTax = calculateSaleTax(subtotal);
        double total = calculateTotal(subtotal, saleTax);

        // Add data to the model for rendering in Thymeleaf template
        model.addAttribute("cartItems", cartItems);
        model.addAttribute("subtotal", subtotal);
        model.addAttribute("saleTax", saleTax);
        model.addAttribute("total", total);

        return "checkout";
    }

    // Method to calculate subtotal
    private double calculateSubtotal(List<Product> cartItems) {
        return cartItems.stream().mapToDouble(Product::getPrice).sum();
    }

    // Method to calculate sale tax (replace this with your own logic)
    private double calculateSaleTax(double subtotal) {
        // Implement your sale tax calculation logic
        return subtotal * 0.1;  // Assuming 10% sale tax for demonstration
    }

    // Method to calculate total
    private double calculateTotal(double subtotal, double saleTax) {
        return subtotal + saleTax;
    }
}
