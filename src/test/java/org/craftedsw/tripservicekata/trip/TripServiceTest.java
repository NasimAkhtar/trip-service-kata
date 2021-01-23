package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.dao.TripDAO;
import org.craftedsw.tripservicekata.exception.UserNotLoggedInException;
import org.craftedsw.tripservicekata.model.Trip;
import org.craftedsw.tripservicekata.model.User;
import org.craftedsw.tripservicekata.service.TripService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.craftedsw.tripservicekata.trip.UserBuilder.aUser;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

// Test Shortest branch first
@RunWith(MockitoJUnitRunner.class)
public class TripServiceTest {

    private static final User GUEST = null;
    private static final User UNUSED_USER = null;
    private static final User REGISTERED_USER = new User();
    private static final User ANOTHER_USER = new User();
    private static final Trip TO_BRAZIL = new Trip("BRAZIL");
    private static final Trip TO_EUROPE = new Trip("EUROPE");

    @Mock private TripDAO tripDAO;

    @InjectMocks @Spy private TripService tripService;

    @Test(expected = UserNotLoggedInException.class)
    public void should_throw_exception_when_user_not_logged_in() {
        tripService.getFriendTrips(UNUSED_USER, GUEST);
    }

    @Test
    public void should_return_no_trips_when_users_are_not_friend() {
        User friend = aUser()
                .friendsWith(ANOTHER_USER)
                .withTrips(TO_BRAZIL, TO_EUROPE)
                .build();

        List<Trip> tripsByUser = tripService.getFriendTrips(friend, REGISTERED_USER);

        assertEquals(0, tripsByUser.size());
    }

    @Test
    public void should_return_trips_when_users_are_friends() {
        User friend = aUser()
                .friendsWith(ANOTHER_USER, REGISTERED_USER)
                .withTrips(TO_BRAZIL, TO_EUROPE)
                .build();

        when(tripDAO.tripsByUser(friend)).thenReturn(friend.getTrips());

        List<Trip> tripsByUser = tripService.getFriendTrips(friend, REGISTERED_USER);

        assertEquals(2, tripsByUser.size());
    }

}
