package org.craftedsw.tripservicekata.dao;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.model.Trip;
import org.craftedsw.tripservicekata.model.User;

import java.util.List;

public class TripDAO {

    //keeping static method to not to break clients
    public static List<Trip> findTripsByUser(User user) {
        throw new CollaboratorCallException(
                "TripDAO should not be invoked on an unit test.");
    }

    // instance method for refactoring
    public List<Trip> tripsByUser(User user) {
        return findTripsByUser(user);
    }
}
