package com.ssdi.project.access.db;

import java.util.Date;
import java.util.List;

import com.ssdi.project.beans.OperatorProfile;
import com.ssdi.project.beans.RoomBookingDetails;
import com.ssdi.project.beans.RoomEntryDetails;
import com.ssdi.project.beans.RoomSearchDetail;
import com.ssdi.project.beans.UserContactDetail;
import com.ssdi.project.beans.UserProfile;

public interface UserProfileDao {

	public int insertProfile(UserProfile userProfile, boolean testDb);

	public UserProfile getUserProfile(String emailId, boolean testDb);
	
	public OperatorProfile getOperatorProfile(String userName, boolean testDb);

	public List<RoomSearchDetail> searchForRoom(Date fromDate, Date toDate, boolean testDb);
	
	public List<String> searchRoomForEntry(String roomTypeName, int noOfRooms, boolean testDb);
	
	public boolean getPaymentValidity(String cardNumberInt, String cardName, int cvvNumberInt, String expDate, boolean testDb);

	public int saveBookingDetails(RoomBookingDetails roomBookingDetails, boolean testDb);
	
	public boolean saveRoomEntryDetails(RoomEntryDetails roomEntryDetails, boolean testDb);

	public boolean updateRoomAvailable(RoomBookingDetails roomBookingDetails, boolean testDb);
	
	public int insertContactDetails(UserContactDetail contactDetails, boolean testDb);
	
	public double getRoomPricePerDay(String roomType, boolean testDb);
	
	public List<RoomBookingDetails> getBookingDetails(String userName, boolean testDb);
	
	public List<RoomBookingDetails> getCancelledBookingDetails(String userName, boolean testDb);
	
	public RoomBookingDetails getBookingDetailsById(String bookingId, boolean testDb);
	
	public boolean updateBookingDetails(RoomBookingDetails bookingDetail, boolean testDb);

	public boolean cancelBookingDetail(RoomBookingDetails bookingDetailSelected, boolean testDb);
	
	public List<RoomEntryDetails> getRoomEntryDetails(boolean testDb);
	
	public RoomEntryDetails getRoomEntryDetailsByRoomNo(String roomNumber, boolean testDb);
	
	public boolean checkoutRoomEntryDetail(RoomEntryDetails roomSelected, boolean testDb);
	
	
	
	
}
