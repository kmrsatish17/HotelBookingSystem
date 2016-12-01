package com.ssdi.project.access.db;

import java.util.Date;
import java.util.List;

import com.ssdi.project.beans.RoomBookingDetails;
import com.ssdi.project.beans.RoomSearchDetail;
import com.ssdi.project.beans.UserContactDetail;
import com.ssdi.project.beans.UserProfile;

public interface UserProfileDao {

	public int insertProfile(UserProfile userProfile);

	public UserProfile getUserProfile(String emailId);

	public List<RoomSearchDetail> searchForRoom(Date fromDate, Date toDate);

	public boolean getPaymentValidity(long cardNumberInt, String cardName, int cvvNumberInt);

	public int saveBookingDetails(RoomBookingDetails roomBookingDetails);

	public boolean updateRoomAvailable(RoomBookingDetails roomBookingDetails);
	
	public int insertContactDetails(UserContactDetail contactDetails);
	
	public double getRoomPricePerDay(String roomType);
	
}
