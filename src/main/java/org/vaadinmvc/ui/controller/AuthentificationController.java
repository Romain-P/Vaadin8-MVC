package org.vaadinmvc.ui.controller;

import com.google.common.eventbus.Subscribe;
import org.vaadinmvc.common.UserController;
import org.vaadinmvc.ui.model.event.UserLoginEvent;

/**
 * @Author: romain.pillot
 * @Date: 07/07/2017
 */

public class AuthentificationController extends UserController {
    @Subscribe
    public void onUserLogin(UserLoginEvent event)
    {
        System.out.println(String.format("lol %s %s",
                event.getPassword(), event.getUsername()));
    }
}
