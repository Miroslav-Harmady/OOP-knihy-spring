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
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

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
    public Book create(BookRequest request) throws NotFoundException {
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
    public Book getBookById(Long id) throws  NotFoundException {
        Book book =  this.bookRepository.findBookById(id);
        if (book == null){
            throw new NotFoundException();
        }
        return book;
    }

    @Override
    public Book updateBook(Long id, BookUpdateRequest request) throws  NotFoundException{
        Book bookToUpdate = this.getBookById(id);
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
    public void deleteBook(Long id) throws NotFoundException {
        Book bookToDelete = this.getBookById(id);
        Author bookAuthor = this.authorService.getAuthorById(bookToDelete.getAuthor().getId());
        bookAuthor.getBooks().remove(this.getBookById(id));
        this.bookRepository.delete(bookToDelete);
    }

    @Override
    public int getBookAmount(Long id) throws  NotFoundException{
        Book chosen = this.getBookById(id);
        return chosen.getAmount();
    }

    @Override
    public int increaseBookAmount(Long id, BookAmountRequest request) throws  NotFoundException{
        Book chosen = this.getBookById(id);
        chosen.setAmount(chosen.getAmount() + request.getAmount());
        this.bookRepository.save(chosen);
        return chosen.getAmount();
    }

    @Override
    public int getBookLendCount(Long id) throws  NotFoundException{
        Book chosen = this.getBookById(id);
        return chosen.getLendCount();
    }

}
