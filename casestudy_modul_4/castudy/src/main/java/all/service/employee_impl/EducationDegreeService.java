package all.service.employee_impl;

import all.model.employee.EducationDegree;
import all.repository.employee.IEducationDegreeRepository;
import all.service.employee.IEducationDegreeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationDegreeService implements IEducationDegreeService {
    @Autowired
    IEducationDegreeRepository educationDegreeRepository;

    @Override
    public List<EducationDegree> finAll() {
        return educationDegreeRepository.findAll();
    }
}
