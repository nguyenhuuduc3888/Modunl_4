package all.service;

import all.model.Customer;
import all.repository.CustomerRepository;
import all.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


public class CustomerService implements ICustomerService {

    ICustomerRepository customerRepository = new CustomerRepository();
    List<Customer> customerList = customerRepository.getData();

    @Override
    public List<Customer> findAll() {
        return customerList;
    }

    @Override
    public void save(Customer customer) {
        customerList.add(customer);
    }

    @Override
    public Customer findById(int id) {
        return customerList.get(id);
    }

    @Override
    public void update(int id, Customer customer) {
        customerList.add(id, customer);
    }

    @Override
    public void remove(int id) {
        customerList.remove(id);
    }
}
