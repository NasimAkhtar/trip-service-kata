package org.craftedsw.tripservicekata.util;

import org.craftedsw.tripservicekata.model.User;

public class UserSession {
    public static UserSession getInstance() {
        return new UserSession();
    }

    public User getLoggedUser() {
        return null;
    }
}
