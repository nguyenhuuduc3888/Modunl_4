package all.repository;

import all.model.Oder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IOderRepository extends JpaRepository<Oder, Integer> {

    @Query(value = "select *from book_detail where (book_code=:bookCode)", nativeQuery = true)
    Oder getByBookCode(@Param("bookCode") Integer bookCode);
}
