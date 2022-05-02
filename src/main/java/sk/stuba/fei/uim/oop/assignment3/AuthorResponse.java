package sk.stuba.fei.uim.oop.assignment3;

public class AuthorResponse {
    private String name;
    private String surname;
    private Long books;

    public AuthorResponse(Author author){
        this.name = author.getName();
    }
}
