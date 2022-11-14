package one.library.backend.entity;

import one.library.backend.entity.auxiliaryEntity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
public class Language extends AbstractEntity {

    public enum Name {
        Russian, English, German, Kyrgyz
    }

    private Language.Name name;

    @OneToMany(mappedBy = "language")
    private List<Book> books;

}
