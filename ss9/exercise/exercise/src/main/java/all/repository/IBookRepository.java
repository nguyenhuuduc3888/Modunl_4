package all.repository;

import all.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;


public interface IBookRepository extends JpaRepository<Book, Integer> {
    @Modifying
    @Transactional
    @Query(value = "update book set amount=amount-1 where (id=:id)", nativeQuery = true)
    int setBorrowBook(@Param("id") int id);

    @Modifying
    @Transactional
    @Query(value = "update book set amount=amount+1 where (id=:id)", nativeQuery = true)
    int setReturnBook(@Param("id") int id);

    @Query(value = " select * from book where name like :name ", nativeQuery = true)
    Page<Book> findAll(Pageable pageable, @Param("name") String name);
}
