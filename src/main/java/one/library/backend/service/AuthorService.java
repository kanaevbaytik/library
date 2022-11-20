package one.library.backend.service;

import one.library.backend.entity.Author;
import one.library.backend.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public ArrayList<String> getAllAsString(String name) {
        ArrayList<String> authors = new ArrayList<>();
        for (Author author : authorRepository.findAllByName(name)) {
            authors.add(author.getName());
        }
        return authors;
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }

}
