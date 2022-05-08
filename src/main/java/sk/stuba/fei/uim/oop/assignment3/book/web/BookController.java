package sk.stuba.fei.uim.oop.assignment3.book.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.logic.BookService;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookAmountRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookAmountResponse;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService service;

    @GetMapping()
    public List<BookResponse> getAllBooks(){
        return this.service.getAll().stream().map(BookResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<BookResponse> createBook(@RequestBody BookRequest request){
        return new ResponseEntity<>(new BookResponse(this.service.create(request)),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public BookResponse getBookById(@PathVariable("id") Long id){
        return new BookResponse(this.service.getBookById(id));
    }

    @PutMapping("/{id}")
    public BookResponse updateBook(@PathVariable("id") Long id, @RequestBody BookRequest request){
        return new BookResponse(this.service.updateBook(id, request));
    }

    //sem treba delete book

    @GetMapping("/{id}/amount")
    public BookAmountResponse getBookAmount(@PathVariable("id") Long id){
        return new BookAmountResponse(this.service.getBookAmount(id));
    }

    @PostMapping("/{id}/amount")
    public  BookAmountResponse increaseBookAmount(@PathVariable("id") Long id, @RequestBody BookAmountRequest request){
        return new BookAmountResponse(this.service.increaseBookAmount(id, request));
    }

}
