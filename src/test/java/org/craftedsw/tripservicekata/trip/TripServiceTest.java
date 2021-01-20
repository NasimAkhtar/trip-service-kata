package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.model.Trip;
import org.craftedsw.tripservicekata.model.User;
import org.craftedsw.tripservicekata.service.TripService;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

// Test Shortest branch first
public class TripServiceTest {

    User loggedInUser = null;

    @Test(expected = UserNotLoggedInException.class)
    public void should_throw_exception_when_user_not_logged_in() throws UserNotLoggedInException {
        TripService tripService = new TripServiceExtended();
        User friend = new User("ALICE");
        tripService.getTripsByUser(friend);
    }


    @Test
    public void should_return_no_trips_when_logged_in_user_is_not_friend() throws UserNotLoggedInException {
        TripService tripService = new TripServiceExtended();
        User friend = new User("ALICE");
        loggedInUser = new User("BOB");
        List<Trip> tripsByUser = tripService.getTripsByUser(friend);
        assertEquals(0, tripsByUser.size());
    }

    @Test
    public void should_return_trips_when_logged_in_user_is_friend() throws UserNotLoggedInException {
        TripService tripService = new TripServiceExtended();

        loggedInUser = new User("BOB");

        User anotherUser = new User("ALICE");
        anotherUser.addTrip(new Trip("GOA"));
        anotherUser.addFriend(loggedInUser);

        List<Trip> tripsByUser = tripService.getTripsByUser(anotherUser);
        assertEquals(1, tripsByUser.size());
    }



    class TripServiceExtended extends TripService {
        @Override
        protected User getLoggedUser() {
            return loggedInUser;
        }
    }

}
