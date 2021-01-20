package org.craftedsw.tripservicekata.model;

import java.util.LinkedList;
import java.util.List;

public class User {

    LinkedList<Trip> trips = new LinkedList<>();
    LinkedList<User> friends = new LinkedList<>();
    private String name;

    public User(String name) {
        this.name = name;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void addTrip(Trip trip) {
        this.trips.add(trip);
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    @Override
    public boolean equals(Object user) {
        if (user instanceof  User) {
            return this.name == ((User) user).name;
        }
        return false;
    }

    public List<Trip> getTrips() {
        return trips;
    }
}
