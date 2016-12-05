package com.ssdi.project.beans;

public class RoomEntryDetails {
	
	private String firstName;
	private String lastName;
	private String fromDate;
	private String toDate;
	private String[] roomNumberChecked;
	private String roomType;
	private int noOfRooms;
	private String bookId;
	private String oprUserName;
	private String roomNumber;
	
	
	
	public String getRoomNumber() {
		return roomNumber;
	}
	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}
	public String getOprUserName() {
		return oprUserName;
	}
	public void setOprUserName(String oprUserName) {
		this.oprUserName = oprUserName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
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
	public String[] getRoomNumberChecked() {
		return roomNumberChecked;
	}
	public void setRoomNumberChecked(String[] roomNumberChecked) {
		this.roomNumberChecked = roomNumberChecked;
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
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	
	

}
