package all.repository;

import all.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blog", nativeQuery = true)
    List<Blog> findAll();

    @Query(value = "select *from blog where category_id=:categoryId", nativeQuery = true)
    List<Blog> listCategory(@Param("categoryId") int categoryId);

    @Query(value = "select * from blog ", nativeQuery = true)
    Page<Blog> findAllBlog(Pageable pageable);

    @Modifying
    @Query(value = " delete from blog where id = :id ", nativeQuery = true)
    void delete(@Param("id") int id);

    @Query(value = "select * from blog where id = :id", nativeQuery = true)
    Blog findById(@Param("id") int id);

    @Query(value = "select * from blog where blog_name like :name", nativeQuery = true)
    List<Blog> findByName(@Param("name") String name);

    @Modifying
    @Query(value = "update blog set blog_name =:blogName,blog_detail=:blogDetail,day_create=:dayCreate,category_id=:categoryId where id=:id", nativeQuery = true)
    void update(@Param("blogName") String blogName, @Param("blogDetail") String blogDetail, @Param("dayCreate") String dayCreate, @Param("categoryId") int categoryId, @Param("id") int id);
}
