package sheridan.adityasharma.assignment1.onlineshopasn.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import sheridan.adityasharma.assignment1.onlineshopasn.beans.Product;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ProductController {

    private List<Product> productList = new ArrayList<>();

    @GetMapping("/products")
    public String listProducts(Model model) {
        model.addAttribute("productList", productList);
        return "products";
    }

    @GetMapping("/addProduct")
    public String showAddProductForm(Model model) {
        // Create an empty Product object to use as a placeholder in the form
        model.addAttribute("newProduct", new Product(0, "", 0.0)); // You can adjust the default values as needed
        return "addProduct";
    }


    @PostMapping("/addProduct")
    public String addProduct(@ModelAttribute("newProduct") Product newProduct, BindingResult result, Model model) {
        // Manual validation
        if (newProduct.getName() == null || newProduct.getName().isEmpty()) {
            result.rejectValue("name", "error.newProduct", "Product name is required");
        }
        if (newProduct.getPrice() <= 0) {
            result.rejectValue("price", "error.newProduct", "Product price must be greater than 0");
        }

        if (result.hasErrors()) {
            return "addProduct";
        }

        // Add the new product to the productList
        productList.add(newProduct);

        // Display success message
        model.addAttribute("successMessage", "Product added successfully!");

        return "redirect:/products";
    }
}
