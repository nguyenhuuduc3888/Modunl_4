package all.repository;

import all.model.Blog;
import all.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.Calendar;
import java.util.List;

@Transactional
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select * from category", nativeQuery = true)
    List<Category> findAll();

    @Query(value = "select * from category where category_id = :id", nativeQuery = true)
    Category findById(@Param("id") int id);

    @Query(value = "select * from category ", nativeQuery = true)
    Page<Category> findAllCategory(Pageable pageable);

    @Modifying
    @Query(value = " delete from category where category_id = :id ", nativeQuery = true)
    void delete(@Param("id") int categoryId);

    @Query(value = "select * from category where category_name like :name", nativeQuery = true)
    Page<Category> findByName(@Param("name") String name, Pageable pageable);

    @Modifying
    @Query(value = "update category set category_name =:categoryName where category_id=:categoryId", nativeQuery = true)
    void update(@Param("categoryName") String categoryName, @Param("categoryId") int categoryId);

}
