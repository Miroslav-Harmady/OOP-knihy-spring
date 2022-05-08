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
    private boolean lended;

    public ListResponse(LendingList list){
        this.id = list.getId();
        this.lendingList = list.getList().stream().map(BookResponse::new).collect(Collectors.toList());
        this.lended = list.isLent();
    }
}


