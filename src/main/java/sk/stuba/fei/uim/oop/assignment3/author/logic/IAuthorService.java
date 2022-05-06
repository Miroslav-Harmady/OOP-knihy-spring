package sk.stuba.fei.uim.oop.assignment3.author.logic;

import sk.stuba.fei.uim.oop.assignment3.author.web.bodies.AuthorRequest;
import sk.stuba.fei.uim.oop.assignment3.author.data.Author;

import java.util.List;

public interface IAuthorService {

    List<Author> getAll();

    Author create(AuthorRequest request);

    Author getAuthorById(Long id);

    Author update(Long id, AuthorRequest request);

    void delete(Long id);
}
