package one.library.frontend.view;

import com.vaadin.componentfactory.Autocomplete;
import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.combobox.MultiSelectComboBox;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import one.library.backend.entity.Author;
import one.library.backend.entity.Book;
import one.library.backend.entity.Category;
import one.library.backend.entity.Descriptor;
import one.library.backend.service.AuthorService;

import com.vaadin.flow.component.textfield.TextField;
import one.library.backend.service.BookService;
import one.library.backend.service.CategoryService;
import one.library.backend.service.DescriptorService;

import java.util.HashSet;
import java.util.Set;

@Route(value = "", layout = MainLayout.class)
@PageTitle("New book | Library")
public class NewBookView extends VerticalLayout {

    private final AuthorService authorService;
    private final CategoryService categoryService;
    private final DescriptorService descriptorService;
    private final BookService bookService;

    TextField titleF = new TextField("Title");
    Autocomplete authorF = new Autocomplete(3);
    ComboBox<Book.Country> countryComboBox = new ComboBox<>("Country");
    ComboBox<Book.Language> languageComboBox = new ComboBox<>("Language");
    ComboBox<Book.EditionInfo> editionInfoComboBox = new ComboBox<>("Edition");
    NumberField yearF = new NumberField("Year");
    TextField ISBNf = new TextField("ISBN");
    NumberField priceF = new NumberField("Price");
    NumberField volumeF = new NumberField("Volume");
    ComboBox<Category> categoryComboBox = new ComboBox<>("Category");
    MultiSelectComboBox<Descriptor> descriptorMultiSelectComboBox = new MultiSelectComboBox<>("Descriptors");
    TextArea annotationF = new TextArea("Annotation");

    Button saveButton = new Button("Save", this::save);

    private void save(ClickEvent<Button> buttonClickEvent) {
        String title = titleF.getValue();
        Author author = authorService.save(authorF.getValue());
        Book.Country country = countryComboBox.getValue();
        Book.Language language = languageComboBox.getValue();
        int year = yearF.getValue().intValue();
        String ISBN = ISBNf.getValue();
        Book.EditionInfo edition = editionInfoComboBox.getValue();
        int price = priceF.getValue().intValue();
        int volume = volumeF.getValue().intValue();
        Category category = categoryComboBox.getValue();
        Set<Descriptor> descriptors = descriptorMultiSelectComboBox.getValue();
        String annotation = annotationF.getValue();

        bookService.save(new Book(
                title,
                author,
                country,
                language,
                edition,
                year,
                ISBN,
                price,
                volume,
                category,
                descriptors,
                annotation,
                true,
                true,
                true
        ));
    }

    public NewBookView(AuthorService authorService, CategoryService categoryService, DescriptorService descriptorService, BookService bookService) {
        this.authorService = authorService;
        this.categoryService = categoryService;
        this.descriptorService = descriptorService;
        this.bookService = bookService;

        titleF.setClearButtonVisible(true);
        ISBNf.setClearButtonVisible(true);

        authorF.setLabel("Author");
        authorF.addChangeListener(event -> {
            authorF.setOptions(authorService.getAllAsString(event.getValue()));
        });
        countryComboBox.setItems(Book.Country.values());
        languageComboBox.setItems(Book.Language.values());
        editionInfoComboBox.setItems(Book.EditionInfo.values());
        categoryComboBox.setItems(categoryService.getAll());
        categoryComboBox.setItemLabelGenerator(Category::getName);
        descriptorMultiSelectComboBox.setItems(descriptorService.getAll());
        descriptorMultiSelectComboBox.setItemLabelGenerator(Descriptor::getName);

        add(
                new HorizontalLayout(titleF, authorF),
                new HorizontalLayout(countryComboBox, languageComboBox),
                new HorizontalLayout(yearF, ISBNf),
                editionInfoComboBox,
                new HorizontalLayout(priceF, volumeF),
                new HorizontalLayout(categoryComboBox, descriptorMultiSelectComboBox),
                annotationF,
                saveButton
        );
    }

}
