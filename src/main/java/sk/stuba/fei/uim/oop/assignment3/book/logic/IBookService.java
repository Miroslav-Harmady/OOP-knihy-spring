package sk.stuba.fei.uim.oop.assignment3.book.logic;

import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookAmountRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookUpdateRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book create(BookRequest request)throws  NotFoundException;
    Book getBookById(Long id)throws  NotFoundException;
    Book updateBook(Long id, BookUpdateRequest request)throws NotFoundException;
    //tu deleteBook
    void deleteBook(Long id) throws NotFoundException;
    int getBookAmount(Long id) throws  NotFoundException;
    int increaseBookAmount(Long id, BookAmountRequest request) throws  NotFoundException;
    int getBookLendCount(Long id)throws  NotFoundException;
}
