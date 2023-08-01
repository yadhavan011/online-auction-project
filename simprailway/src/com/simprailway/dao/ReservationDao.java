package com.simprailway.dao;

import java.util.List;

import com.simprailway.model.Reservation;

public interface ReservationDao {
    void create(Reservation reservation);
    List<Reservation> read();
    void update(Reservation reservation);
    void delete(int reservationId);
    Reservation readById(int reservationId);
}
