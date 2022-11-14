package one.library.backend.entity;

import one.library.backend.entity.auxiliaryEntity.AbstractEntity;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Book extends AbstractEntity {

    public enum Country {
        Kyrgyzstan, Russia, UnitedStates, UnitedKingdom, Germany
    }

    public enum Language {
        Russian, Kyrgyz, German, English
    }

    public enum EditionInfo {
        SecondEdition, ThirdEdition, Reprint, SpecialEdition
    }

    @NotNull
    @NotEmpty
    private String title = "";
    @ManyToOne
    @JoinColumn(name = "author_id")
    private Author author;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Book_Responsible",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "responsible_id") }
    )
    private List<Responsible> responsibles = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private Country country;
    @Enumerated(EnumType.STRING)
    private Language language;

    @Enumerated(EnumType.STRING)
    private EditionInfo editionInfo;
    @NotNull
    @NotEmpty
    @Min(868)
    @Max(2088)
    private int year;
    @NotNull
    @NotEmpty
    @Size(min = 10, max = 13)
    private String ISBN;
    @Min(0)
    private int price;
    @NotNull
    @NotEmpty
    @Min(0)
    private int volume;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    @ManyToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "Book_Descriptor",
            joinColumns = { @JoinColumn(name = "book_id") },
            inverseJoinColumns = { @JoinColumn(name = "descriptor_id") }
    )
    private List<Descriptor> descriptors = new ArrayList<>();
    @NotNull
    private String annotation = "";

    @NotNull
    @NotEmpty
    private boolean containsImages;
    @NotNull
    @NotEmpty
    private boolean containsAudio;
    @NotNull
    @NotEmpty
    private boolean containsVideo;

    public Book() {
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public List<Responsible> getOtherResponsibles() {
        return responsibles;
    }

    public Country getCountry() {
        return country;
    }

    public Language getLanguage() {
        return language;
    }

    public EditionInfo getEditionInfo() {
        return editionInfo;
    }

    public int getYear() {
        return year;
    }

    public String getISBN() {
        return ISBN;
    }

    public int getPrice() {
        return price;
    }

    public int getVolume() {
        return volume;
    }

    public Category getCategory() {
        return category;
    }

    public List<Descriptor> getDescriptors() {
        return descriptors;
    }

    public String getAnnotation() {
        return annotation;
    }

    public boolean isContainsImages() {
        return containsImages;
    }

    public boolean isContainsAudio() {
        return containsAudio;
    }

    public boolean isContainsVideo() {
        return containsVideo;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public void setEditionInfo(EditionInfo editionInfo) {
        this.editionInfo = editionInfo;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setAnnotation(String annotation) {
        this.annotation = annotation;
    }

    public void setContainsImages(boolean containsImages) {
        this.containsImages = containsImages;
    }

    public void setContainsAudio(boolean containsAudio) {
        this.containsAudio = containsAudio;
    }

    public void setContainsVideo(boolean containsVideo) {
        this.containsVideo = containsVideo;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", author=" + author +
                ", otherResponsibles=" + responsibles +
                ", country=" + country +
                ", language=" + language +
                ", editionInfo=" + editionInfo +
                ", year=" + year +
                ", ISBN='" + ISBN + '\'' +
                ", price=" + price +
                ", volume=" + volume +
                ", category=" + category +
                ", descriptors=" + descriptors +
                ", annotation='" + annotation + '\'' +
                ", containsImages=" + containsImages +
                ", containsAudio=" + containsAudio +
                ", containsVideo=" + containsVideo +
                '}';
    }

}
