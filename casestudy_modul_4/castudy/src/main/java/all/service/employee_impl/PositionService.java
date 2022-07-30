package all.service.employee_impl;

import all.model.employee.Position;
import all.repository.employee.IPositionRepository;
import all.service.employee.IPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionService implements IPositionService {
    @Autowired
    IPositionRepository positionRepository;

    @Override
    public List<Position> finAll() {
        return positionRepository.findAll();
    }
}
