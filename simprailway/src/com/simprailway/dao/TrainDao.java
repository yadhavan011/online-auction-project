package com.simprailway.dao;

import java.util.List;

import com.simprailway.model.Train;

public interface TrainDao {
    void create(Train train);
    List<Train> read();
    void update(Train train);
    void delete(int trainId);
    Train readById(int trainId);
}
