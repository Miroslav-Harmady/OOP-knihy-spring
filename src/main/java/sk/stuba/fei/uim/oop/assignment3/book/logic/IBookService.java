package sk.stuba.fei.uim.oop.assignment3.book.logic;

import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;

import java.util.List;

public interface IBookService {
    List<Book> getAll();
    Book create(BookRequest request);
}
