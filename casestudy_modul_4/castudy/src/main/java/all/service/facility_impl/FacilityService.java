package all.service.facility_impl;

import all.model.facility.Facility;
import all.repository.facility.IFacilityRepository;
import all.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    IFacilityRepository facilityRepository;
//
//    @Override
//    public Page<Facility> findAllFacility(Pageable pageable, String name) {
//        return facilityRepository.findAllFacility(pageable, "%"+ name +"%");
//    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);

    }

    @Override
    public Facility findById(Integer id) {
        return facilityRepository.findById(id).orElse(null);
    }

    @Override
    public void delete(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }
}
