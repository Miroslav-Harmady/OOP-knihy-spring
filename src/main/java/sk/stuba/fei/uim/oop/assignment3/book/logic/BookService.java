package sk.stuba.fei.uim.oop.assignment3.book.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.data.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    private BookRepository repository;

    @Override
    public List<Book> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Book create(BookRequest request) {
        Book created = new Book();
        created.setName(request.getName());
        created.setDescription(request.getDescription());
        created.setAuthor(request.getAuthor());
        created.setPages(created.getPages());
        created.setAmount(request.getAmount());
        created.setLendCount(request.getLendCount());
        return this.repository.save(created);
    }
}
