package sk.stuba.fei.uim.oop.assignment3.book.logic;

import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookAmountRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book create(BookRequest request);
    Book getBookById(Long id);
    Book updateBook(Long id, BookRequest request);
    //tu deleteBook
    int getBookAmount(Long id);
    int increaseBookAmount(Long id, BookAmountRequest request);
    int getBookLendCount(Long id);
}
