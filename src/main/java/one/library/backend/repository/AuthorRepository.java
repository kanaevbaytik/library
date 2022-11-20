package one.library.backend.repository;

import one.library.backend.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

    @Query(value = "SELECT * FROM author a WHERE a.name LIKE %?1%", nativeQuery = true)
    List<Author> findAllByName(String name);
}
