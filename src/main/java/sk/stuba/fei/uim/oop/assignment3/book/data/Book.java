package sk.stuba.fei.uim.oop.assignment3.book.data;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;
import sk.stuba.fei.uim.oop.assignment3.book.web.bodies.BookRequest;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;
    @ManyToOne
    private Author author;
    private int pages;
    private int amount;
    private int lendCount;

    public Book(BookRequest request, Author author){
        this.setName(request.getName());
        this.setDescription(request.getDescription());
        this.setAuthor(author);
        this.setPages(request.getPages());
        this.setAmount(request.getAmount());
        this.setLendCount(request.getLendCount());
    }
}

