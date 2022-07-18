package all.service;

import all.model.Product;
import all.repository.IProductRepository;
import all.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


public class ProductService implements IProductService {
    IProductRepository productRepository = new ProductRepository();
    List<Product> productList = productRepository.getData();

    @Override
    public List<Product> finAll() {
        return productList;
    }

    @Override
    public Product findById(int id) {
        for (Product product : productList) {
            if (product.getProductId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public void delete(int id) {
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getProductId() == id) {
                productList.remove(productList.get(i));
                break;
            }
        }
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> searchResult = new ArrayList<>();
        for (Product product : productList) {
            if (product.getProductName().contains(name)) {
                searchResult.add(product);
            }
        }
        return searchResult;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void update(int id, Product product) {
        Product updateProduct = findById(id);
        updateProduct.setProductName(product.getProductName());
        updateProduct.setProductPrice((product.getProductPrice()));
        updateProduct.setProductDescription(product.getProductDescription());
        updateProduct.setProducer(product.getProducer());
    }


}
