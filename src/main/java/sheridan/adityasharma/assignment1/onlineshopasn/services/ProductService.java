package sheridan.adityasharma.assignment1.onlineshopasn.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import sheridan.adityasharma.assignment1.onlineshopasn.beans.Product;
import sheridan.adityasharma.assignment1.onlineshopasn.database.ProductRepository;

import java.util.List;

public class ProductService {

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductById(long productId) {
        return productRepository.findById(productId).orElse(null);
    }

//    public List<Product> getProductsByNameStartingWith(String letter) {
//        return productRepository.findProductByNameStartingWith(letter);
//    }
//
//    public List<Product> getProductsByPriceRange(double minPrice, double maxPrice) {
//        return productRepository.findProductsByPriceRange(minPrice, maxPrice);
//    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    // Other methods as needed
}
