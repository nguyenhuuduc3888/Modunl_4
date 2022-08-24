package all.repository;

import all.model.Tintuc;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITintucRepository  extends JpaRepository<Tintuc,Integer> {
    @Query(value = " select * from tintuc where danh_muc like :name  or tieu_de like :name", nativeQuery = true)
    Page<Tintuc> findAll(Pageable pageable, @Param("name") String name);

}
