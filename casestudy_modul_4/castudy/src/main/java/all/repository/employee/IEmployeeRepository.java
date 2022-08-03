package all.repository.employee;

import all.model.employee.Division;
import all.model.employee.EducationDegree;
import all.model.employee.Employee;

import all.model.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {
    @Transactional
    @Modifying
    @Query(value = "update employee set name =:name,date_of_birth=:dateOfBirth,id_card=:idCard," +
            "salary=:salary,phone=:phone,email=:email,address=:address ,position_id=:position, " +
            "education_id=:educationDegree,division_id=:division  where id=:id", nativeQuery = true)
    void update(@Param("name") String name, @Param("dateOfBirth") String dateOfBirth, @Param("idCard") String idCard,
                @Param("salary") Double salary, @Param("phone") String phone, @Param("email") String email,
                @Param("address") String address, @Param("position") Position position, @Param("educationDegree") EducationDegree educationDegree,
                @Param("division") Division division,
                @Param("id") int id);

    @Query(value = " select * from employee where name like :name ", nativeQuery = true)
    Page<Employee> findAll(Pageable pageable, @Param("name") String name);

}
