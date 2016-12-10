package com.ssdi.project.access.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;
import java.util.Date;

import com.ssdi.project.beans.OperatorProfile;
import com.ssdi.project.beans.RoomBookingDetails;
import com.ssdi.project.beans.RoomEntryDetails;
import com.ssdi.project.beans.RoomSearchDetail;
import com.ssdi.project.beans.UserContactDetail;
import com.ssdi.project.beans.UserProfile;

public class UserProfileDaoImpl implements UserProfileDao {

	private static final String INSERT_SQL = "INSERT INTO USERPROFILE (USER_NAME, FIRST_NAME, LAST_NAME, EMAIL_ID, PASSWORD) VALUES (?,?,?,?,?)";
	private static final String INSERT_CONTACT_SQL = "INSERT INTO USER_CONTACT_DETAIL (USER_NAME, ADDRESS1, ADDRESS2, CITY, STATE, COUNTRY, ZIP, PHONE_NUMBER) VALUES (?,?,?,?,?,?,?,?)";
	private static final String GET_USER_PROFILE_SQL = "SELECT * from USERPROFILE WHERE USER_NAME = ?";
	private static final String GET_OPERATOR_PROFILE_SQL = "SELECT * from OPERATOR_PROFILE WHERE OPR_USER_NAME = ?";

	private static final String GET_ROOM_DETAILS_SQL = "SELECT ROOM_TYPE, min(NO_OF_ROOMS) AS ROOM_COUNT from ROOM_AVAILABLE where DATE_CHECK >= ? and DATE_CHECK <= ? GROUP BY ROOM_TYPE";
	private static final String GET_CARD_DETAIL_SQL = "SELECT * from PAYMENT_CARD_DETAIL WHERE CARD_NUMBER = ?";
	private static final String INSERT_BOOKING_DETAIL_SQL = "INSERT INTO ROOM_BOOKING_DETAIL (USER_NAME, FROM_DATE, TO_DATE, ROOM_TYPE, NO_OF_ROOM, NO_OF_ADULTS, BASIC_PRICE, GUEST_CHARGE, TAX_AMOUNT, TOTAL_PRICE) VALUES (?,?,?,?,?,?,?,?,?,?)";
	private static final String UPDATE_ROOM_AVAILABLE_SQL = "UPDATE ROOM_AVAILABLE SET NO_OF_ROOMS = NO_OF_ROOMS - ? where  DATE_CHECK >= ? and DATE_CHECK <= ? and ROOM_TYPE = ?";
	private static final String GET_ROOM_PRICE_SQL = "SELECT PRICE_PER_DAY from ROOM_CHARGE WHERE ROOM_TYPE = ?";
	private static final String INSERT_ROOM_ENTRY_DETAIL_SQL = "INSERT INTO ROOM_ENTRY_DETAIL (OPR_USER_NAME, FROM_DATE, TO_DATE, IS_AVAILABLE) VALUES (?,?,?,?) WHERE ROOM_NUMBER = ?";

	DataSource dataSource;

