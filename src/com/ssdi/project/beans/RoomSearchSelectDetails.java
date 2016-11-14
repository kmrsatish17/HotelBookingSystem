package com.ssdi.project.beans;

import java.util.List;

public class RoomSearchSelectDetails {
	
	private String fromDateSelected;
	private String toDateSelected;
	private String noOfRoomSelected;
	private List<String> roomTypeAvailable;
	public String getFromDateSelected() {
		return fromDateSelected;
	}
	public void setFromDateSelected(String fromDateSelected) {
		this.fromDateSelected = fromDateSelected;
	}
	public String getToDateSelected() {
		return toDateSelected;
	}
	public void setToDateSelected(String toDateSelected) {
		this.toDateSelected = toDateSelected;
	}
	public String getNoOfRoomSelected() {
		return noOfRoomSelected;
	}
	public void setNoOfRoomSelected(String noOfRoomSelected) {
		this.noOfRoomSelected = noOfRoomSelected;
	}
	public List<String> getRoomTypeAvailable() {
		return roomTypeAvailable;
	}
	public void setRoomTypeAvailable(List<String> roomTypeAvailable) {
		this.roomTypeAvailable = roomTypeAvailable;
	}
	@Override
	public String toString() {
		return "RoomSearchSelectDetails [fromDateSelected=" + fromDateSelected + ", toDateSelected=" + toDateSelected
				+ ", noOfRoomSelected=" + noOfRoomSelected + ", roomTypeAvailable=" + roomTypeAvailable + "]";
	}
	
	
	

}
