package sk.stuba.fei.uim.oop.assignment3.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.assignment3.book.logic.BookService;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;
}
