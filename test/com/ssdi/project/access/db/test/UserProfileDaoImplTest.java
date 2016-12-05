package com.ssdi.project.access.db.test;

import static org.junit.Assert.*;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ssdi.project.access.db.ConnectionPool;
import com.ssdi.project.access.db.DatabaseUtil;
import com.ssdi.project.access.db.UserProfileDao;
import com.ssdi.project.access.db.UserProfileDaoImpl;
import com.ssdi.project.beans.OperatorProfile;
import com.ssdi.project.beans.RoomBookingDetails;
import com.ssdi.project.beans.RoomEntryDetails;
import com.ssdi.project.beans.RoomSearchDetail;
import com.ssdi.project.beans.UserContactDetail;
import com.ssdi.project.beans.UserProfile;

public class UserProfileDaoImplTest {

	public UserProfileDaoImplTest() {
	}

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() {
	}

	@After
	public void tearDown() {
	}

	@Test
	public void testInsertProfile() {
		UserProfile user = new UserProfile();

		/*
		 * user.setFirstName("satish"); user.setLastName("kumar");
		 * user.setUserName("skumar"); user.setPassword("kumar123");
		 * user.setEmailId("sat@gmail.com");
		 */

		user.setFirstName("ramesh");
		user.setLastName("kumar");
		user.setUserName("rkumar");
		user.setPassword("kumar123");
		user.setEmailId("ramesh@gmail.com");

		int expResult = 0;
		UserProfileDao userDao = new UserProfileDaoImpl();
		int result = userDao.insertProfile(user, true);
		assertEquals(expResult, result);
	}

	@Test
	public void testInsertProfile2() {
		UserProfile user = new UserProfile();

		user.setFirstName("ramesh");
		user.setLastName("kumar");
		user.setUserName("rkumar");
		user.setPassword("kumar123");
		user.setEmailId("ramesh@gmail.com");

		int expResult = 0;
		UserProfileDao userDao = new UserProfileDaoImpl();
		int result = userDao.insertProfile(user, true);
		assertEquals(expResult, result);
	}

