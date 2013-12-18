package com.example.workshop;

import javax.servlet.annotation.WebServlet;

import com.vaadin.addon.responsive.Responsive;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
@Theme("workshop")
public class WorkshopExampleUI extends UI {

    @WebServlet(value = "/*", asyncSupported = true)
    @VaadinServletConfiguration(productionMode = false, ui = WorkshopExampleUI.class, widgetset = "com.example.workshop.widgetset.Workshop_exampleWidgetset")
    public static class Servlet extends MyVaadinServlet {
    }

    @Override
    protected void init(VaadinRequest request) {

        final VerticalLayout root = new VerticalLayout();
        setContent(root);
        root.setWidth("100%");

        CssLayout topbar = new CssLayout();
        root.addComponent(topbar);
        topbar.addStyleName("top");

        Label title = new Label("Workshop");
        topbar.addComponent(title);
        title.addStyleName("h1");

        VerticalLayout menu = new VerticalLayout();
        root.addComponent(menu);
        menu.setSizeUndefined();
        menu.addStyleName("menu");

        Button section = new Button("Start");
        menu.addComponent(section);
        section.addStyleName("icon-home");
        section.addStyleName("selected");

        section = new Button("Projects");
        menu.addComponent(section);
        section.addStyleName("icon-folder-open");

        section = new Button("Settings");
        menu.addComponent(section);
        section.addStyleName("icon-cog");

        VerticalLayout content = new VerticalLayout();
        root.addComponent(content);
        content.addStyleName("content");
        content.setSpacing(true);
        content.setMargin(true);

        Label header = new Label("Lorem Ipsum");
        content.addComponent(header);
        header.addStyleName("h2");

        Label text = new Label(
                "Mauris iaculis porttitor posuere. Praesent id metus massa, ut blandit odio. Proin quis tortor orci. Etiam at risus et justo dignissim congue. Donec congue lacinia dui, a porttitor lectus condimentum laoreet. Nunc eu ullamcorper orci. Quisque eget odio ac lectus vestibulum faucibus eget in metus. In pellentesque faucibus vestibulum. Nulla at nulla justo, eget luctus tortor. Nulla facilisi. Duis aliquet egestas purus in blandit.");
        content.addComponent(text);

        FormLayout form = new FormLayout();
        new Responsive(form);
        content.addComponent(form);
        form.addStyleName("form");
        form.setSpacing(true);

        TextField firstname = new TextField("First name");
        form.addComponent(firstname);

        TextField lastname = new TextField("Last name");
        form.addComponent(lastname);

        TextField email = new TextField("Email");
        form.addComponent(email);

        Button submit = new Button("Submit");
        form.addComponent(submit);

    }

}