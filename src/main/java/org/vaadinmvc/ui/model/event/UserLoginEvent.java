package org.vaadinmvc.ui.model.event;

import lombok.Data;

/**
 * @Author: romain.pillot
 * @Date: 10/07/2017
 */
@Data
public final class UserLoginEvent {
    private final String username;
    private final String password;
}
