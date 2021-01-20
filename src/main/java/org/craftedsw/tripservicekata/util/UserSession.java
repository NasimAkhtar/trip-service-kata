package org.craftedsw.tripservicekata.util;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.model.User;

public class UserSession {
    private static final UserSession userSession = new UserSession();

    private UserSession() {
    }

    public static UserSession getInstance() {
        return userSession;
    }

    public User getLoggedUser() {
        throw new CollaboratorCallException(
                "UserSession.getLoggedUser() should not be called in an unit test");
    }
}

