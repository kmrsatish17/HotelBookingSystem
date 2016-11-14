package com.ssdi.project.access.db;

import java.util.Date;
import java.util.List;

import com.ssdi.project.beans.RoomBookingDetails;
import com.ssdi.project.beans.RoomSearchDetail;
import com.ssdi.project.beans.UserProfile;

public interface UserProfileDao {

	public int insertProfile(UserProfile userProfile);

	public UserProfile getUserProfile(String emailId);

	public List<RoomSearchDetail> searchForRoom(Date fromDate, Date toDate);

	public boolean getPaymentValidity(int cardNumberInt, String cardName, int cvvNumberInt);

	public void saveBookingDetails(RoomBookingDetails roomBookingDetails);

	public void updateRoomAvailable(RoomBookingDetails roomBookingDetails);

}
