package all.service.facility;

import all.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface IFacilityService {

    Page<Facility> findAll(Pageable pageable, String name);

    void save(Facility facility);

    void update(Facility facility);

    void delete(int id);

    Facility findById(Integer id);

}
