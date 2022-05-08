package sk.stuba.fei.uim.oop.assignment3.book.web.bodies;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;

@Getter
@Setter
public class BookRequest {
    private String name;
    private String description;
    private Long author;
    private Integer pages;
    private Integer amount;
    private Integer lendCount;
}
