package sk.stuba.fei.uim.oop.assignment3.book.web.bodies;

import lombok.Getter;
import sk.stuba.fei.uim.oop.assignment3.book.data.Book;

@Getter
public class BookAmountResponse {
    private int amount;

    public BookAmountResponse(int amount){
        this.amount = amount;
    }
}

