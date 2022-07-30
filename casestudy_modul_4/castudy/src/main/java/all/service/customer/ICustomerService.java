package all.service.customer;

import all.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService {
    Page<Customer> findAll(Pageable pageable, String name);

    void save(Customer customer);

    void update(Customer customer);

    void delete(int id);

    Customer findById(Integer id);
}
