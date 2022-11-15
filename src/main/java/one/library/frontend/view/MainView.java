package one.library.frontend.view;

import com.vaadin.componentfactory.Autocomplete;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import one.library.backend.repository.AuthorRepository;
import one.library.backend.service.AuthorService;

import java.util.ArrayList;

@Route("")
public class MainView extends VerticalLayout {

    private final AuthorService authorService;
    TextField titleTextField = new TextField("Title");
    Autocomplete authorTextField;

    public MainView(AuthorRepository authorRepository, AuthorService authorService) {
        this.authorService = authorService;

        configureAuthorTextField();

        add(titleTextField, authorTextField);
    }

    private void configureAuthorTextField() {
        authorTextField = new Autocomplete(5);
        authorTextField.setLabel("Author");
        authorTextField.addChangeListener(event -> {
            authorTextField.setOptions(authorService.getAuthorNames(event.getValue()));
        });
    }

}
