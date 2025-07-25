package util;

import model.User;
import model.Reservation;
import java.util.*;

public class DataStore {
    public static Map<String, User> users = new HashMap<>();
    public static Map<Integer, Reservation> reservations = new HashMap<>();
    public static Map<String, String> trains = new HashMap<>();

    static {
        // Add some sample users and trains
        users.put("alice", new User("alice", "password1"));
        users.put("bob", new User("bob", "password2"));

        // trainNumber, trainName
        trains.put("12345", "Express 1");
        trains.put("54321", "Mail 2");
        trains.put("33333", "Superfast 3");
    }
}