	@Test
	public void testSearchForRoom() {

		String fromDateStr = "11/30/2016";
		String toDateStr = "11/30/2016";
		Date fromDate = null;
		Date toDate = null;

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		try {

			fromDate = (Date) formatter.parse(fromDateStr);
			toDate = (Date) formatter.parse(toDateStr);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		UserProfileDao userDao = new UserProfileDaoImpl();
		List<RoomSearchDetail> expResult = new ArrayList<RoomSearchDetail>();
		List<RoomSearchDetail> result = userDao.searchForRoom(fromDate, toDate, true);

		/*
		 * for (RoomSearchDetail detail: result){
		 * 
		 * }
		 */

		RoomSearchDetail searchDetail1 = new RoomSearchDetail();
		searchDetail1.setRoomType("deluxe");
		searchDetail1.setNoOfRooms(5);
		searchDetail1.setFromDate(null);
		searchDetail1.setToDate(null);

		expResult.add(searchDetail1);
		/*
		 * expResult.add(searchDetail3); expResult.add(searchDetail2);
		 */
		// assertEquals(expResult, result);

		for (RoomSearchDetail detail : result) {

			// System.out.println("$$$$## detail " + detail.toString());
			assertEquals("deluxe", detail.getRoomType());
			assertEquals(5, detail.getNoOfRooms());
		}
	}

	@Test
	public void testSearchForRoom2() {

		String fromDateStr = "12/01/2016";
		String toDateStr = "11/30/2016";
		Date fromDate = null;
		Date toDate = null;

		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		try {

			fromDate = (Date) formatter.parse(fromDateStr);
			toDate = (Date) formatter.parse(toDateStr);

		} catch (ParseException e) {
			e.printStackTrace();
		}

		UserProfileDao userDao = new UserProfileDaoImpl();
		List<RoomSearchDetail> expResult = new ArrayList<RoomSearchDetail>();
		List<RoomSearchDetail> result = userDao.searchForRoom(fromDate, toDate, true);
		assertEquals(expResult, result);

	}

	@Test
	public void testGetUserProfile() {
		String username = "skumar";
		UserProfile userProfileExp = new UserProfile();
		UserProfileDao userDao = new UserProfileDaoImpl();
		UserProfile result = userDao.getUserProfile(username, true);
		assertEquals("skumar", result.getUserName());
		assertEquals("satish", result.getFirstName());
		assertEquals("kumar", result.getLastName());
		assertEquals("sat@gmail.com", result.getEmailId());
		assertEquals("kumar123", result.getPassword());
		// assertEquals(userProfileExp, result);
	}

	@Test
	public void testGetUserProfile2() {
		String username = "ssskumar";
		UserProfile userProfileExp = new UserProfile();
		UserProfileDao userDao = new UserProfileDaoImpl();
		UserProfile result = userDao.getUserProfile(username, true);
		/*
		 * assertEquals("ssskumar", result.getUserName());
		 * assertEquals("satish", result.getFirstName()); assertEquals("kumar",
		 * result.getLastName()); assertEquals("sat@gmail.com",
		 * result.getEmailId()); assertEquals("kumar123", result.getPassword());
		 */
		assertEquals(null, result);
	}

	@Test
	public void testGetPaymentValidity() {

		String cardNumberInt = "1234567812345678";
		String cardName = "satish";
		int cvvNumberInt = 123;

		boolean flag = false;

		UserProfileDao userDao = new UserProfileDaoImpl();
		boolean result = userDao.getPaymentValidity(cardNumberInt, cardName, cvvNumberInt, true);
		assertEquals(true, result);
	}

	@Test
	public void testGetPaymentValidity2() {

		String cardNumberInt = "123456";
		String cardName = "satish";
		int cvvNumberInt = 123;

		boolean flag = false;

		UserProfileDao userDao = new UserProfileDaoImpl();
		boolean result = userDao.getPaymentValidity(cardNumberInt, cardName, cvvNumberInt, true);
		assertEquals(false, result);
	}

	@Test
	public void testSaveBookingDetails() {

		RoomBookingDetails roomBookingDetails = new RoomBookingDetails();
		roomBookingDetails.setUserName("ksatish17");
		roomBookingDetails.setFromDate("11/30/2016");
		roomBookingDetails.setToDate("12/02/2016");
		roomBookingDetails.setRoomType("deluxe");
		roomBookingDetails.setNoOfRooms(2);
		roomBookingDetails.setNoOfAdults(5);
		roomBookingDetails.setBasicPrice(2000);
		roomBookingDetails.setExtraGuestFee(500);
		roomBookingDetails.setTaxAmount(750);
		roomBookingDetails.setTotalPrice(7700);

		boolean flag = false;

		UserProfileDao userDao = new UserProfileDaoImpl();
		int result = userDao.saveBookingDetails(roomBookingDetails, true);
		assertEquals(1, result);
	}

	@Test
	public void testSaveBookingDetails2() {

		RoomBookingDetails roomBookingDetails = new RoomBookingDetails();
		roomBookingDetails.setUserName("ksat17");
		roomBookingDetails.setFromDate("11/30/2016");
		roomBookingDetails.setToDate("12/02/2016");
		roomBookingDetails.setRoomType("deluxe");
		roomBookingDetails.setNoOfRooms(2);
		roomBookingDetails.setNoOfAdults(5);
		roomBookingDetails.setBasicPrice(2000);
		roomBookingDetails.setExtraGuestFee(500);
		roomBookingDetails.setTaxAmount(750);
		roomBookingDetails.setTotalPrice(7700);

		boolean flag = false;

		UserProfileDao userDao = new UserProfileDaoImpl();
		int result = userDao.saveBookingDetails(roomBookingDetails, true);
		assertEquals(0, result);
	}

	@Test
	public void testUpdateRoomAvailable() {

		RoomBookingDetails roomBookingDetails = new RoomBookingDetails();
		roomBookingDetails.setFromDate("12/03/2016");
		roomBookingDetails.setToDate("12/03/2016");
		roomBookingDetails.setRoomType("deluxe");
		roomBookingDetails.setNoOfRooms(1);
		roomBookingDetails.setBasicPrice(2000);
		roomBookingDetails.setTaxAmount(750);
		roomBookingDetails.setTotalPrice(7700);

		boolean flag = false;

		UserProfileDao userDao = new UserProfileDaoImpl();
		boolean result = userDao.updateRoomAvailable(roomBookingDetails, true);
		assertEquals(true, result);
	}

	@Test
	public void testUpdateRoomAvailable2() {

		RoomBookingDetails roomBookingDetails = new RoomBookingDetails();
		roomBookingDetails.setFromDate("12/03/2016");
		roomBookingDetails.setToDate("11/03/2016");
		roomBookingDetails.setRoomType("sdgdfhfg");
		roomBookingDetails.setNoOfRooms(1);
		roomBookingDetails.setBasicPrice(2000);
		roomBookingDetails.setTaxAmount(750);
		roomBookingDetails.setTotalPrice(7700);

		boolean flag = false;

		UserProfileDao userDao = new UserProfileDaoImpl();
		boolean result = userDao.updateRoomAvailable(roomBookingDetails, true);
		assertEquals(true, result);
	}

	@Test
	public void testInsertContactDetails() {

		UserContactDetail userContact = new UserContactDetail();

		/*
		 * user.setFirstName("satish"); user.setLastName("kumar");
		 * user.setUserName("skumar"); user.setPassword("kumar123");
		 * user.setEmailId("sat@gmail.com");
		 */

		userContact.setFirstname("ramesh");
		userContact.setLastname("kumar");
		userContact.setUsername("rkumar");
		userContact.setAddress1("412");
		userContact.setAddress2("Barton");
		userContact.setCity("Charlotte");
		userContact.setState("NC");
		userContact.setZip("28262");
		userContact.setPhoneNumber("1234567890");

		int expResult = 0;
		UserProfileDao userDao = new UserProfileDaoImpl();
		int result = userDao.insertContactDetails(userContact, true);
		assertEquals(expResult, result);
	}

	@Test
	public void testInsertContactDetails2() {

		UserContactDetail userContact = new UserContactDetail();

		/*
		 * user.setFirstName("satish"); user.setLastName("kumar");
		 * user.setUserName("skumar"); user.setPassword("kumar123");
		 * user.setEmailId("sat@gmail.com");
		 */

		userContact.setFirstname("ramesh");
		userContact.setLastname("kumar");
		userContact.setUsername("rkumar");
		userContact.setAddress1("412");
		userContact.setAddress2("Barton");
		userContact.setCity("Charlotte");
		userContact.setCountry("USA");
		userContact.setState("NC");
		userContact.setZip("28262");
		userContact.setPhoneNumber("1234567890");

		int expResult = 0;
		UserProfileDao userDao = new UserProfileDaoImpl();
		int result = userDao.insertContactDetails(userContact, true);
		assertEquals(expResult, result);
	}

	private static final double DELTA = 1e-15;

	@Test
	public void testGetRoomPricePerDay() {

		String rType = "deluxe";

		double expResult = 2000.0;
		UserProfileDao userDao = new UserProfileDaoImpl();
		double result = userDao.getRoomPricePerDay(rType, true);
		System.out.println("%%% result " + result);
		assertEquals(expResult, result, DELTA);
	}

	@Test
	public void testGetRoomPricePerDay2() {

		String rType = "deluxeee";

		double expResult = 2000.0;
		UserProfileDao userDao = new UserProfileDaoImpl();
		double result = userDao.getRoomPricePerDay(rType, true);
		System.out.println("%%% result " + result);
		assertEquals(0.0, result, 0.001);
	}

	@Test
	public void testGetBookingDetails() {

		String uName = "testUser";

		List<RoomBookingDetails> bookingList = new ArrayList<RoomBookingDetails>();

		List<RoomBookingDetails> expResult = new ArrayList<RoomBookingDetails>();
		RoomBookingDetails room = new RoomBookingDetails();
		room.setUserName("testUser");
		room.setFromDate("2016-11-30");
		room.setToDate("2016-11-30");
		room.setTotalPrice(2700.0);
		room.setRoomType("luxury");
		room.setNoOfRooms(1);
		room.setNoOfAdults(3);
		room.setTaxAmount(200.0);
		room.setBasicPrice(2500.0);
		room.setExtraGuestFee(500.0);
		room.setBookingId(71);
		room.setNetAmountPay(0.0);
		room.setContactDetail(null);

		expResult.add(room);

		UserProfileDao userDao = new UserProfileDaoImpl();
		bookingList = userDao.getBookingDetails(uName, true);
		System.out.println("%%% result " + bookingList.toString());

		for (RoomBookingDetails roomDet : bookingList) {
			assertEquals(2500.0, roomDet.getBasicPrice(), DELTA);
			assertEquals("luxury", roomDet.getRoomType());

		}

	}

	@Test
	public void testGetBookingDetails2() {

		String uName = "test123";

		List<RoomBookingDetails> bookingList = new ArrayList<RoomBookingDetails>();

		List<RoomBookingDetails> expResult = new ArrayList<RoomBookingDetails>();
		RoomBookingDetails room = new RoomBookingDetails();
		/*
		 * room.setUserName("testUser"); room.setFromDate("2016-11-30");
		 * room.setToDate("2016-11-30"); room.setTotalPrice(2700.0);
		 * room.setRoomType("luxury"); room.setNoOfRooms(1);
		 * room.setNoOfAdults(3); room.setTaxAmount(200.0);
		 * room.setBasicPrice(2500.0); room.setExtraGuestFee(500.0);
		 * room.setBookingId(71); room.setNetAmountPay(0.0);
		 * room.setContactDetail(null);
		 */

		// expResult.add(room);

		UserProfileDao userDao = new UserProfileDaoImpl();
		bookingList = userDao.getBookingDetails(uName, true);
		System.out.println("%%$ result " + bookingList.toString());
		assertEquals(expResult, bookingList);

	}

	@Test
	public void testCancelBookingDetail() {

		boolean cancel;

		RoomBookingDetails room = new RoomBookingDetails();
		room.setUserName("testUser");
		room.setFromDate("2016-11-30");
		room.setToDate("2016-11-30");
		room.setTotalPrice(2700.0);
		room.setRoomType("luxury");
		room.setNoOfRooms(1);
		room.setNoOfAdults(3);
		room.setTaxAmount(200.0);
		room.setBasicPrice(2500.0);
		room.setExtraGuestFee(500.0);
		room.setBookingId(71);
		room.setNetAmountPay(0.0);
		room.setContactDetail(null);

		// expResult.add(room);

		UserProfileDao userDao = new UserProfileDaoImpl();
		cancel = userDao.cancelBookingDetail(room, true);
		System.out.println("%%$ cancel " + cancel);
		assertEquals(true, cancel);

	}

	@Test
	public void testCancelBookingDetail2() {

		boolean cancel;

		RoomBookingDetails room = new RoomBookingDetails();
		room.setUserName("testUser");
		room.setFromDate("2016-11-30");
		room.setToDate("2016-11-30");
		room.setTotalPrice(2700.0);
		room.setRoomType("luxury");
		room.setNoOfRooms(1);
		room.setNoOfAdults(3);
		room.setTaxAmount(200.0);
		room.setBasicPrice(2500.0);
		room.setExtraGuestFee(500.0);
		room.setBookingId(51);
		room.setNetAmountPay(0.0);
		room.setContactDetail(null);

		// expResult.add(room);

		UserProfileDao userDao = new UserProfileDaoImpl();
		cancel = userDao.cancelBookingDetail(room, true);
		System.out.println("%%$ cancel " + cancel);
		assertEquals(true, cancel);

	}

	@Test
	public void testGetBookingDetailsById() {

		boolean cancel;
		String booking = "12";

		RoomBookingDetails room = new RoomBookingDetails();
		/*
		 * room.setUserName("testUser"); room.setFromDate("2016-11-30");
		 * room.setToDate("2016-11-30"); room.setTotalPrice(2700.0);
		 * room.setRoomType("luxury"); room.setNoOfRooms(1);
		 * room.setNoOfAdults(3); room.setTaxAmount(200.0);
		 * room.setBasicPrice(2500.0); room.setExtraGuestFee(500.0);
		 * room.setBookingId(51); room.setNetAmountPay(0.0);
		 * room.setContactDetail(null);
		 */

		// expResult.add(room);

		UserProfileDao userDao = new UserProfileDaoImpl();
		room = userDao.getBookingDetailsById(booking, true);
		System.out.println("%%$ room " + room);
		assertEquals(null, room);

	}

	@Test
	public void testGetBookingDetailsById2() {

		boolean cancel;
		String booking = "20";

		RoomBookingDetails room = new RoomBookingDetails();

		UserProfileDao userDao = new UserProfileDaoImpl();
		room = userDao.getBookingDetailsById(booking, true);
		System.out.println("%%$ room " + room);

		assertEquals("skumar", room.getUserName());
		assertEquals("2016-12-04", room.getFromDate());
		assertEquals(3, room.getNoOfAdults());
		assertEquals(825.0, room.getTaxAmount(), DELTA);
		assertEquals(5000.0, room.getBasicPrice(), DELTA);

	}

	@Test
	public void testUpdateBookingDetails() {

		boolean update;
		String booking = "20";

		RoomBookingDetails room = new RoomBookingDetails();

		room.setUserName("testUser");
		room.setFromDate("11/30/2016");
		room.setToDate("11/30/2016");
		room.setTotalPrice(2700.0);
		room.setRoomType("luxury");
		room.setNoOfRooms(1);
		room.setNoOfAdults(3);
		room.setTaxAmount(200.0);
		room.setBasicPrice(2500.0);
		room.setExtraGuestFee(500.0);
		room.setBookingId(51);
		room.setNetAmountPay(0.0);
		// room.setContactDetail(null);

		UserProfileDao userDao = new UserProfileDaoImpl();
		update = userDao.updateBookingDetails(room, true);
		System.out.println("%%$ update " + update);

		assertEquals(true, update);

		/*
		 * assertEquals("skumar", room.getUserName());
		 * assertEquals("2016-12-04", room.getFromDate()); assertEquals(3,
		 * room.getNoOfAdults()); assertEquals(825.0, room.getTaxAmount(),
		 * DELTA); assertEquals(5000.0, room.getBasicPrice(), DELTA);
		 */

	}

	@Test
	public void testUpdateBookingDetails2() {

		boolean update;
		// String booking = "20";

		RoomBookingDetails room = new RoomBookingDetails();

		room.setUserName("testUser");
		room.setFromDate("11/30/2016");
		room.setToDate("11/30/2016");
		room.setTotalPrice(2700.0);
		room.setRoomType("luxury");
		room.setNoOfRooms(1);
		room.setNoOfAdults(3);
		room.setTaxAmount(200.0);
		room.setBasicPrice(2500.0);
		room.setExtraGuestFee(500.0);
		room.setBookingId(21);
		room.setNetAmountPay(0.0);
		// room.setContactDetail(null);

		UserProfileDao userDao = new UserProfileDaoImpl();
		update = userDao.updateBookingDetails(room, true);
		System.out.println("%%$ update " + update);

		assertEquals(true, update);

	}

	@Test
	public void testgetOperatorProfile() {

		boolean update;
		String userName = "ksanju";

		OperatorProfile operator = new OperatorProfile();

		/*
		 * room.setUserName("testUser"); room.setFromDate("11/30/2016");
		 * room.setToDate("11/30/2016"); room.setTotalPrice(2700.0);
		 * room.setRoomType("luxury"); room.setNoOfRooms(1);
		 * room.setNoOfAdults(3); room.setTaxAmount(200.0);
		 * room.setBasicPrice(2500.0); room.setExtraGuestFee(500.0);
		 * room.setBookingId(21); room.setNetAmountPay(0.0);
		 */
		// room.setContactDetail(null);

		UserProfileDao userDao = new UserProfileDaoImpl();
		operator = userDao.getOperatorProfile(userName, true);
		System.out.println("%%$ operator " + operator.getOprFirstName());
		System.out.println("%%$ operator " + operator.getOprLastName());
		System.out.println("%%$ operator " + operator.getOprEmailId());

		assertEquals("sanju", operator.getOprFirstName());
		assertEquals("gowda", operator.getOprLastName());
		assertEquals("sanju@gmail.com", operator.getOprEmailId());
		// assertEquals("sanju", operator.getOprFirstName());

	}

	@Test
	public void testsearchRoomForEntry() {

		boolean update;
		String roomtype = "luxury";
		int noOfRoom = 3;

		// OperatorProfile operator = new OperatorProfile();

		/*
		 * room.setUserName("testUser"); room.setFromDate("11/30/2016");
		 * room.setToDate("11/30/2016"); room.setTotalPrice(2700.0);
		 * room.setRoomType("luxury"); room.setNoOfRooms(1);
		 * room.setNoOfAdults(3); room.setTaxAmount(200.0);
		 * room.setBasicPrice(2500.0); room.setExtraGuestFee(500.0);
		 * room.setBookingId(21); room.setNetAmountPay(0.0);
		 */
		// room.setContactDetail(null);

		List<String> roomAva = new ArrayList<>();

		UserProfileDao userDao = new UserProfileDaoImpl();
		roomAva = userDao.searchRoomForEntry(roomtype, noOfRoom, true);
		System.out.println("%%$ roomAva " + roomAva);

		List<String> roomAvaExp = new ArrayList<>();
		// roomAvaExp.add("201");
		roomAvaExp.add("202");
		roomAvaExp.add("203");
		roomAvaExp.add("204");
		roomAvaExp.add("205");

		assertEquals(roomAvaExp, roomAva);

	}

	@Test
	public void testsearchRoomForEntry2() {

		boolean update;
		String roomtype = "luxuryyy";
		int noOfRoom = 3;

		// OperatorProfile operator = new OperatorProfile();

		/*
		 * room.setUserName("testUser"); room.setFromDate("11/30/2016");
		 * room.setToDate("11/30/2016"); room.setTotalPrice(2700.0);
		 * room.setRoomType("luxury"); room.setNoOfRooms(1);
		 * room.setNoOfAdults(3); room.setTaxAmount(200.0);
		 * room.setBasicPrice(2500.0); room.setExtraGuestFee(500.0);
		 * room.setBookingId(21); room.setNetAmountPay(0.0);
		 */
		// room.setContactDetail(null);

		List<String> roomAva = new ArrayList<>();

		UserProfileDao userDao = new UserProfileDaoImpl();
		roomAva = userDao.searchRoomForEntry(roomtype, noOfRoom, true);
		System.out.println("%%$ roomAva " + roomAva);

		List<String> roomAvaExp = new ArrayList<>();
		/*
		 * roomAvaExp.add("201"); roomAvaExp.add("202"); roomAvaExp.add("203");
		 * roomAvaExp.add("204"); roomAvaExp.add("205");
		 */

		assertEquals(roomAvaExp, roomAva);

	}

	@Test
	public void testsaveRoomEntryDetails() {

		boolean save;
		String oprUserName = "ksanju";
		String fromDateStr = "11/30/2016";
		String toDateStr = "11/30/2016";
		String[] roomNumberChecked = new String[10];
		roomNumberChecked[0] = "201";
		roomNumberChecked[1] = "202";
		String bookId = "11";

		RoomEntryDetails roomEntry = new RoomEntryDetails();

		roomEntry.setOprUserName("testUser");
		roomEntry.setFromDate("11/30/2016");
		roomEntry.setToDate("11/30/2016");
		roomEntry.setRoomNumberChecked(roomNumberChecked);
		roomEntry.setBookId(bookId);

		List<String> roomAva = new ArrayList<>();

		UserProfileDao userDao = new UserProfileDaoImpl();
		save = userDao.saveRoomEntryDetails(roomEntry, true);
		System.out.println("%%$ save " + save);
		assertEquals(true, save);

	}

	@Test
	public void testsaveRoomEntryDetails2() {

		boolean save;
		String oprUserName = "ksanjuuu";
		String fromDateStr = "11/30/2016";
		String toDateStr = "11/30/2016";
		String[] roomNumberChecked = new String[10];
		roomNumberChecked[0] = "201";
		roomNumberChecked[1] = "202";
		String bookId = "11";

		RoomEntryDetails roomEntry = new RoomEntryDetails();

		roomEntry.setOprUserName("testUser");
		roomEntry.setFromDate("11/30/2016");
		roomEntry.setToDate("11/30/2016");
		roomEntry.setRoomNumberChecked(roomNumberChecked);
		roomEntry.setBookId(bookId);

		List<String> roomAva = new ArrayList<>();

		UserProfileDao userDao = new UserProfileDaoImpl();
		save = userDao.saveRoomEntryDetails(roomEntry, true);
		System.out.println("%%$ save " + save);
		assertEquals(false, save);

	}

}
