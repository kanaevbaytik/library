package one.library.backend.service;

import one.library.backend.entity.Author;
import one.library.backend.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public List<String> getAuthorNames(String name) {
        ArrayList<String> authorNames = new ArrayList<>();
        ArrayList<Author> authors = (ArrayList<Author>) authorRepository.findByName(name);
        for (int i = 0; i < authors.size(); i++) {
            authorNames.add(authors.get(i).getName());
        }
        return authorNames;
    }

    public Author save(Author author) {
        return authorRepository.save(author);
    }
}
