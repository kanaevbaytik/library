package one.library.backend.entity;

import one.library.backend.entity.auxiliaryEntity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.List;

@Entity
public class Book extends AbstractEntity {

    public enum Content {
        Audio, Video, Image
    }

    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @NotNull
    @NotEmpty
    private String title;
    @Enumerated(EnumType.STRING)
    private Book.Content content1;
    @Enumerated(EnumType.STRING)
    private Book.Content content2;
    @Enumerated(EnumType.STRING)
    private Book.Content content3;
    @NotNull
    @NotEmpty
    @Min(868)
    @Max(3000)
    private int year;
    @Size(min = 10, max = 13)
    private String ISBN;
    @Min(0)
    private int price;
    @NotNull
    @NotEmpty
    @Min(0)
    private int volume;

    @ManyToOne
    @JoinColumn(name = "country_id")
    private Country country;
    @ManyToOne
    @JoinColumn(name = "language_id")
    private Language language;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Book_Responsible",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "responsible_id") }
    )
    private List<Responsible> otherResponsibles;
    @Enumerated(EnumType.STRING)
    private Book.EditionInfo editionInfo;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private List<Descriptor> descriptors;
    private String annotation;

    public Book() {
    }

    public enum EditionInfo {
        SecondEdition, ThirdEdition, NewRelease, Reprint
    }

}
