package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.model.Trip;
import org.craftedsw.tripservicekata.model.User;
import org.craftedsw.tripservicekata.service.TripService;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

// Test Shortest branch first
public class TripServiceTest {

    private static final User GUEST = null;
    private static final User UNUSED_USER = null;
    private static final User REGISTERED_USER = new User();
    private static final User ANOTHER_USER = new User();
    private static final Trip TO_BRAZIL = new Trip("BRAZIL");
    private static final Trip TO_EUROPE = new Trip("EUROPE");

    User loggedInUser = null;
    TripService tripService;

    @Before
    public void setUp() throws Exception {
        tripService = new TestableTripService();
        loggedInUser = REGISTERED_USER;
    }

    @Test(expected = UserNotLoggedInException.class)
    public void should_throw_exception_when_user_not_logged_in() {
        loggedInUser = GUEST;
        tripService.getTripsByUser(UNUSED_USER);
    }


    @Test
    public void should_return_no_trips_when_users_are_not_friend() {
        User friend = new User();
        friend.addFriend(ANOTHER_USER);
        friend.addTrip(TO_BRAZIL);

        List<Trip> tripsByUser = tripService.getTripsByUser(friend);

        assertEquals(0, tripsByUser.size());
    }

    @Test
    public void should_return_trips_when_users_are_friends() {
        User friend = new User();
        friend.addTrip(TO_BRAZIL);
        friend.addTrip(TO_EUROPE);
        friend.addFriend(loggedInUser);

        List<Trip> tripsByUser = tripService.getTripsByUser(friend);

        assertEquals(2, tripsByUser.size());
    }



    class TestableTripService extends TripService {
        @Override
        protected User getLoggedUser() {
            return loggedInUser;
        }

        @Override
        protected List<Trip> tripsBy(User user) {
            return user.getTrips();
        }
    }
}
