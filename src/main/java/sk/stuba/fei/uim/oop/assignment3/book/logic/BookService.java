package sk.stuba.fei.uim.oop.assignment3.book.logic;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.author.data.AuthorRepository;
import sk.stuba.fei.uim.oop.assignment3.author.logic.AuthorService;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.data.BookRepository;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookAmountRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookUpdateRequest;

import java.util.List;

@Service
public class BookService implements IBookService{

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private AuthorService authorService;

    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book create(BookRequest request) {
        Book created = new Book();
        created.setName(request.getName());
        created.setDescription(request.getDescription());
        created.setAuthor(this.authorService.getAuthorById(request.getAuthor()));
        created.setPages(request.getPages());
        created.setAmount(request.getAmount());
        created.setLendCount(request.getLendCount());
        Author author = this.authorService.getAuthorById(request.getAuthor());
        author.getBooks().add(created);
        return this.bookRepository.save(created);
    }

    @Override
    public Book getBookById(Long id) {
        return this.bookRepository.findBookById(id);
    }

    @Override
    public Book updateBook(Long id, BookUpdateRequest request) {
        Book bookToUpdate = this.bookRepository.findBookById(id);
        if (request.getName() != null){
            bookToUpdate.setName(request.getName());
        }
        if (request.getDescription() != null){
            bookToUpdate.setDescription(request.getDescription());
        }
        if ((request.getAuthor() != null) && (request.getAuthor() != 0)){
            bookToUpdate.setAuthor(this.authorService.getAuthorById(request.getAuthor()));
        }
        if (request.getPages() != 0){
            bookToUpdate.setPages(request.getPages());
        }
        return this.bookRepository.save(bookToUpdate);
    }

    @Override
    public int getBookAmount(Long id) {
        Book chosen = this.bookRepository.findBookById(id);
        return chosen.getAmount();
    }

    @Override
    public int increaseBookAmount(Long id, BookAmountRequest request) {
        Book chosen = this.bookRepository.findBookById(id);
        chosen.setAmount(chosen.getAmount() + request.getAmount());
        this.bookRepository.save(chosen);
        return chosen.getAmount();
    }

    @Override
    public int getBookLendCount(Long id) {
        Book chosen = this.bookRepository.findBookById(id);
        return chosen.getLendCount();
    }

}
