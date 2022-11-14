package one.library.backend.entity;

import one.library.backend.entity.auxiliaryEntity.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Responsible extends AbstractEntity {

    public enum Function {
        Translator, Editor, Artist, Photographer, Consultant
    }

    @NotNull
    @NotEmpty
    private String name = "";
    @Enumerated(EnumType.STRING)
    private Function function1;
    @Enumerated(EnumType.STRING)
    private Function function2;
    @Enumerated(EnumType.STRING)
    private Function function3;

    @ManyToMany(mappedBy = "responsibles")
    private List<Book> books = new ArrayList<>();

    public Responsible() {
    }

    public Responsible(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Function getFunction1() {
        return function1;
    }

    public Function getFunction2() {
        return function2;
    }

    public Function getFunction3() {
        return function3;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFunction1(Function function1) {
        this.function1 = function1;
    }

    public void setFunction2(Function function2) {
        this.function2 = function2;
    }

    public void setFunction3(Function function3) {
        this.function3 = function3;
    }

    @Override
    public String toString() {
        return "Responsible{" +
                "name='" + name + '\'' +
                ", function1=" + function1 +
                ", function2=" + function2 +
                ", function3=" + function3 +
                ", books=" + books +
                '}';
    }

}
