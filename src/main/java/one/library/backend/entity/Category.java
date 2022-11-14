package one.library.backend.entity;

import one.library.backend.entity.auxiliaryEntity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Category extends AbstractEntity {

    @OneToMany(mappedBy = "category")
    private List<Book> books;

}