package model;

public class Reservation {
    private static int counter = 1000;
    private int pnrNumber;
    private String userId;
    private String trainNumber;
    private String trainName;
    private String classType;
    private String dateOfJourney;
    private String fromPlace;
    private String toPlace;

    public Reservation(String userId, String trainNumber, String trainName, String classType,
            String dateOfJourney, String fromPlace, String toPlace) {
        this.pnrNumber = counter++;
        this.userId = userId;
        this.trainNumber = trainNumber;
        this.trainName = trainName;
        this.classType = classType;
        this.dateOfJourney = dateOfJourney;
        this.fromPlace = fromPlace;
        this.toPlace = toPlace;
    }

    public int getPnrNumber() {
        return pnrNumber;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public String getTrainName() {
        return trainName;
    }

    public String getClassType() {
        return classType;
    }

    public String getDateOfJourney() {
        return dateOfJourney;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public String getToPlace() {
        return toPlace;
    }

    public String getUserId() {
        return userId;
    }

    public String toString() {
        return String.format(
                "PNR: %d | User: %s | Train: %s (%s) | Class: %s | Date: %s | From: %s | To: %s",
                pnrNumber, userId, trainName, trainNumber, classType,
                dateOfJourney, fromPlace, toPlace);
    }
}
