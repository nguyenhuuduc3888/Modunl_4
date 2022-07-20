package all.repository;

import all.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository {
    static List<Product> products = new ArrayList<>();

    static {
        products.add(new Product(1, "Nokia", 2000, "New 100%", "USA"));
        products.add(new Product(2, "Iphone", 2000, "New 100%", "USA"));
        products.add(new Product(3, "Samsung", 2000, "New 100%", "Korea"));
        products.add(new Product(4, "Bphone", 2000, "New 100%", "Vn"));
    }

    @Override
    public List<Product> getData() {
        return products;
    }
}
