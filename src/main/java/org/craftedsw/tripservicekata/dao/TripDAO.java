package org.craftedsw.tripservicekata.dao;

import org.craftedsw.tripservicekata.exception.CollaboratorCallException;
import org.craftedsw.tripservicekata.model.Trip;
import org.craftedsw.tripservicekata.model.User;

import java.util.List;

public class TripDAO {
    public List<Trip> findTripsByUser(User user) {
        throw new CollaboratorCallException(
                "TripDAO should not be invoked on an unit test.");
    }
}
