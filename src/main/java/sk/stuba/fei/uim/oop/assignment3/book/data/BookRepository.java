package sk.stuba.fei.uim.oop.assignment3.book.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository <Book, Long>{
    List<Book> findAll();
    Book findBookById(Long id);
}