	@Override
	public int insertProfile(UserProfile userProfile, boolean testDb) {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(INSERT_SQL);
			ps.setString(1, userProfile.getUserName());
			ps.setString(2, userProfile.getFirstName());
			ps.setString(3, userProfile.getLastName());
			ps.setString(4, userProfile.getEmailId());
			ps.setString(5, userProfile.getPassword());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("%%%% Exception - insertProfile");
			return 0;
		} finally {
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}

	}

	@Override
	public int insertContactDetails(UserContactDetail contactDetails, boolean testDb) {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;

		try {
			ps = connection.prepareStatement(INSERT_CONTACT_SQL);
			ps.setString(1, contactDetails.getUsername());
			ps.setString(2, contactDetails.getAddress1());
			ps.setString(3, contactDetails.getAddress2());
			ps.setString(4, contactDetails.getCity());
			ps.setString(5, contactDetails.getState());
			ps.setString(6, contactDetails.getCountry());
			ps.setString(7, contactDetails.getZip());
			ps.setString(8, contactDetails.getPhoneNumber());
			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
			return 0;
		} finally {
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}

	}

	@Override
	public List<RoomSearchDetail> searchForRoom(Date fromDate, Date toDate, boolean testDb) {
		// TODO Auto-generated method stub

		System.out.println("### fromDate " + fromDate);
		System.out.println("### toDate " + toDate);

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;
		PreparedStatement psCheck = null;
		ResultSet rs = null;
		ResultSet rsCheck = null;
		boolean toDateCheck = false;

		java.sql.Date fromDateSql = new java.sql.Date(fromDate.getTime());
		java.sql.Date toDateSql = new java.sql.Date(toDate.getTime());

		List<RoomSearchDetail> roomDetailsList = new ArrayList<RoomSearchDetail>();

		try {
			psCheck = connection
					.prepareStatement("SELECT * from ROOM_AVAILABLE where DATE_CHECK = '" + toDateSql + "';");
			rsCheck = psCheck.executeQuery();

			if (rsCheck.next()) {

				toDateCheck = true;
			}
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		/*
		 * System.out.println(
		 * "@@@ SELECT ROOM_TYPE, min(NO_OF_ROOMS) AS ROOM_COUNT, PRICE_PER_DAY from ROOM_AVAILABLE where DATE_CHECK >= '"
		 * + fromDateSql + "' and DATE_CHECK <= '" + toDateSql +
		 * "' GROUP BY ROOM_TYPE ;");
		 */

		if (toDateCheck) {

			try {
				// ps = connection.prepareStatement(GET_ROOM_DETAILS_SQL);
				ps = connection.prepareStatement(
						"SELECT ROOM_TYPE, min(NO_OF_ROOMS) AS ROOM_COUNT from ROOM_AVAILABLE where DATE_CHECK >= '"
								+ fromDateSql + "' and DATE_CHECK <= '" + toDateSql + "' GROUP BY ROOM_TYPE ;");
				/*
				 * ps.setDate(1, fromDateSql); ps.setDate(2, toDateSql);
				 */

				rs = ps.executeQuery();
				RoomSearchDetail roomSearch = null;

				while (rs.next()) {
					roomSearch = new RoomSearchDetail();

					roomSearch.setRoomType(rs.getString("ROOM_TYPE"));
					roomSearch.setNoOfRooms(Integer.parseInt(rs.getString("ROOM_COUNT")));
					// roomSearch.setPricePerDay(Integer.parseInt(rs.getString("PRICE_PER_DAY")));

					roomDetailsList.add(roomSearch);
				}

				System.out.println("#### roomDetailsList " + roomDetailsList);
				return roomDetailsList;
			} catch (SQLException e) {
				System.out.println(e);

			} finally {
				DatabaseUtil.closeResultSet(rs);
				DatabaseUtil.closePreparedStatement(ps);
				pool.closeConnection(connection);
			}

		}
		return null;

	}

	@Override
	public UserProfile getUserProfile(String username, boolean testDb) {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = connection.prepareStatement(GET_USER_PROFILE_SQL);
			ps.setString(1, username);
			rs = ps.executeQuery();
			UserProfile userPro = null;

			if (rs.next()) {
				userPro = new UserProfile();

				userPro.setUserName(rs.getString("USER_NAME"));
				userPro.setFirstName(rs.getString("FIRST_NAME"));
				userPro.setLastName(rs.getString("LAST_NAME"));
				userPro.setEmailId(rs.getString("EMAIL_ID"));
				userPro.setPassword(rs.getString("PASSWORD"));

			}
			return userPro;
		} catch (SQLException e) {
			System.out.println(e);

		} finally {
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}
		return null;

	}

	@Override
	public boolean getPaymentValidity(String cardNumberInt, String cardName, int cvvNumberInt, String expDate, boolean testDb) {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		
		Date expDateUtil = null;

		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		try {

			expDateUtil = (Date) formatter.parse(expDate);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		SimpleDateFormat destFormatter = new SimpleDateFormat("yyyy-MM-dd");
		
		String expDateInput = destFormatter.format(expDateUtil);
		
		java.sql.Date expDateSql = new java.sql.Date(expDateUtil.getTime());
		
		System.out.println("&&%%##@@ expDate " + expDate);
		System.out.println("&&%%##@@ expDateUtil " + expDateUtil);
		System.out.println("&&%%##@@ expDateInput " + expDateInput);
		System.out.println("&&%%##@@ expDateSql " + expDateSql);


		int CVV_NUMBER = 0;
		String cName = null;
		String expDateDB = null;

		try {
			ps = connection.prepareStatement(GET_CARD_DETAIL_SQL);
			ps.setString(1, cardNumberInt);
			rs = ps.executeQuery();
			UserProfile userPro = null;

			while (rs.next()) {

				cName = rs.getString("NAME_ON_CARD");
				CVV_NUMBER = Integer.parseInt(rs.getString("CVV_NUMBER"));
				expDateDB = rs.getString("EXPIRY_DATE");
			}

			if (cName != null && !cName.isEmpty() && cName.equals(cardName) && CVV_NUMBER == cvvNumberInt && expDateDB.equals(expDateInput)) {

				return true;
			}

		} catch (SQLException e) {
			System.out.println(e);

		} finally {
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}
		return false;

	}

	@Override
	public int saveBookingDetails(RoomBookingDetails roomBookingDetails, boolean testDb) {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;

		Date fromDate = null;
		Date toDate = null;

		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		try {

			fromDate = (Date) formatter.parse(roomBookingDetails.getFromDate());
			toDate = (Date) formatter.parse(roomBookingDetails.getToDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}

		java.sql.Date fromDateSql = new java.sql.Date(fromDate.getTime());
		java.sql.Date toDateSql = new java.sql.Date(toDate.getTime());

		try {
			ps = connection.prepareStatement(INSERT_BOOKING_DETAIL_SQL);
			ps.setString(1, roomBookingDetails.getUserName());
			ps.setDate(2, fromDateSql);
			ps.setDate(3, toDateSql);
			ps.setString(4, roomBookingDetails.getRoomType());
			ps.setInt(5, roomBookingDetails.getNoOfRooms());
			ps.setInt(6, roomBookingDetails.getNoOfAdults());
			ps.setDouble(7, roomBookingDetails.getBasicPrice());
			ps.setDouble(8, roomBookingDetails.getExtraGuestFee());
			ps.setDouble(9, roomBookingDetails.getTaxAmount());
			ps.setDouble(10, roomBookingDetails.getTotalPrice());

			return ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}

		return 0;

	}

	@Override
	public boolean updateRoomAvailable(RoomBookingDetails roomBookingDetails, boolean testDb) {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;

		Date fromDate = null;
		Date toDate = null;

		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		try {

			fromDate = (Date) formatter.parse(roomBookingDetails.getFromDate());
			toDate = (Date) formatter.parse(roomBookingDetails.getToDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}

		java.sql.Date fromDateSql = new java.sql.Date(fromDate.getTime());
		java.sql.Date toDateSql = new java.sql.Date(toDate.getTime());

		int roomNo = roomBookingDetails.getNoOfRooms();
		String roomType = roomBookingDetails.getRoomType();

		try {
			// ps = connection.prepareStatement(UPDATE_ROOM_AVAILABLE_SQL);

			ps = connection.prepareStatement("UPDATE ROOM_AVAILABLE SET NO_OF_ROOMS = NO_OF_ROOMS -" + roomNo
					+ " where  DATE_CHECK >= '" + fromDateSql + "' and DATE_CHECK <= '" + toDateSql
					+ "' and ROOM_TYPE = '" + roomType + "' ;");
			System.out.println("### UPDATE ROOM_AVAILABLE SET NO_OF_ROOMS = NO_OF_ROOMS -" + roomNo
					+ " where  DATE_CHECK >= '" + fromDateSql + "' and DATE_CHECK <= '" + toDateSql
					+ "' and ROOM_TYPE = '" + roomType + "' ;");

			/*
			 * ps.setDate(1, fromDateSql); ps.setDate(2, toDateSql);
			 * ps.setString(3, roomBookingDetails.getRoomType()); ps.setInt(4,
			 * roomBookingDetails.getNoOfRooms()); ps.setDouble(5,
			 * roomBookingDetails.getBasicPrice()); ps.setDouble(6,
			 * roomBookingDetails.getTaxAmount()); ps.setDouble(7,
			 * roomBookingDetails.getTotalPrice());
			 */

			ps.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}

		return false;
	}

	@Override
	public double getRoomPricePerDay(String roomType, boolean testDb) {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;
		ResultSet rs = null;
		double roomPrice = 0;

		try {
			ps = connection.prepareStatement(GET_ROOM_PRICE_SQL);
			ps.setString(1, roomType);
			rs = ps.executeQuery();
			// UserProfile userPro = null;

			while (rs.next()) {

				roomPrice = Double.parseDouble(rs.getString("PRICE_PER_DAY"));

			}
			// return roomPrice;
		} catch (SQLException e) {
			System.out.println(e);

		} finally {
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}
		return roomPrice;

	}

	@Override
	public List<RoomBookingDetails> getBookingDetails(String userName, boolean testDb) {

		// TODO Auto-generated method stub
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;
		PreparedStatement psCheck = null;
		ResultSet rs = null;

		List<RoomBookingDetails> roomBookingDetailList = new ArrayList<RoomBookingDetails>();

		try {
			// ps = connection.prepareStatement(GET_ROOM_DETAILS_SQL);
			ps = connection.prepareStatement("SELECT * from ROOM_BOOKING_DETAIL where USER_NAME = '" + userName + "' and STATUS = 'new' ;");
			System.out.println("%%% SELECT * from ROOM_BOOKING_DETAIL where USER_NAME = '" + userName + "' and STATUS = 'new' ;");
			rs = ps.executeQuery();
			RoomBookingDetails roomBookingDetail = null;

			while (rs.next()) {
				roomBookingDetail = new RoomBookingDetails();

				roomBookingDetail.setBookingId(Integer.parseInt(rs.getString("BOOKING_ID")));
				roomBookingDetail.setUserName(rs.getString("USER_NAME"));
				roomBookingDetail.setFromDate(rs.getString("FROM_DATE"));
				roomBookingDetail.setToDate(rs.getString("TO_DATE"));
				roomBookingDetail.setRoomType(rs.getString("ROOM_TYPE"));
				roomBookingDetail.setNoOfRooms(Integer.parseInt(rs.getString("NO_OF_ROOM")));
				roomBookingDetail.setNoOfAdults(Integer.parseInt(rs.getString("NO_OF_ADULTS")));
				roomBookingDetail.setBasicPrice(Double.parseDouble(rs.getString("BASIC_PRICE")));
				roomBookingDetail.setExtraGuestFee(Double.parseDouble(rs.getString("GUEST_CHARGE")));
				roomBookingDetail.setTaxAmount(Double.parseDouble(rs.getString("TAX_AMOUNT")));
				roomBookingDetail.setTotalPrice(Double.parseDouble(rs.getString("TOTAL_PRICE")));
				roomBookingDetail.setStatus(rs.getString("STATUS"));

				roomBookingDetailList.add(roomBookingDetail);
			}

			System.out.println("#### roomBookingDetailList " + roomBookingDetailList);
			return roomBookingDetailList;
		} catch (SQLException e) {
			System.out.println(e);

		} finally {
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}
		return null;
	}

	// Above Done

	@Override
	public boolean cancelBookingDetail(RoomBookingDetails bookingDetail, boolean testDb) {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;
		PreparedStatement ps2 = null;

		long bookIdLong = bookingDetail.getBookingId();

		int noOfRoom = bookingDetail.getNoOfRooms();
		String fromDateStr = bookingDetail.getFromDate();
		String toDateStr = bookingDetail.getToDate();
		String roomType = bookingDetail.getRoomType();

		Date fromDate = null;
		Date toDate = null;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		// SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		try {

			fromDate = (Date) formatter.parse(fromDateStr);
			toDate = (Date) formatter.parse(toDateStr);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		java.sql.Date fromDateSql = new java.sql.Date(fromDate.getTime());
		java.sql.Date toDateSql = new java.sql.Date(toDate.getTime());

		// long bookIdLong = Long.parseLong(bookingId);

		try {
			// ps = connection.prepareStatement(UPDATE_ROOM_AVAILABLE_SQL);
			// delete the booking record
			/*ps = connection.prepareStatement("DELETE from ROOM_BOOKING_DETAIL where BOOKING_ID = " + bookIdLong + ";");
			System.out.println("DELETE from ROOM_BOOKING_DETAIL where BOOKING_ID = " + bookIdLong + ";");*/
			
			ps = connection.prepareStatement("UPDATE ROOM_BOOKING_DETAIL SET STATUS = 'cancel' where BOOKING_ID = " + bookIdLong + ";");
			System.out.println("UPDATE ROOM_BOOKING_DETAIL SET STATUS = 'cancel' where BOOKING_ID = " + bookIdLong + ";");

			ps.executeUpdate();

			ps2 = connection.prepareStatement("UPDATE ROOM_AVAILABLE SET NO_OF_ROOMS = NO_OF_ROOMS +" + noOfRoom
					+ " where  DATE_CHECK >= '" + fromDateSql + "' and DATE_CHECK <= '" + toDateSql
					+ "' and ROOM_TYPE = '" + roomType + "' ;");
			ps2.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}

		return false;
	}

	@Override
	public RoomBookingDetails getBookingDetailsById(String bookingId, boolean testDb) {

		// TODO Auto-generated method stub
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;
		PreparedStatement psCheck = null;
		ResultSet rs = null;

		List<RoomBookingDetails> roomBookingDetailList = new ArrayList<RoomBookingDetails>();

		try {
			// ps = connection.prepareStatement(GET_ROOM_DETAILS_SQL);
			ps = connection
					.prepareStatement("SELECT * from ROOM_BOOKING_DETAIL where BOOKING_ID = '" + bookingId + "';");
			System.out.println("%%% SELECT * from ROOM_BOOKING_DETAIL where BOOKING_ID = '" + bookingId + "';");
			rs = ps.executeQuery();
			RoomBookingDetails roomBookingDetail = null;

			while (rs.next()) {
				roomBookingDetail = new RoomBookingDetails();

				roomBookingDetail.setBookingId(Integer.parseInt(rs.getString("BOOKING_ID")));
				roomBookingDetail.setUserName(rs.getString("USER_NAME"));
				roomBookingDetail.setFromDate(rs.getString("FROM_DATE"));
				roomBookingDetail.setToDate(rs.getString("TO_DATE"));
				roomBookingDetail.setRoomType(rs.getString("ROOM_TYPE"));
				roomBookingDetail.setNoOfRooms(Integer.parseInt(rs.getString("NO_OF_ROOM")));
				roomBookingDetail.setNoOfAdults(Integer.parseInt(rs.getString("NO_OF_ADULTS")));
				roomBookingDetail.setBasicPrice(Double.parseDouble(rs.getString("BASIC_PRICE")));
				roomBookingDetail.setExtraGuestFee(Double.parseDouble(rs.getString("GUEST_CHARGE")));
				roomBookingDetail.setTaxAmount(Double.parseDouble(rs.getString("TAX_AMOUNT")));
				roomBookingDetail.setTotalPrice(Double.parseDouble(rs.getString("TOTAL_PRICE")));
				roomBookingDetail.setStatus(rs.getString("STATUS"));

				// roomBookingDetailList.add(roomBookingDetail);
			}

			System.out.println("#### roomBookingDetail " + roomBookingDetail);
			return roomBookingDetail;
		} catch (SQLException e) {
			System.out.println(e);

		} finally {
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}
		return null;
	}

	@Override
	public boolean updateBookingDetails(RoomBookingDetails roomBookingDetails, boolean testDb) {
		// TODO Auto-generated method stub

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;

		Date fromDate = null;
		Date toDate = null;

		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
		try {

			fromDate = (Date) formatter.parse(roomBookingDetails.getFromDate());
			toDate = (Date) formatter.parse(roomBookingDetails.getToDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}

		java.sql.Date fromDateSql = new java.sql.Date(fromDate.getTime());
		java.sql.Date toDateSql = new java.sql.Date(toDate.getTime());

		int noOfRoom = roomBookingDetails.getNoOfRooms();
		int noOfAdult = roomBookingDetails.getNoOfAdults();
		String roomType = roomBookingDetails.getRoomType();
		double basicPrice = roomBookingDetails.getBasicPrice();
		double guestPrice = roomBookingDetails.getExtraGuestFee();
		double taxAmount = roomBookingDetails.getTaxAmount();
		double totalPrice = roomBookingDetails.getTotalPrice();
		long bookingId = roomBookingDetails.getBookingId();

		try {
			// ps = connection.prepareStatement(UPDATE_ROOM_AVAILABLE_SQL);

			ps = connection.prepareStatement("UPDATE ROOM_BOOKING_DETAIL SET FROM_DATE = '" + fromDateSql
					+ "' , TO_DATE = '" + toDateSql + "' , ROOM_TYPE = '" + roomType + "' , NO_OF_ROOM = '" + noOfRoom
					+ "' , NO_OF_ADULTS = '" + noOfAdult + "' , BASIC_PRICE = '" + basicPrice + "' , GUEST_CHARGE = '"
					+ guestPrice + "' , TAX_AMOUNT = '" + taxAmount + "' , TOTAL_PRICE = '" + totalPrice
					+ "' WHERE BOOKING_ID = '" + bookingId + "' ;");
			System.out.println("### UPDATE ROOM_BOOKING_DETAIL SET FROM_DATE = '" + fromDateSql + "' , TO_DATE = '"
					+ toDateSql + "' , ROOM_TYPE = '" + roomType + "' , NO_OF_ROOM = '" + noOfRoom
					+ "' , NO_OF_ADULTS = '" + noOfAdult + "' , BASIC_PRICE = '" + basicPrice + "' , GUEST_CHARGE = '"
					+ guestPrice + "' , TAX_AMOUNT = '" + taxAmount + "' , TOTAL_PRICE = '" + totalPrice
					+ "' WHERE BOOKING_ID = '" + bookingId + "' ;");

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}
		return false;

	}

	@Override
	public OperatorProfile getOperatorProfile(String userName, boolean testDb) {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			ps = connection.prepareStatement(GET_OPERATOR_PROFILE_SQL);
			ps.setString(1, userName);
			rs = ps.executeQuery();
			OperatorProfile oprProfile = null;

			if (rs.next()) {
				oprProfile = new OperatorProfile();

				oprProfile.setOprUserName(rs.getString("OPR_USER_NAME"));
				oprProfile.setOprFirstName(rs.getString("OPR_FIRST_NAME"));
				oprProfile.setOprLastName(rs.getString("OPR_LAST_NAME"));
				oprProfile.setOprEmailId(rs.getString("OPR_EMAIL_ID"));
				oprProfile.setOprPassword(rs.getString("OPR_PASSWORD"));

			}
			return oprProfile;
		} catch (SQLException e) {
			System.out.println(e);

		} finally {
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}
		return null;

	}

	@Override
	public List<String> searchRoomForEntry(String roomTypeName, int noOfRooms, boolean testDb) {
		// TODO Auto-generated method stub

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;
		PreparedStatement psCheck = null;
		ResultSet rs = null;

		List<String> roomList = new ArrayList<String>();

		try {
			// ps = connection.prepareStatement(GET_ROOM_DETAILS_SQL);
			ps = connection.prepareStatement("SELECT ROOM_NUMBER from ROOM_ENTRY_DETAIL where ROOM_TYPE = '"
					+ roomTypeName + "' and IS_AVAILABLE = true;");

			rs = ps.executeQuery();

			while (rs.next()) {

				roomList.add(rs.getString("ROOM_NUMBER"));

			}

			System.out.println("#### roomList " + roomList);
			return roomList;
		} catch (SQLException e) {
			System.out.println(e);

		} finally {
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}

		return null;

	}

	@Override
	public boolean saveRoomEntryDetails(RoomEntryDetails roomEntryDetails, boolean testDb) {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;

		Date fromDate = null;
		Date toDate = null;

		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		try {

			fromDate = (Date) formatter.parse(roomEntryDetails.getFromDate());
			toDate = (Date) formatter.parse(roomEntryDetails.getToDate());

		} catch (ParseException e) {
			e.printStackTrace();
		}

		java.sql.Date fromDateSql = new java.sql.Date(fromDate.getTime());
		java.sql.Date toDateSql = new java.sql.Date(toDate.getTime());

		try {
			// ps = connection.prepareStatement(INSERT_ROOM_ENTRY_DETAIL_SQL);

			for (String roomNo : roomEntryDetails.getRoomNumberChecked()) {

				ps = connection.prepareStatement("UPDATE ROOM_ENTRY_DETAIL SET OPR_USER_NAME = '"
						+ roomEntryDetails.getOprUserName() + "' , FROM_DATE = '" + fromDateSql + "' , TO_DATE = '"
						+ toDateSql + "' , FIRST_NAME = '" + roomEntryDetails.getFirstName() + "' , LAST_NAME = '"
						+ roomEntryDetails.getLastName() + "' , IS_AVAILABLE = 0 , BOOKING_ID = '"
						+ roomEntryDetails.getBookId() + "' WHERE ROOM_NUMBER = '" + roomNo + "';");

				System.out.println("&&&& UPDATE ROOM_ENTRY_DETAIL SET OPR_USER_NAME = '"
						+ roomEntryDetails.getOprUserName() + "' , FROM_DATE = '" + fromDateSql + "' , TO_DATE = '"
						+ toDateSql + "' , FIRST_NAME = '" + roomEntryDetails.getFirstName() + "' , LAST_NAME = '"
						+ roomEntryDetails.getLastName() + "' , IS_AVAILABLE = 0 , BOOKING_ID = '"
						+ roomEntryDetails.getBookId() + "' WHERE ROOM_NUMBER = '" + roomNo + "';");

				ps.executeUpdate();

			}
			return true;

		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}

		return false;

	}

	// TODO Below

	@Override
	public List<RoomEntryDetails> getRoomEntryDetails(boolean testDb) {

		// TODO Auto-generated method stub
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;
		PreparedStatement psCheck = null;
		ResultSet rs = null;

		List<RoomEntryDetails> roomEntryDetailsList = new ArrayList<RoomEntryDetails>();

		try {
			// ps = connection.prepareStatement(GET_ROOM_DETAILS_SQL);
			ps = connection.prepareStatement("SELECT * from ROOM_ENTRY_DETAIL where IS_AVAILABLE = false ;");
			System.out.println("%%% SELECT * from ROOM_ENTRY_DETAIL where IS_AVAILABLE = false");
			rs = ps.executeQuery();
			RoomEntryDetails roomEntryDetail = null;

			while (rs.next()) {
				roomEntryDetail = new RoomEntryDetails();

				roomEntryDetail.setRoomNumber(rs.getString("ROOM_NUMBER"));
				roomEntryDetail.setOprUserName(rs.getString("OPR_USER_NAME"));
				roomEntryDetail.setBookId(rs.getString("BOOKING_ID"));
				roomEntryDetail.setFirstName(rs.getString("FIRST_NAME"));
				roomEntryDetail.setLastName(rs.getString("LAST_NAME"));
				roomEntryDetail.setFromDate(rs.getString("FROM_DATE"));
				roomEntryDetail.setToDate(rs.getString("TO_DATE"));
				roomEntryDetail.setRoomType(rs.getString("ROOM_TYPE"));

				roomEntryDetailsList.add(roomEntryDetail);
			}

			System.out.println("#### roomBookingDetailList " + roomEntryDetailsList);
			return roomEntryDetailsList;
		} catch (SQLException e) {
			System.out.println(e);

		} finally {
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}
		return null;
	}

	@Override
	public RoomEntryDetails getRoomEntryDetailsByRoomNo(String roomNumber, boolean testDb) {

		// TODO Auto-generated method stub
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;
		PreparedStatement psCheck = null;
		ResultSet rs = null;

		//List<RoomEntryDetails> roomEntryDetailsList = new ArrayList<RoomEntryDetails>();
		RoomEntryDetails roomEntryDetail = null;

		try {
			// ps = connection.prepareStatement(GET_ROOM_DETAILS_SQL);
			ps = connection.prepareStatement("SELECT * from ROOM_ENTRY_DETAIL where ROOM_NUMBER = '" + roomNumber + "' ;");
			System.out.println("%%% SELECT * from ROOM_ENTRY_DETAIL where ROOM_NUMBER = '" + roomNumber + "' ;");
			rs = ps.executeQuery();
			

			while (rs.next()) {
				roomEntryDetail = new RoomEntryDetails();

				roomEntryDetail.setRoomNumber(rs.getString("ROOM_NUMBER"));
				roomEntryDetail.setOprUserName(rs.getString("OPR_USER_NAME"));
				roomEntryDetail.setBookId(rs.getString("BOOKING_ID"));
				roomEntryDetail.setFirstName(rs.getString("FIRST_NAME"));
				roomEntryDetail.setLastName(rs.getString("LAST_NAME"));
				roomEntryDetail.setFromDate(rs.getString("FROM_DATE"));
				roomEntryDetail.setToDate(rs.getString("TO_DATE"));
				roomEntryDetail.setRoomType(rs.getString("ROOM_TYPE"));

				//roomEntryDetailsList.add(roomEntryDetail);
			}

			System.out.println("#### roomEntryDetail " + roomEntryDetail);
			return roomEntryDetail;
		} catch (SQLException e) {
			System.out.println(e);

		} finally {
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}
		return null;
	}

	@Override
	public boolean checkoutRoomEntryDetail(RoomEntryDetails roomSelected, boolean testDb) {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;
		PreparedStatement psCheck = null;
		ResultSet rs = null;
		String roomNumber = roomSelected.getRoomNumber();


		try {
			
			ps = connection.prepareStatement("UPDATE ROOM_ENTRY_DETAIL SET IS_AVAILABLE = true , BOOKING_ID = null , FIRST_NAME = null, LAST_NAME = null, FROM_DATE = null, TO_DATE = null where ROOM_NUMBER = " + roomNumber + ";");
			System.out.println("UPDATE ROOM_ENTRY_DETAIL SET IS_AVAILABLE = true where ROOM_NUMBER = " + roomNumber + ";");

			ps.executeUpdate();

			return true;
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}

		return false;
	}

	@Override
	public List<RoomBookingDetails> getCancelledBookingDetails(String userName, boolean testDb) {

		// TODO Auto-generated method stub
		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection(testDb);
		PreparedStatement ps = null;
		PreparedStatement psCheck = null;
		ResultSet rs = null;

		List<RoomBookingDetails> roomBookingDetailList = new ArrayList<RoomBookingDetails>();

		try {
			// ps = connection.prepareStatement(GET_ROOM_DETAILS_SQL);
			ps = connection.prepareStatement("SELECT * from ROOM_BOOKING_DETAIL where USER_NAME = '" + userName + "' and STATUS = 'cancel' ;");
			System.out.println("%%% SELECT * from ROOM_BOOKING_DETAIL where USER_NAME = '" + userName + "' and STATUS = 'cancel' ;");
			rs = ps.executeQuery();
			RoomBookingDetails roomBookingDetail = null;

			while (rs.next()) {
				roomBookingDetail = new RoomBookingDetails();

				roomBookingDetail.setBookingId(Integer.parseInt(rs.getString("BOOKING_ID")));
				roomBookingDetail.setUserName(rs.getString("USER_NAME"));
				roomBookingDetail.setFromDate(rs.getString("FROM_DATE"));
				roomBookingDetail.setToDate(rs.getString("TO_DATE"));
				roomBookingDetail.setRoomType(rs.getString("ROOM_TYPE"));
				roomBookingDetail.setNoOfRooms(Integer.parseInt(rs.getString("NO_OF_ROOM")));
				roomBookingDetail.setNoOfAdults(Integer.parseInt(rs.getString("NO_OF_ADULTS")));
				roomBookingDetail.setBasicPrice(Double.parseDouble(rs.getString("BASIC_PRICE")));
				roomBookingDetail.setExtraGuestFee(Double.parseDouble(rs.getString("GUEST_CHARGE")));
				roomBookingDetail.setTaxAmount(Double.parseDouble(rs.getString("TAX_AMOUNT")));
				roomBookingDetail.setTotalPrice(Double.parseDouble(rs.getString("TOTAL_PRICE")));
				roomBookingDetail.setStatus(rs.getString("STATUS"));

				roomBookingDetailList.add(roomBookingDetail);
			}

			System.out.println("#### roomBookingDetailList " + roomBookingDetailList);
			return roomBookingDetailList;
		} catch (SQLException e) {
			System.out.println(e);

		} finally {
			DatabaseUtil.closeResultSet(rs);
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}
		return null;
	}

}
