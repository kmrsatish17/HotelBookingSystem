package com.ssdi.project.beans;

import java.util.Date;

public class RoomSearchDetail {

	private String roomType;
	private double pricePerDay;
	private int noOfRooms;
	private String fromDate;
	private String toDate;
	private int noOfAdults;
	
	public int getNoOfAdults() {
		return noOfAdults;
	}

	public void setNoOfAdults(int noOfAdults) {
		this.noOfAdults = noOfAdults;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public double getPricePerDay() {
		return pricePerDay;
	}

	public void setPricePerDay(double pricePerDay) {
		this.pricePerDay = pricePerDay;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	@Override
	public String toString() {
		return "RoomSearchDetail [roomType=" + roomType + ", pricePerDay=" + pricePerDay + ", noOfRooms=" + noOfRooms
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + "]";
	}

	
	
	
}
