package main;

import java.util.*;
import service.AuthService;
import service.ReservationService;
import util.DataStore;
import model.Reservation;

public class OnlineReservationSystem {
    private static Scanner sc = new Scanner(System.in);
    private static String currentUserId = null;

    public static void main(String[] args) {
        System.out.println("=== Online Reservation System ===");

        // Login loop
        boolean loggedIn = false;
        while (!loggedIn) {
            System.out.print("User ID: ");
            String userId = sc.nextLine();
            System.out.print("Password: ");
            String password = sc.nextLine();
            if (AuthService.login(userId, password)) {
                currentUserId = userId;
                loggedIn = true;
                System.out.println("Login successful.\n");
            } else {
                System.out.println("Invalid credentials. Try again.\n");
            }
        }

        // Menu loop
        int choice;
        do {
            System.out.println("\nMain Menu:");
            System.out.println("1. Reserve Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Show My Reservations");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    reserveTicket();
                    break;
                case 2:
                    cancelTicket();
                    break;
                case 3:
                    showReservations();
                    break;
                case 0:
                    System.out.println("Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 0);
    }

    static void reserveTicket() {
        System.out.println("Available Trains:");
        DataStore.trains.forEach((no, name) -> System.out.println(no + ": " + name));

        System.out.print("Enter Train Number: ");
        String trainNumber = sc.nextLine();
        System.out.print("Class Type (First/Second/Sleeper): ");
        String classType = sc.nextLine();
        System.out.print("Date of Journey (YYYY-MM-DD): ");
        String date = sc.nextLine();
        System.out.print("From: ");
        String from = sc.nextLine();
        System.out.print("To: ");
        String to = sc.nextLine();

        Reservation res = ReservationService.reserve(currentUserId, trainNumber, classType, date, from, to);
        if (res != null) {
            System.out.println("Reservation successful. Details:");
            System.out.println(res);
        } else {
            System.out.println("Failed to reserve. Invalid train number.");
        }
    }

    static void cancelTicket() {
        System.out.print("Enter PNR to cancel: ");
        int pnr = Integer.parseInt(sc.nextLine());

        Reservation res = ReservationService.getReservation(pnr);
        if (res != null && res.getUserId().equals(currentUserId)) {
            System.out.println("Reservation details: " + res);
            System.out.print("Are you sure to cancel? (yes/no): ");
            String confirm = sc.nextLine();
            if (confirm.equalsIgnoreCase("yes")) {
                ReservationService.cancel(pnr);
                System.out.println("Reservation cancelled.");
            } else {
                System.out.println("Cancellation aborted.");
            }
        } else {
            System.out.println("Reservation not found or not your reservation.");
        }
    }

    static void showReservations() {
        var list = ReservationService.getUserReservations(currentUserId);
        if (list.isEmpty()) {
            System.out.println("No reservations found.");
            return;
        }
        list.forEach(System.out::println);
    }
}
