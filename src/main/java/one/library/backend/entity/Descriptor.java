package one.library.backend.entity;

import one.library.backend.entity.auxiliaryEntity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Descriptor extends AbstractEntity {

    @NotNull
    @NotEmpty
    private String name = "";

    @ManyToMany(mappedBy = "descriptors")
    private List<Book> books = new ArrayList<>();

    public Descriptor() {
    }

    public Descriptor(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Descriptor{" +
                "name='" + name + '\'' +
                ", books=" + books +
                '}';
    }

}
