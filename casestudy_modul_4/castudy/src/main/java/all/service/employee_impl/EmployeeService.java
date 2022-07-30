package all.service.employee_impl;

import all.model.employee.Employee;
import all.repository.employee.IEmployeeRepository;
import all.service.employee.IEmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService implements IEmployeeService {

    @Autowired
    IEmployeeRepository employeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable, String name) {
        return employeeRepository.findAll(pageable, "%"+name+"%");
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void update(Employee employee) {
        employeeRepository.update(employee.getName(), employee.getDateOfBirth(), employee.getIdCard(), employee.getSalary(),
                employee.getPhone(), employee.getEmail(), employee.getAddress(),employee.getPosition(),employee.getEducationDegree(),employee.getDivision(), employee.getId());
    }

    @Override
    public void delete(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepository.findById(id).orElse(null);
    }
}
