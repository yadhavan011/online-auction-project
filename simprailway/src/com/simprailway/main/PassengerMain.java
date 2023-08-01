package com.simprailway.main;

import com.simprailway.dao.PassengerDao;
import com.simprailway.dao.PassengerDaoImpl;
import com.simprailway.model.Passenger;

import java.util.List;
import java.util.Scanner;

public class PassengerMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PassengerDao passengerDao = new PassengerDaoImpl();

        System.out.println("===== Railway Passenger Management =====");

        while (true) {
            System.out.println("1. Add New Passenger");
            System.out.println("2. View All Passengers");
            System.out.println("3. Update Passenger Details");
            System.out.println("4. Delete Passenger");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter passenger details:");
                    Passenger newPassenger = new Passenger();
                    System.out.print("Name: ");
                    newPassenger.setName(scanner.next());
                    System.out.print("Age: ");
                    newPassenger.setAge(scanner.nextInt());
                    System.out.print("Gender: ");
                    newPassenger.setGender(scanner.next());
                    System.out.print("Contact Number: ");
                    newPassenger.setContactNumber(scanner.next());
                    System.out.print("Email: ");
                    newPassenger.setEmail(scanner.next());
                    passengerDao.create(newPassenger);
                    System.out.println("Passenger added successfully!");
                    break;

                case 2:
                    List<Passenger> passengers = passengerDao.read();
                    if (passengers.isEmpty()) {
                        System.out.println("No passengers found.");
                    } else {
                        System.out.println("Passenger Details:");
                        for (Passenger passenger : passengers) {
                            System.out.println(passenger);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter passenger ID to update details: ");
                    int passengerIdToUpdate = scanner.nextInt();
                    Passenger existingPassenger = passengerDao.readById(passengerIdToUpdate);
                    if (existingPassenger == null) {
                        System.out.println("Passenger with ID " + passengerIdToUpdate + " not found.");
                    } else {
                        System.out.println("Enter updated details:");
                        System.out.print("Name: ");
                        existingPassenger.setName(scanner.next());
                        System.out.print("Age: ");
                        existingPassenger.setAge(scanner.nextInt());
                        System.out.print("Gender: ");
                        existingPassenger.setGender(scanner.next());
                        System.out.print("Contact Number: ");
                        existingPassenger.setContactNumber(scanner.next());
                        System.out.print("Email: ");
                        existingPassenger.setEmail(scanner.next());
                        passengerDao.update(existingPassenger);
                        System.out.println("Passenger details updated successfully!");
                    }
                    break;

                case 4:
                    System.out.print("Enter passenger ID to delete: ");
                    int passengerIdToDelete = scanner.nextInt();
                    passengerDao.delete(passengerIdToDelete);
                    System.out.println("Passenger deleted successfully!");
                    break;

                case 0:
                    System.out.println("Exiting Railway Passenger Management System.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
