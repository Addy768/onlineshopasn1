package sheridan.adityasharma.assignment1.onlineshopasn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import sheridan.adityasharma.assignment1.onlineshopasn.beans.Product;
import sheridan.adityasharma.assignment1.onlineshopasn.beans.ShoppingCart;
import sheridan.adityasharma.assignment1.onlineshopasn.services.ProductService;

import java.util.List;

@Controller
public class ShoppingController {

    @Autowired
    private ShoppingCart shoppingCart;

    @Autowired
    private ProductService productService;

    @GetMapping("/shopping")
    public String showShoppingPage(Model model) {
        List<Product> productList = productService.getAllProducts();
        model.addAttribute("productList", productList);
        model.addAttribute("shoppingCart", shoppingCart);
        return "shopping";
    }

    @GetMapping("/addToCart")
    public String addToCart(@RequestParam long productId) {
        Product product = productService.getProductById(productId);
        shoppingCart.addItem(product);
        return "redirect:/shopping";
    }
}