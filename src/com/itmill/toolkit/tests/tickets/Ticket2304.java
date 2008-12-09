package com.itmill.toolkit.tests.tickets;

import com.itmill.toolkit.Application;
import com.itmill.toolkit.ui.Label;
import com.itmill.toolkit.ui.Panel;
import com.itmill.toolkit.ui.Window;

public class Ticket2304 extends Application {

    public void init() {
        final Window main = new Window(getClass().getName().substring(
                getClass().getName().lastIndexOf(".") + 1));
        setMainWindow(main);

        Panel p = new Panel();
        p.setStyleName(Panel.STYLE_LIGHT);
        main.addComponent(p);
        p.setHeight("100px");

        Label l = new Label(
                "a\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\na\n");
        l.setContentMode(Label.CONTENT_PREFORMATTED);
        p.addComponent(l);
        main.addComponent(new Label(
                "This text should be right below the panel, w/o spacing"));
    }

}
