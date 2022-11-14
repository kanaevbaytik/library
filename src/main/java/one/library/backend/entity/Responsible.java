package one.library.backend.entity;

import one.library.backend.entity.auxiliaryEntity.AbstractEntity;
import one.library.backend.entity.auxiliaryEntity.Function;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
public class Responsible extends AbstractEntity {

    @NotNull
    @NotEmpty
    private String name;
    @NotNull
    @NotEmpty
    @Min(868)
    @Max(3000)
    private int bornAt;
    @Min(868)
    @Max(3000)
    private int diedAt;
    @NotNull
    @Enumerated(EnumType.STRING)
    private Function function1;
    @Enumerated(EnumType.STRING)
    private Function function2;
    @Enumerated(EnumType.STRING)
    private Function function3;

    @ManyToMany(mappedBy = "responsibles")
    private List<Book> books;

}
