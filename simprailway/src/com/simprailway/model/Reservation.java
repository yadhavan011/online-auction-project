package com.simprailway.model;




import java.util.Date;

public class Reservation {
    private int reservationId;
    private int passengerId;
    private int trainId;
    private int seatNumber;
    private String status;
    private Date reservationDate;

    

    public int getReservationId() {
		return reservationId;
	}



	public void setReservationId(int reservationId) {
		this.reservationId = reservationId;
	}



	public int getPassengerId() {
		return passengerId;
	}



	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}



	public int getTrainId() {
		return trainId;
	}



	public void setTrainId(int trainId) {
		this.trainId = trainId;
	}



	public int getSeatNumber() {
		return seatNumber;
	}



	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}



	public Date getReservationDate() {
		return reservationDate;
	}



	public void setReservationDate(Date reservationDate) {
		this.reservationDate = reservationDate;
	}



	@Override
    public String toString() {
        return String.format("Reservation [reservationId=%d, passengerId=%d, trainId=%d, seatNumber=%d, status=%s, reservationDate=%s]",
                reservationId, passengerId, trainId, seatNumber, status, reservationDate);
    }
	public Reservation() {
		
	}
}
