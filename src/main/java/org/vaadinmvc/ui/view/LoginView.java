package org.vaadinmvc.ui.view;

import com.vaadin.cdi.CDIView;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener;
import com.vaadin.ui.*;
import com.vaadin.ui.themes.ValoTheme;
import org.vaadinmvc.ui.model.entity.User;
import org.vaadinmvc.ui.model.event.UserLoginEvent;
import org.vaadinmvc.util.ResourceUtil;
import lombok.Getter;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

import static org.vaadinmvc.util.Resource.IMG_LOGO;

/**
 * @Author: romain.pillot
 * @Date: 06/07/2017
 */

@CDIView(LoginView.ID)
public class LoginView extends VerticalLayout implements View {
    @Getter
    private final LoginForm form;
    private final CssLayout panel;
    private final VerticalLayout content;

    public static final String ID = "login";

    @Inject
    User user;

    private LoginView()
    {
        this.form = new LoginForm();
        this.panel = new CssLayout();
        this.content = new VerticalLayout();
    }

    @PostConstruct
    private void initialize()
    {
        /* setting view base */
        addStyleName("valo-ortec");
        setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);
        setHeight("100%");

        /* dispose login panel */
        customLoginForm();
        addPanelElements();

        /* applying panel style and adding content */
        panel.addStyleName(ValoTheme.PANEL_WELL);
        panel.setWidth("400px");
        panel.addComponents(content);

        addComponents(panel);
    }

    private void customLoginForm()
    {
        form.setUsernameCaption("Login");
        form.setPasswordCaption("Password");
        form.setLoginButtonCaption("Se connecter");

        /* setting to center all components */
        form.addComponentAttachListener((event) -> {
            VerticalLayout layout = (VerticalLayout) form.getContent();
            for (int i = 0; i < layout.getComponentCount(); i++)
                layout.setComponentAlignment(layout.getComponent(i), Alignment.MIDDLE_CENTER);
        });

        form.addLoginListener((event) -> user.getEventbus().post(new UserLoginEvent(
                        event.getLoginParameter("Login"),
                        event.getLoginParameter("Password"))));
    }

    private void addPanelElements()
    {
        content.setWidth("100%");
        content.setMargin(true);
        content.setDefaultComponentAlignment(Alignment.MIDDLE_CENTER);

        Label lblTitle = new Label("Ortec Pointage IHM");
        lblTitle.addStyleName(ValoTheme.LABEL_H2);
        lblTitle.addStyleName(ValoTheme.LABEL_COLORED);

        content.addComponents(lblTitle, form);
    }

    @Override
    public final void enter(ViewChangeListener.ViewChangeEvent viewChangeEvent) {}
}
