package all.service;

import all.model.Product;
import all.repository.IProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void delete(Product product) {
        productRepository.delete(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }
}
