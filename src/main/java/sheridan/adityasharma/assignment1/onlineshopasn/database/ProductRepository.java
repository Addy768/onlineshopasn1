package sheridan.adityasharma.assignment1.onlineshopasn.database;

import org.springframework.data.jpa.repository.JpaRepository;
import sheridan.adityasharma.assignment1.onlineshopasn.beans.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
