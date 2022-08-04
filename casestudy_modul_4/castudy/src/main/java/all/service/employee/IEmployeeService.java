package all.service.employee;

import all.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IEmployeeService {

    Page<Employee> findAll(Pageable pageable, String name);

    void save(Employee employee);

    void update(Employee employee);

    void delete(int id);

    Employee findById(Integer id);

    List<Employee> find();
}
