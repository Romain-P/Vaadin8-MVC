package org.vaadinmvc.common;

import org.vaadinmvc.ui.Main;
import org.vaadinmvc.ui.model.entity.User;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import java.io.Serializable;

/**
 * @Author: romain.pillot
 * @Date: 19/07/2017
 */
@SessionScoped
public class UserController implements Serializable {
    @Inject protected User user;
    @Inject protected Main ui;
}
