package sk.stuba.fei.uim.oop.assignment3;

import java.util.List;

public interface IAuthorService {

    List<Author> getAll();
    Author create(AuthorRequest request);

}
