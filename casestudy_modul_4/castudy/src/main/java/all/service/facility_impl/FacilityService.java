package all.service.facility_impl;

import all.model.facility.Facility;
import all.model.facility.FacilityType;
import all.model.facility.RentType;
import all.repository.facility.IFacilityRepository;
import all.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {
    @Autowired
    IFacilityRepository facilityRepository;

    @Override
    public Page<Facility> findAll(Pageable pageable, String name) {
        return facilityRepository.findAll(pageable, "%" + name + "%");
    }

    @Override
    public void save(Facility facility) {
        facilityRepository.save(facility);
    }

    @Override
    public void update(Facility facility) {
        facilityRepository.update(facility.getName(), facility.getArea(), facility.getCost(), facility.getMaxPeople(), facility.getStandardRoom(),
                facility.getDescription(), facility.getPoolArea(), facility.getNumberFloor(), facility.getFacilityFree(), facility.getFacilityType(), facility.getRentType(), facility.getId());
    }

    @Override
    public void delete(int id) {
        facilityRepository.deleteById(id);
    }

    @Override
    public Facility findById(Integer id) {
        return facilityRepository.findById(id).orElse(null);
    }

    //tìm kiếm không phân trang
    @Override
    public List<Facility> find() {
        return facilityRepository.findAll();
    }
}
