package sk.stuba.fei.uim.oop.assignment3.lendingList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookIdRequest;
import sk.stuba.fei.uim.oop.assignment3.exception.IllegalOperationException;
import sk.stuba.fei.uim.oop.assignment3.exception.NotFoundException;
import sk.stuba.fei.uim.oop.assignment3.lendingList.logic.LendingListService;
import sk.stuba.fei.uim.oop.assignment3.lendingList.web.bodies.ListResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/list")
public class LendingListController {

    @Autowired
    private LendingListService service;

    @GetMapping()
    public List<ListResponse> getAllLists() {
        return this.service.getAllLists().stream().map(ListResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<ListResponse> createLendingList() {
        return new ResponseEntity<>(new ListResponse(this.service.createList()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ListResponse getListId(@PathVariable("id") Long id) throws NotFoundException {
        return new ListResponse(this.service.getListById(id));
    }

    @DeleteMapping("/{id}")
    public void deleteList(@PathVariable("id") Long id) throws NotFoundException {
        this.service.deleteList(id);
    }

    @PostMapping("/{id}/add")
    public ListResponse addBookToList(@PathVariable("id") Long id, @RequestBody BookIdRequest request) throws NotFoundException, IllegalOperationException {
        return new ListResponse(this.service.addBookToList(id, request));
    }

    @DeleteMapping("/{id}/remove")
    public void removeBookFromList(@PathVariable("id") Long id, @RequestBody BookIdRequest request) throws NotFoundException {
        this.service.removeBookFromList(id, request);
    }

    @GetMapping("/{id}/lend")
    public void lendList(@PathVariable("id") Long id)throws NotFoundException, IllegalOperationException{
        this.service.lendList(id);
    }

}
