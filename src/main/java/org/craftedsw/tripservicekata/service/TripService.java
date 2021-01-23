package org.craftedsw.tripservicekata.service;

import org.craftedsw.tripservicekata.dao.TripDAO;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.model.Trip;
import org.craftedsw.tripservicekata.model.User;

import java.util.ArrayList;
import java.util.List;

//Refactor deepest branch first
public class TripService {

    private TripDAO tripDAO;

    public TripService(TripDAO tripDAO) {
        this.tripDAO = tripDAO;
    }

    public List<Trip> getFriendTrips(User user, User loggedInUser) {

        validate(loggedInUser);

        return user.isFriend(loggedInUser)
                    ? tripsBy(user)
                    : noTrips();
    }

    private void validate(User loggedInUser) {
        if (loggedInUser == null)
            throw new UserNotLoggedInException();
    }

    private List<Trip> noTrips() {
        return new ArrayList<>();
    }

    private List<Trip> tripsBy(User user) {
        return tripDAO.tripsByUser(user);
    }
}
