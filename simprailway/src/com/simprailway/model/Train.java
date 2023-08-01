package com.simprailway.model;



public class Train {
    private int trainId;
    private String trainName;
    private String sourceStation;
    private String destinationStation;
    private int totalSeats;

    

    public int getTrainId() {
		return trainId;
	}



	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}



	public String getTrainName() {
		return trainName;
	}



	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}



	public String getSourceStation() {
		return sourceStation;
	}



	public void setSourceStation(String sourceStation) {
		this.sourceStation = sourceStation;
	}



	public String getDestinationStation() {
		return destinationStation;
	}



	public void setDestinationStation(String destinationStation) {
		this.destinationStation = destinationStation;
	}



	public int getTotalSeats() {
		return totalSeats;
	}



	public void setTotalSeats(int totalSeats) {
		this.totalSeats = totalSeats;
	}



	@Override
    public String toString() {
        return String.format("Train [trainId=%d, trainName=%s, sourceStation=%s, destinationStation=%s, totalSeats=%d]",
                trainId, trainName, sourceStation, destinationStation, totalSeats);
    }
	public Train() {
		// TODO Auto-generated constructor stub
	}
}
