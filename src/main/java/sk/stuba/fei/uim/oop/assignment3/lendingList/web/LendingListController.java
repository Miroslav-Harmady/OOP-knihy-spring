package sk.stuba.fei.uim.oop.assignment3.lendingList.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.stuba.fei.uim.oop.assignment3.lendingList.logic.LendingListService;
import sk.stuba.fei.uim.oop.assignment3.lendingList.web.bodies.ListResponse;

@RestController
public class LendingListController {

    @Autowired
    private LendingListService service;

    @RequestMapping("/list")
    @PostMapping()
    public ResponseEntity<ListResponse> createList(){
        return new ResponseEntity<>(new ListResponse(this.service.create()), HttpStatus.CREATED);
    }

}
