package org.vaadinmvc.ui;

import com.vaadin.annotations.PreserveOnRefresh;
import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.cdi.CDIUI;
import com.vaadin.cdi.CDIViewProvider;
import com.vaadin.cdi.NormalUIScoped;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.*;
import com.vaadin.ui.*;
import org.vaadinmvc.ui.model.gui.menu.Menu;
import org.vaadinmvc.ui.model.gui.menu.MenuLayout;
import org.vaadinmvc.ui.view.LoginView;

import javax.inject.Inject;
import java.io.File;

@Theme("valo-blue")
@Title("VaadinMVC")
@PreserveOnRefresh
@NormalUIScoped
@CDIUI("")
public class Main extends UI {
    @Inject
    CDIViewProvider provider;

    @Override
    public void init(VaadinRequest request) {
        Responsive.makeResponsive(this);
        setNavigator(new Navigator(this, this));
        getNavigator().addProvider(provider);
        getNavigator().navigateTo(LoginView.ID);
    }
}
