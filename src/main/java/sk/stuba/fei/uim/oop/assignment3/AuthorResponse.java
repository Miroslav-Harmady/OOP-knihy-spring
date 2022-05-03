package sk.stuba.fei.uim.oop.assignment3;

import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class AuthorResponse {
    private Long id;
    private String name;
    private String surname;
    private List<Long> books;

    public AuthorResponse(Author author){
        this.id = author.getId();
        this.name = author.getName();
        this.surname = author.getSurname();
        this.books = author.getBooks().stream().map(Book::getId).collect(Collectors.toList());
    }
}
