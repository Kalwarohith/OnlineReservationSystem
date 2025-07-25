package service;

import model.Reservation;
import util.DataStore;

import java.util.Collection;

public class ReservationService {
    public static Reservation reserve(String userId, String trainNumber, String classType,
            String dateOfJourney, String from, String to) {
        String trainName = DataStore.trains.get(trainNumber);
        if (trainName == null) {
            return null;
        }
        Reservation res = new Reservation(userId, trainNumber, trainName, classType, dateOfJourney, from, to);
        DataStore.reservations.put(res.getPnrNumber(), res);
        return res;
    }

    public static Reservation cancel(int pnrNumber) {
        return DataStore.reservations.remove(pnrNumber);
    }

    public static Reservation getReservation(int pnrNumber) {
        return DataStore.reservations.get(pnrNumber);
    }

    public static Collection<Reservation> getUserReservations(String userId) {
        return DataStore.reservations.values().stream()
                .filter(r -> r.getUserId().equals(userId))
                .toList();
    }
}
