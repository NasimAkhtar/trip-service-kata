package org.craftedsw.tripservicekata.model;

import java.util.LinkedList;
import java.util.List;

public class User {

    private List<Trip> trips = new LinkedList<>();
    private List<User> friends = new LinkedList<>();

    public List<User> getFriends() {
        return friends;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public void addTrip(Trip trip) {
        this.trips.add(trip);
    }

    public void addFriend(User user) {
        friends.add(user);
    }

    public boolean isFriend(User user) {
        for (User friend : this.friends) {
            if (friend.equals(user)) {
                return true;
            }
        }
        return false;
    }

}
