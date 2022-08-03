package all.repository.facility;

import all.model.facility.Facility;
import all.model.facility.FacilityType;
import all.model.facility.RentType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IFacilityRepository extends JpaRepository<Facility, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update facility set name =:name,area=:area,cost=:cost," +
            "max_people=:maxPeople,standard_room=:standardRoom,description=:description,pool_area=:poolArea,number_floor=:numberFloor," +
            "facility_free=:facilityFree,facility_type_id=:facilityTypeId ,rent_type_id=:rentTypeId where id=:id", nativeQuery = true)
    void update(@Param("name") String name, @Param("area") int area, @Param("cost") Double cost,
                @Param("maxPeople") int maxPeople, @Param("standardRoom") String standardRoom,
                @Param("description") String description, @Param("poolArea") Double poolArea, @Param("numberFloor") int numberFloor,
                @Param("facilityFree") String facilityFree,
                @Param("facilityTypeId") FacilityType facilityTypeId, @Param("rentTypeId") RentType rentTypeId,
                @Param("id") int id);

    @Query(value = "select * from facility where name like:name", nativeQuery = true)
    Page<Facility> findAll(Pageable pageable, @Param("name") String name);
}
