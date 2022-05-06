package sk.stuba.fei.uim.oop.assignment3.book;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

@Repository
public interface BookRepository extends CrudRepository <Book, Long>{
}
