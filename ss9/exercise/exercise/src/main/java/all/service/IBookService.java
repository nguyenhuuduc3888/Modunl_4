package all.service;

import all.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAll(Pageable pageable, String name);

    Book save(Book book);

    Book findById(Integer id);

    int setBorrowBook(int id);

    int setReturnBook(int id);
}
