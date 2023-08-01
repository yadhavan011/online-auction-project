package com.simprailway.dao;

import java.util.List;

import com.simprailway.model.Passenger;

public interface PassengerDao {
    void create(Passenger passenger);
    List<Passenger> read();
    void update(Passenger passenger);
    void delete(int passengerId);
    Passenger readById(int passengerId);
}
