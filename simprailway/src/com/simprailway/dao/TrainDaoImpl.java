package com.simprailway.dao;

import com.simprailway.model.Train;
import com.simprailway.util.DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TrainDaoImpl implements TrainDao {

    @Override
    public void create(Train train) {
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO trains(train_id, train_name, source_station, destination_station, total_seats) VALUES (?, ?, ?, ?, ?)")) {
            ps.setInt(1, train.getTrainId());
            ps.setString(2, train.getTrainName());
            ps.setString(3, train.getSourceStation());
            ps.setString(4, train.getDestinationStation());
            ps.setInt(5, train.getTotalSeats());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while creating train: " + e.getMessage());
        }
    }

    @Override
    public List<Train> read() {
        List<Train> trains = new ArrayList<>();
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM trains")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Train train = new Train();
                    train.setTrainId(rs.getInt("train_id"));
                    train.setTrainName(rs.getString("train_name"));
                    train.setSourceStation(rs.getString("source_station"));
                    train.setDestinationStation(rs.getString("destination_station"));
                    train.setTotalSeats(rs.getInt("total_seats"));
                    trains.add(train);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while reading trains: " + e.getMessage());
        }
        return trains;
    }

    @Override
    public void update(Train train) {
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE trains SET train_name=?, source_station=?, destination_station=?, total_seats=? WHERE train_id=?")) {
            ps.setString(1, train.getTrainName());
            ps.setString(2, train.getSourceStation());
            ps.setString(3, train.getDestinationStation());
            ps.setInt(4, train.getTotalSeats());
            ps.setInt(5, train.getTrainId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while updating train: " + e.getMessage());
        }
    }

    @Override
    public void delete(int trainId) {
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM trains WHERE train_id=?")) {
            ps.setInt(1, trainId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while deleting train: " + e.getMessage());
        }
    }

    @Override
    public Train readById(int trainId) {
        Train train = null;
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM trains WHERE train_id=?")) {
            ps.setInt(1, trainId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    train = new Train();
                    train.setTrainId(rs.getInt("train_id"));
                    train.setTrainName(rs.getString("train_name"));
                    train.setSourceStation(rs.getString("source_station"));
                    train.setDestinationStation(rs.getString("destination_station"));
                    train.setTotalSeats(rs.getInt("total_seats"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while retrieving train details: " + e.getMessage());
        }
        return train;
    }
}
