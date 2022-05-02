package sk.stuba.fei.uim.oop.assignment3;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Author {
    @Id
    private Long id;
    private String name;
    private  String surname;
    private Long books;
}
