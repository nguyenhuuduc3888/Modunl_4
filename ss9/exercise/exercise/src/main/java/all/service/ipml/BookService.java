package all.service.ipml;

import all.model.Book;
import all.model.Oder;
import all.repository.IOderRepository;
import all.repository.IBookRepository;
import all.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


@Service
public class BookService implements IBookService {
    @Autowired
    IBookRepository bookRepository;

    @Autowired
    IOderRepository oderRepository;

    @Override
    public Page<Book> findAll(Pageable pageable, String name) {
        return bookRepository.findAll(pageable, "%" + name + "%");
    }

    @Override
    public Book save(Book book) {
        return bookRepository.save(book);
    }

    @Override
    public Book findById(Integer id) {
        return bookRepository.findById(id).orElse(null);
    }

    @Override
    public int setBorrowBook(int id) {
        int amount = bookRepository.setBorrowBook(id);
        return amount;
    }

    @Override
    public int setReturnBook(int id) {
        int amount = bookRepository.setReturnBook(id);
        return amount;
    }
}
