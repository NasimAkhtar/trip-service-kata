package org.craftedsw.tripservicekata.service;

import org.craftedsw.tripservicekata.dao.TripDAO;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.model.Trip;
import org.craftedsw.tripservicekata.model.User;
import org.craftedsw.tripservicekata.util.UserSession;

import java.util.ArrayList;
import java.util.List;

//Refactor deepest branch first
public class TripService {

    private TripDAO tripDAO;

    public TripService(TripDAO tripDAO) {
        this.tripDAO = tripDAO;
    }

    public List<Trip> getTripsByUser(User user) throws UserNotLoggedInException {

        User loggedUser = getLoggedUser();

        if (loggedUser == null) throw new UserNotLoggedInException();

        if (user.isFriend(loggedUser)) return tripsBy(user);

        return new ArrayList<Trip>();
    }

    protected List<Trip> tripsBy(User user) {
        return tripDAO.findTripsByUser(user);
    }

    protected User getLoggedUser() {
        return UserSession.getInstance().getLoggedUser();
    }
}
