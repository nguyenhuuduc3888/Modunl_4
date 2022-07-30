package all.service.facility_impl;

import all.model.facility.RentType;
import all.repository.facility.IFacilityTypeRepository;
import all.repository.facility.IRentTypeRepository;
import all.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RentTypeService implements IRentTypeService {
    @Autowired
    IRentTypeRepository rentTypeRepository;

    @Override
    public List<RentType> findAll() {
        return rentTypeRepository.findAll();
    }
}
