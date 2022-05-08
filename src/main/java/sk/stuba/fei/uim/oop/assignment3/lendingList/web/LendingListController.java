package sk.stuba.fei.uim.oop.assignment3.lendingList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.stuba.fei.uim.oop.assignment3.lendingList.logic.LendingListService;
import sk.stuba.fei.uim.oop.assignment3.lendingList.web.bodies.ListResponse;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class LendingListController {

    @Autowired
    private LendingListService service;

    @RequestMapping("/list")

    @GetMapping()
    public List<ListResponse> getAllLists() {
        return this.service.getAllLists().stream().map(ListResponse::new).collect(Collectors.toList());
    }

    @PostMapping()
    public ResponseEntity<ListResponse> createList() {
        return new ResponseEntity<>(new ListResponse(this.service.create()), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ListResponse getListId(@PathVariable("id") Long id){
        return new ListResponse(this.service.getListById(id));
    }

}
