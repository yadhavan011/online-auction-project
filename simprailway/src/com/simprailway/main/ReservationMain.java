package com.simprailway.main;

import com.simprailway.dao.ReservationDao;
import com.simprailway.dao.ReservationDaoImpl;
import com.simprailway.model.Reservation;

import java.util.List;
import java.util.Scanner;

public class ReservationMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservationDao reservationDao = new ReservationDaoImpl();

        System.out.println("===== Railway Reservation Management =====");

        while (true) {
            System.out.println("1. Add New Reservation");
            System.out.println("2. View All Reservations");
            System.out.println("3. Update Reservation Details");
            System.out.println("4. Delete Reservation");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter reservation details:");
                    Reservation newReservation = new Reservation();
                    System.out.print("Passenger ID: ");
                    newReservation.setPassengerId(scanner.nextInt());
                    System.out.print("Train ID: ");
                    newReservation.setTrainId(scanner.nextInt());
                    System.out.print("Seat Number: ");
                    newReservation.setSeatNumber(scanner.nextInt());
                    System.out.print("Status: ");
                    newReservation.setStatus(scanner.next());
                    System.out.print("Reservation Date (YYYY-MM-DD): ");
                    String reservationDateStr = scanner.next();
                    java.sql.Date reservationDate = java.sql.Date.valueOf(reservationDateStr);
                    newReservation.setReservationDate(reservationDate);
                    reservationDao.create(newReservation);
                    System.out.println("Reservation added successfully!");
                    break;

                case 2:
                    List<Reservation> reservations = reservationDao.read();
                    if (reservations.isEmpty()) {
                        System.out.println("No reservations found.");
                    } else {
                        System.out.println("Reservation Details:");
                        for (Reservation reservation : reservations) {
                            System.out.println(reservation);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter reservation ID to update details: ");
                    int reservationIdToUpdate = scanner.nextInt();
                    Reservation existingReservation = reservationDao.readById(reservationIdToUpdate);
                    if (existingReservation == null) {
                        System.out.println("Reservation with ID " + reservationIdToUpdate + " not found.");
                    } else {
                        System.out.println("Enter updated details:");
                        System.out.print("Passenger ID: ");
                        existingReservation.setPassengerId(scanner.nextInt());
                        System.out.print("Train ID: ");
                        existingReservation.setTrainId(scanner.nextInt());
                        System.out.print("Seat Number: ");
                        existingReservation.setSeatNumber(scanner.nextInt());
                        System.out.print("Status: ");
                        existingReservation.setStatus(scanner.next());
                        System.out.print("Reservation Date (YYYY-MM-DD): ");
                        String updatedReservationDateStr = scanner.next();
                        java.sql.Date updatedReservationDate = java.sql.Date.valueOf(updatedReservationDateStr);
                        existingReservation.setReservationDate(updatedReservationDate);
                        reservationDao.update(existingReservation);
                        System.out.println("Reservation details updated successfully!");
                    }
                    break;

                case 4:
                    System.out.print("Enter reservation ID to delete: ");
                    int reservationIdToDelete = scanner.nextInt();
                    reservationDao.delete(reservationIdToDelete);
                    System.out.println("Reservation deleted successfully!");
                    break;

                case 0:
                    System.out.println("Exiting Railway Reservation Management System.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
