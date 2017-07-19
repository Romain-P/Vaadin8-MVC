package org.vaadinmvc.ui.model.entity;

import com.google.common.eventbus.EventBus;
import org.vaadinmvc.ui.controller.AuthentificationController;
import lombok.Data;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * @Author: romain.pillot
 * @Date: 07/07/2017
 */
@Data
@SessionScoped
public class User implements Serializable {
    private final EventBus eventbus;
    private String firstName;
    private String lastName;

    @Inject
    AuthentificationController authentificationController;

    @PostConstruct
    public void registerControllers() {
        this.eventbus.register(authentificationController);
    }

    public User()
    {
        this.eventbus = new EventBus();
    }
}
