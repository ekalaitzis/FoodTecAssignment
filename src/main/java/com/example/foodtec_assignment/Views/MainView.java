package com.example.foodtec_assignment.Views;


import com.example.foodtec_assignment.Item.ItemService;
import com.example.foodtec_assignment.Price.PriceService;
import com.example.foodtec_assignment.Size.SizeService;
import com.vaadin.flow.component.Composite;
import com.vaadin.flow.component.accordion.Accordion;
import com.vaadin.flow.component.accordion.AccordionPanel;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Menu;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;

@PageTitle("Main")
@Route("")
@Menu(order = 1)
public class MainView extends Composite<VerticalLayout> {

    private ItemService itemService;
    private PriceService priceService;
    private SizeService sizeService;


    @Autowired
    public MainView(ItemService itemService,PriceService priceService, SizeService sizeService) {
        this.itemService = itemService;
        this.sizeService = sizeService;
        this.priceService = priceService;


        H2 h2 = new H2();
        Accordion accordion = new Accordion();
        NumberField numberField = new NumberField();
        Button buttonPrimary = new Button();
        getContent().setWidth("100%");
        getContent().getStyle().set("flex-grow", "1");
        h2.setText("Pizza");
        h2.setWidth("max-content");
        accordion.setWidth("100%");
        setAccordionSampleData(accordion);

        numberField.setLabel("Number field");
        numberField.setWidth("min-content");
        buttonPrimary.setText("Button");
        buttonPrimary.setWidth("min-content");
        buttonPrimary.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        getContent().add(h2);
        getContent().add(accordion);
        getContent().add(numberField);
        getContent().add(buttonPrimary);
    }

    private void setAccordionSampleData(Accordion accordion) {
        Checkbox checkbox = new Checkbox();
        checkbox.setLabel("Small");
        checkbox.setWidth("min-content");
        Checkbox checkbox2 = new Checkbox();
        checkbox.setLabel("Medium");
        checkbox.setWidth("min-content");
        Checkbox checkbox3 = new Checkbox();
        checkbox.setLabel("Large");
        checkbox.setWidth("min-content");

        NumberField numberField = new NumberField();

        var sizes = sizeService.getAllSizes();
        var items = itemService.getAllItems();

        items.stream().forEach(i -> {
            HorizontalLayout pizzaLayout = new HorizontalLayout();
            sizes.stream().forEach(s -> pizzaLayout.add(new Checkbox(s.getName())));
            accordion.add(i.getName(), pizzaLayout);
        });
    }

    public Integer getNumberOfItems() {
        var items = itemService.getAllItems();
        return items.size();

    }



}
