package one.library.frontend.view;

import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.router.HighlightConditions;
import com.vaadin.flow.router.RouterLink;

public class MainLayout extends AppLayout {

    public MainLayout() {
        createHeader();
        createDrawer();
    }

    private void createDrawer() {
        RouterLink newBookViewLink = new RouterLink("New book", NewBookView.class);
        newBookViewLink.setHighlightCondition(HighlightConditions.sameLocation());

        addToDrawer(newBookViewLink);
    }

    private void createHeader() {
        H1 logo = new H1("Library");
        HorizontalLayout header = new HorizontalLayout(new DrawerToggle(), logo);
        header.setVerticalComponentAlignment(FlexComponent.Alignment.CENTER);
        header.setWidth("100%");
        addToNavbar(header);
    }

}
