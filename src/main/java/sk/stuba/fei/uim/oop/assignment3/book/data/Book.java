package sk.stuba.fei.uim.oop.assignment3.book.data;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@Getter
@Setter
public class Book {
    @Id
    private Long id;
    private String name;
    private String description;
    private Long author;
    private int pages;
    private int amount;
    private int lendCount;
}
