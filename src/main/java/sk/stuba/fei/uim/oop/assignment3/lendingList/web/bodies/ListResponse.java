package sk.stuba.fei.uim.oop.assignment3.lendingList.web.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookResponse;
import sk.stuba.fei.uim.oop.assignment3.lendingList.data.LendingList;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ListResponse {
    private Long id;
    private List<BookResponse> lendingList;
    private boolean lended;

    public ListResponse(LendingList list){
        this.id = list.getId();
        this.lended = list.isLent();
        this.lendingList = new ArrayList<>();
        for (Book book : list.getList()) {
            this.lendingList.add(new BookResponse(book));
        }
    }

}


