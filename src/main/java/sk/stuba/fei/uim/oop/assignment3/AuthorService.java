package sk.stuba.fei.uim.oop.assignment3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService implements IAuthorService{

    @Autowired
    private AuthorRepository repository;

    @Override
    public List<Author> getAll() {
        return this.repository.findAll();
    }

    @Override
    public Author create(AuthorRequest request) {
        Author createdAuthor = new Author();
        createdAuthor.setName(request.getName());
        createdAuthor.setSurname(request.getSurname());
        createdAuthor.setBooks(0L);
        return this.repository.save(createdAuthor);

    }
}
