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

import com.ssdi.project.access.db.test.ConnectionPoolTest;
import com.ssdi.project.access.db.test.DatabaseUtilTest;
import com.ssdi.project.beans.RoomBookingDetails;
import com.ssdi.project.beans.RoomSearchDetail;
import com.ssdi.project.beans.UserProfile;

public class UserProfileDaoImpl implements UserProfileDao {

	private static final String INSERT_SQL = "INSERT INTO USERPROFILE (USER_NAME, FIRST_NAME, LAST_NAME, EMAIL_ID, PASSWORD) VALUES (?,?,?,?,?)";
	private static final String GET_USER_PROFILE_SQL = "SELECT * from USERPROFILE WHERE USER_NAME = ?";
	private static final String GET_ROOM_DETAILS_SQL = "SELECT ROOM_TYPE, min(NO_OF_ROOMS), PRICE_PER_DAY AS ROOM_COUNT from ROOM_AVAILABLE where DATE_CHECK >= ? and DATE_CHECK <= ? GROUP BY ROOM_TYPE";
	private static final String GET_CARD_DETAIL_SQL = "SELECT * from PAYMENT_CARD_DETAIL WHERE CARD_NUMBER = ?";
	private static final String INSERT_BOOKING_DETAIL_SQL = "INSERT INTO ROOM_BOOKING_DETAIL (FROM_DATE, TO_DATE, ROOM_TYPE, NO_OF_ROOM, BASIC_PRICE, TAX_AMOUNT, TOTAL_PRICE) VALUES (?,?,?,?,?,?,?)";
	private static final String UPDATE_ROOM_AVAILABLE_SQL = "UPDATE ROOM_AVAILABLE SET NO_OF_ROOMS = NO_OF_ROOMS - ? where  DATE_CHECK >= ? and DATE_CHECK <= ? and ROOM_TYPE = ?";

	DataSource dataSource;

	@Override
	public int insertProfile(UserProfile userProfile) {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
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
			return 0;
		} finally {
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}

	}

	@Override
	public List<RoomSearchDetail> searchForRoom(Date fromDate, Date toDate) {
		// TODO Auto-generated method stub

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		java.sql.Date fromDateSql = new java.sql.Date(fromDate.getTime());
		java.sql.Date toDateSql = new java.sql.Date(toDate.getTime());

		List<RoomSearchDetail> roomDetailsList = new ArrayList<RoomSearchDetail>();
		System.out.println(
				"@@@ SELECT ROOM_TYPE, min(NO_OF_ROOMS) AS ROOM_COUNT, PRICE_PER_DAY from ROOM_AVAILABLE where DATE_CHECK >= '"
						+ fromDateSql + "' and DATE_CHECK <= '" + toDateSql + "' GROUP BY ROOM_TYPE ;");

		try {
			// ps = connection.prepareStatement(GET_ROOM_DETAILS_SQL);
			ps = connection.prepareStatement(
					"SELECT ROOM_TYPE, min(NO_OF_ROOMS) AS ROOM_COUNT, PRICE_PER_DAY from ROOM_AVAILABLE where DATE_CHECK >= '"
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
				roomSearch.setPricePerDay(Integer.parseInt(rs.getString("PRICE_PER_DAY")));

				roomDetailsList.add(roomSearch);
			}
			return roomDetailsList;
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
	public UserProfile getUserProfile(String username) {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
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
	public boolean getPaymentValidity(int cardNumberInt, String cardName, int cvvNumberInt) {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		int CVV_NUMBER = 0;
		String cName = null;

		try {
			ps = connection.prepareStatement(GET_CARD_DETAIL_SQL);
			ps.setInt(1, cardNumberInt);
			rs = ps.executeQuery();
			UserProfile userPro = null;

			while (rs.next()) {

				cName = rs.getString("NAME_ON_CARD");
				CVV_NUMBER = Integer.parseInt(rs.getString("CVV_NUMBER"));
			}

			if (cName != null && !cName.isEmpty() && cName.equals(cardName) && CVV_NUMBER == cvvNumberInt) {

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
	public void saveBookingDetails(RoomBookingDetails roomBookingDetails) {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;

		Date fromDate = null;
		Date toDate = null;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

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
			ps.setDate(1, fromDateSql);
			ps.setDate(2, toDateSql);
			ps.setString(3, roomBookingDetails.getRoomType());
			ps.setInt(4, roomBookingDetails.getNoOfRooms());
			ps.setDouble(5, roomBookingDetails.getBasicPrice());
			ps.setDouble(6, roomBookingDetails.getTaxAmount());
			ps.setDouble(7, roomBookingDetails.getTotalPrice());

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}

	}

	@Override
	public void updateRoomAvailable(RoomBookingDetails roomBookingDetails) {

		ConnectionPool pool = ConnectionPool.getInstance();
		Connection connection = pool.getConnection();
		PreparedStatement ps = null;

		Date fromDate = null;
		Date toDate = null;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

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
			//ps = connection.prepareStatement(UPDATE_ROOM_AVAILABLE_SQL);
			
			ps = connection.prepareStatement("UPDATE ROOM_AVAILABLE SET NO_OF_ROOMS = NO_OF_ROOMS -" + roomNo+ " where  DATE_CHECK >= '" + fromDateSql + "' and DATE_CHECK <= '" + toDateSql +"' and ROOM_TYPE = '" + roomType+"' ;");
			System.out.println("### UPDATE ROOM_AVAILABLE SET NO_OF_ROOMS = NO_OF_ROOMS -" + roomNo+ " where  DATE_CHECK >= '" + fromDateSql + "' and DATE_CHECK <= '" + toDateSql +"' and ROOM_TYPE = '" + roomType+"' ;");
			
			/*ps.setDate(1, fromDateSql);
			ps.setDate(2, toDateSql);
			ps.setString(3, roomBookingDetails.getRoomType());
			ps.setInt(4, roomBookingDetails.getNoOfRooms());
			ps.setDouble(5, roomBookingDetails.getBasicPrice());
			ps.setDouble(6, roomBookingDetails.getTaxAmount());
			ps.setDouble(7, roomBookingDetails.getTotalPrice());*/

			ps.executeUpdate();
		} catch (SQLException e) {
			System.out.println(e);
		} finally {
			DatabaseUtil.closePreparedStatement(ps);
			pool.closeConnection(connection);
		}

	}

}
