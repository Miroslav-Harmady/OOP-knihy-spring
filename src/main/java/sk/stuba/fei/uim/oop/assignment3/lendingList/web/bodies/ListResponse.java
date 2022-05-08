package sk.stuba.fei.uim.oop.assignment3.lendingList.web.bodies;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.lendingList.data.LendingList;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class ListResponse {
    private Long id;
    private List<BookResponse> lendingList;
    private boolean lent;

    ListResponse(LendingList list){
        this.id = list.getId();
        this.lendingList = list.getLendingList().stream().map(BookResponse::new).collect(Collectors.toList());
        this.lent = list.isLent();
    }
}


