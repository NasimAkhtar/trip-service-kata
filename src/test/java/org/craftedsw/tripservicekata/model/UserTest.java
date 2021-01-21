package org.craftedsw.tripservicekata.model;

import org.junit.Test;

import static org.craftedsw.tripservicekata.trip.UserBuilder.aUser;
import static org.junit.Assert.*;

public class UserTest {

    private static final User PAUL = new User();
    private static final User BOB = new User();

    @Test
    public void should_return_false_when_user_are_not_friends() {
        User user = aUser()
                .friendsWith(PAUL)
                .build();

        assertFalse(user.isFriend(BOB));
    }

    @Test
    public void should_return_true_when_user_are_friends() {
        User user = aUser()
                .friendsWith(PAUL, BOB)
                .build();

        assertTrue(user.isFriend(BOB));
    }

}
