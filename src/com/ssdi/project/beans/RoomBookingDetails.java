package com.ssdi.project.beans;

public class RoomBookingDetails {

	private String fromDate;
	private String toDate;
	private double totalPrice;
	private String roomType;
	private int noOfRooms;
	private double taxAmount;
	private double basicPrice;

	public double getTaxAmount() {
		return taxAmount;
	}

	public void setTaxAmount(double taxAmount) {
		this.taxAmount = taxAmount;
	}

	public double getBasicPrice() {
		return basicPrice;
	}

	public void setBasicPrice(double basicPrice) {
		this.basicPrice = basicPrice;
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

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public String getRoomType() {
		return roomType;
	}

	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}

	public int getNoOfRooms() {
		return noOfRooms;
	}

	public void setNoOfRooms(int noOfRooms) {
		this.noOfRooms = noOfRooms;
	}

	@Override
	public String toString() {
		return "RoomBookingDetails [fromDate=" + fromDate + ", toDate=" + toDate + ", totalPrice=" + totalPrice
				+ ", roomType=" + roomType + ", noOfRooms=" + noOfRooms + ", taxAmount=" + taxAmount + ", basicPrice="
				+ basicPrice + "]";
	}

}
