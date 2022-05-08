package sk.stuba.fei.uim.oop.assignment3.book.data;

import lombok.Getter;
import lombok.Setter;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
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
}
