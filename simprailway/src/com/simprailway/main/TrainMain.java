package com.simprailway.main;



import com.simprailway.dao.TrainDao;
import com.simprailway.dao.TrainDaoImpl;
import com.simprailway.model.Train;

import java.util.List;
import java.util.Scanner;

public class TrainMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TrainDao trainDao = new TrainDaoImpl();

        System.out.println("===== Railway Train Management =====");

        while (true) {
            System.out.println("1. Add New Train");
            System.out.println("2. View All Trains");
            System.out.println("3. Update Train Details");
            System.out.println("4. Delete Train");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Enter train details:");
                    Train newTrain = new Train();
                    System.out.print("Train ID: ");
                    newTrain.setTrainId(scanner.nextInt());
                    System.out.print("Train Name: ");
                    newTrain.setTrainName(scanner.next());
                    System.out.print("Source Station: ");
                    newTrain.setSourceStation(scanner.next());
                    System.out.print("Destination Station: ");
                    newTrain.setDestinationStation(scanner.next());
                    System.out.print("Total Seats: ");
                    newTrain.setTotalSeats(scanner.nextInt());
                    trainDao.create(newTrain);
                    System.out.println("Train added successfully!");
                    break;

                case 2:
                    List<Train> trains = trainDao.read();
                    if (trains.isEmpty()) {
                        System.out.println("No trains found.");
                    } else {
                        System.out.println("Train Details:");
                        for (Train train : trains) {
                            System.out.println(train);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter train ID to update details: ");
                    int trainIdToUpdate = scanner.nextInt();
                    Train existingTrain = trainDao.readById(trainIdToUpdate);
                    if (existingTrain == null) {
                        System.out.println("Train with ID " + trainIdToUpdate + " not found.");
                    } else {
                        System.out.println("Enter updated details:");
                        System.out.print("Train Name: ");
                        existingTrain.setTrainName(scanner.next());
                        System.out.print("Source Station: ");
                        existingTrain.setSourceStation(scanner.next());
                        System.out.print("Destination Station: ");
                        existingTrain.setDestinationStation(scanner.next());
                        System.out.print("Total Seats: ");
                        existingTrain.setTotalSeats(scanner.nextInt());
                        trainDao.update(existingTrain);
                        System.out.println("Train details updated successfully!");
                    }
                    break;

                case 4:
                    System.out.print("Enter train ID to delete: ");
                    int trainIdToDelete = scanner.nextInt();
                    trainDao.delete(trainIdToDelete);
                    System.out.println("Train deleted successfully!");
                    break;

                case 0:
                    System.out.println("Exiting Railway Train Management System.");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
