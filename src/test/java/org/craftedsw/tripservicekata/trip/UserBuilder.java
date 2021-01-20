package org.craftedsw.tripservicekata.trip;

import org.craftedsw.tripservicekata.model.Trip;
import org.craftedsw.tripservicekata.model.User;

class UserBuilder {
    private User[] friends =  null;
    private Trip[] trips = null;

    public static UserBuilder aUser() {
        return new UserBuilder();
    }

    UserBuilder friendsWith(User... friends) {
        this.friends = friends;
        return this;
    }

    UserBuilder withTrips(Trip... trips) {
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
