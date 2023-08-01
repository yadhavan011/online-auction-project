package com.simprailway.dao;

import com.simprailway.model.Reservation;
import com.simprailway.util.DBHandler;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservationDaoImpl implements ReservationDao {

    @Override
    public void create(Reservation reservation) {
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement("INSERT INTO reservations(passenger_id, train_id, seat_number, status, reservation_date) VALUES (?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, reservation.getPassengerId());
            ps.setInt(2, reservation.getTrainId());
            ps.setInt(3, reservation.getSeatNumber());
            ps.setString(4, reservation.getStatus());
            ps.setDate(5, (Date) reservation.getReservationDate());
            ps.executeUpdate();

            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    reservation.setReservationId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while creating reservation: " + e.getMessage());
        }
    }

    @Override
    public List<Reservation> read() {
        List<Reservation> reservations = new ArrayList<>();
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM reservations")) {
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Reservation reservation = new Reservation();
                    reservation.setReservationId(rs.getInt("reservation_id"));
                    reservation.setPassengerId(rs.getInt("passenger_id"));
                    reservation.setTrainId(rs.getInt("train_id"));
                    reservation.setSeatNumber(rs.getInt("seat_number"));
                    reservation.setStatus(rs.getString("status"));
                    reservation.setReservationDate(rs.getDate("reservation_date"));
                    reservations.add(reservation);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while reading reservations: " + e.getMessage());
        }
        return reservations;
    }

    @Override
    public void update(Reservation reservation) {
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement("UPDATE reservations SET passenger_id=?, train_id=?, seat_number=?, status=?, reservation_date=? WHERE reservation_id=?")) {
            ps.setInt(1, reservation.getPassengerId());
            ps.setInt(2, reservation.getTrainId());
            ps.setInt(3, reservation.getSeatNumber());
            ps.setString(4, reservation.getStatus());
            ps.setDate(5, new java.sql.Date(reservation.getReservationDate().getTime()));
            ps.setInt(6, reservation.getReservationId());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while updating reservation: " + e.getMessage());
        }
    }

    @Override
    public void delete(int reservationId) {
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement("DELETE FROM reservations WHERE reservation_id=?")) {
            ps.setInt(1, reservationId);
            ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error while deleting reservation: " + e.getMessage());
        }
    }

    @Override
    public Reservation readById(int reservationId) {
        Reservation reservation = null;
        try (Connection conn = DBHandler.getConnection();
             PreparedStatement ps = conn.prepareStatement("SELECT * FROM reservations WHERE reservation_id=?")) {
            ps.setInt(1, reservationId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    reservation = new Reservation();
                    reservation.setReservationId(rs.getInt("reservation_id"));
                    reservation.setPassengerId(rs.getInt("passenger_id"));
                    reservation.setTrainId(rs.getInt("train_id"));
                    reservation.setSeatNumber(rs.getInt("seat_number"));
                    reservation.setStatus(rs.getString("status"));
                    reservation.setReservationDate(rs.getDate("reservation_date"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error while retrieving reservation details: " + e.getMessage());
        }
        return reservation;
    }
}
