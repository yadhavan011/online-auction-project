package com.simprailway.dao;

import com.simprailway.model.Passenger;
import com.simprailway.util.DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PassengerDaoImpl implements PassengerDao {

    @Override
    public void create(Passenger passenger) {
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO passengers(name, age, gender, contact_number, email) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, passenger.getName());
            ps.setInt(2, passenger.getAge());
            ps.setString(3, passenger.getGender());
            ps.setString(4, passenger.getContactNumber());
            ps.setString(5, passenger.getEmail());

            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    passenger.setPassengerId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while creating passenger: " + e.getMessage());
        }
    }

    @Override
    public List<Passenger> read() {
        List<Passenger> passengers = new ArrayList<>();
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM passengers")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Passenger passenger = new Passenger();
                    passenger.setPassengerId(rs.getInt("passenger_id"));
                    passenger.setName(rs.getString("name"));
                    passenger.setAge(rs.getInt("age"));
                    passenger.setGender(rs.getString("gender"));
                    passenger.setContactNumber(rs.getString("contact_number"));
                    passenger.setEmail(rs.getString("email"));
                    passengers.add(passenger);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while reading passengers: " + e.getMessage());
        }
        return passengers;
    }

    @Override
    public void update(Passenger passenger) {
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE passengers SET name=?, age=?, gender=?, contact_number=?, email=? WHERE passenger_id=?")) {
            ps.setString(1, passenger.getName());
            ps.setInt(2, passenger.getAge());
            ps.setString(3, passenger.getGender());
            ps.setString(4, passenger.getContactNumber());
            ps.setString(5, passenger.getEmail());
            ps.setInt(6, passenger.getPassengerId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while updating passenger: " + e.getMessage());
        }
    }

    @Override
    public void delete(int passengerId) {
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM passengers WHERE passenger_id=?")) {
            ps.setInt(1, passengerId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while deleting passenger: " + e.getMessage());
        }
    }

    @Override
    public Passenger readById(int passengerId) {
        Passenger passenger = null;
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM passengers WHERE passenger_id=?")) {
            ps.setInt(1, passengerId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    passenger = new Passenger();
                    passenger.setPassengerId(rs.getInt("passenger_id"));
                    passenger.setName(rs.getString("name"));
                    passenger.setAge(rs.getInt("age"));
                    passenger.setGender(rs.getString("gender"));
                    passenger.setContactNumber(rs.getString("contact_number"));
                    passenger.setEmail(rs.getString("email"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while retrieving passenger details: " + e.getMessage());
        }
        return passenger;
    }
}
