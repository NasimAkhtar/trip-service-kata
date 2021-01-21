package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.model.Trip;
import org.craftedsw.tripservicekata.model.User;

public class UserBuilder {
    private User[] friends = new User[0];
    private Trip[] trips = new Trip[0];

    public static UserBuilder aUser() {
        return new UserBuilder();
    }

    public UserBuilder friendsWith(User... friends) {
        this.friends = friends;
        return this;
    }

    public UserBuilder withTrips(Trip... trips) {
        this.trips = trips;
        return this;
    }

    public User build() {
        User user = new User();
        addFriends(user);
        addTrips(user);
       return user;
    }

    private void addTrips(User user) {
        for (Trip trip: trips) {
            user.addTrip(trip);
        }
    }

    private void addFriends(User user) {
        for (User friend : friends) {
            user.addFriend(friend);
        }
    }
}
