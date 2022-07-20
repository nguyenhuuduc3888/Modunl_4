package all.service;

import all.model.Product;
import all.repository.IProductRepository;
import all.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {

    IProductRepository productRepository = new ProductRepository();
    List<Product> productList = productRepository.getData();

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> searchList = new ArrayList<>();
        for (Product product : productList) {
            if (product.getName().contains(name)) {
                searchList.add(product);
            }
        }
        return searchList;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getId() == id) {
                productList.remove(productList.get(i));
                break;
            }
        }
    }

}
