package all.service.facility;

import all.model.facility.Facility;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;

public interface IFacilityService {
//    Page<Facility> findAllFacility(Pageable pageable, String name);

    void save(Facility facility);

    Facility findById(Integer id);

    void delete(int id);

    List<Facility> findAll();

}
