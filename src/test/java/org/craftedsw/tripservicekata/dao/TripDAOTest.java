package org.craftedsw.tripservicekata.dao;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.model.User;
import org.junit.Test;

public class TripDAOTest {

    @Test(expected = CollaboratorCallException.class)
    public void findTripsByUser_should_throw_exception_when_called() {
        new TripDAO().tripsByUser(new User());
    }
}
