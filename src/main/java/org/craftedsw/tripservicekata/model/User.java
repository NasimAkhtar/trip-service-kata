package org.craftedsw.tripservicekata.model;

import java.util.LinkedList;
import java.util.List;

public class User {

    LinkedList<Trip> trips = new LinkedList<>();
    LinkedList<User> friends = new LinkedList<>();

    public User() {}

    public List<User> getFriends() {
        return friends;
    }

    public void addTrip(Trip trip) {
        this.trips.add(trip);
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public List<Trip> getTrips() {
        return trips;
    }
}
