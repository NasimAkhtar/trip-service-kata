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

    public List<Trip> getTripsByUser(User user, User loggedInUser) throws UserNotLoggedInException {

        if (loggedInUser == null)
            throw new UserNotLoggedInException();

        return user.isFriend(loggedInUser)
                    ? tripsBy(user)
                    : noTrips();
    }

    private List<Trip> noTrips() {
        return new ArrayList<>();
    }

    protected List<Trip> tripsBy(User user) {
        return tripDAO.tripsByUser(user);
    }
}
