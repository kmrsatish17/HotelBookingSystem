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
import com.ssdi.project.beans.RoomBookingDetails;
import com.ssdi.project.beans.RoomSearchDetail;
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
        System.out.println("insert");
        UserProfile user = new UserProfile();
        
        /*user.setFirstName("satish");
        user.setLastName("kumar");
        user.setUserName("skumar");
        user.setPassword("kumar123");
        user.setEmailId("sat@gmail.com");*/
        
        user.setFirstName("ramesh");
        user.setLastName("kumar");
        user.setUserName("rkumar");
        user.setPassword("kumar123");
        user.setEmailId("ramesh@gmail.com");
        
        int expResult = 0;
        UserProfileDao userDao = new UserProfileDaoImpl();
        int result = userDao.insertProfile(user);
        System.out.println("### result " + result);
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
        List<RoomSearchDetail>  expResult = new ArrayList<RoomSearchDetail>();
        List<RoomSearchDetail>  result = userDao.searchForRoom(fromDate, toDate);
        System.out.println("$$$$ result..toString() " + result.toString());
        System.out.println("$$$$ result " + result);
        
        for (RoomSearchDetail detail: result){
        	
        	System.out.println("$$$$## detail " + detail.toString());
        }
        
        RoomSearchDetail searchDetail1 = new RoomSearchDetail();
        searchDetail1.setRoomType("deluxe");
        searchDetail1.setPricePerDay(2000);
        searchDetail1.setNoOfRooms(8);
        searchDetail1.setFromDate(null);
        searchDetail1.setToDate(null);
        
        /*RoomSearchDetail searchDetail2 = new RoomSearchDetail();
        searchDetail2.setRoomType("super deluxe");
        searchDetail2.setPricePerDay(3000);
        searchDetail2.setNoOfRooms(15);
        searchDetail2.setFromDate(null);
        searchDetail2.setToDate(null);
        
        RoomSearchDetail searchDetail3 = new RoomSearchDetail();
        searchDetail3.setRoomType("luxury");
        searchDetail3.setPricePerDay(2500);
        searchDetail3.setNoOfRooms(6);
        searchDetail3.setFromDate(null);
        searchDetail3.setToDate(null);*/
        
        expResult.add(searchDetail1);
        /*expResult.add(searchDetail3);
        expResult.add(searchDetail2);*/        
        //assertEquals(expResult, result);
        
        for (RoomSearchDetail detail: result){
        	
        	//System.out.println("$$$$## detail " + detail.toString());
        	assertEquals("deluxe", detail.getRoomType());
        	assertEquals(2000, detail.getPricePerDay());
        	assertEquals(8, detail.getNoOfRooms());
        }
    }

    
    @Test
    public void testGetUserProfile() {
        String username = "skumar";
        UserProfile userProfileExp = new UserProfile();
        UserProfileDao userDao = new UserProfileDaoImpl();
        UserProfile result = userDao.getUserProfile(username);
        assertEquals("skumar", result.getUserName());
        assertEquals("satish", result.getFirstName());
        assertEquals("kumar", result.getLastName());
        assertEquals("sat@gmail.com", result.getEmailId());
        assertEquals("kumar123", result.getPassword());
        //assertEquals(userProfileExp, result);
    }

    
    @Test
    public void testGetPaymentValidity() {
    	
    	int cardNumberInt = 12345;
    	String cardName = "satish";
    	int cvvNumberInt = 123;
    	
    	boolean flag = false;

    	UserProfileDao userDao = new UserProfileDaoImpl();
        boolean result = userDao.getPaymentValidity(cardNumberInt, cardName, cvvNumberInt);
       assertEquals(true, result);
    }
    
    @Test
    public void testGetPaymentValidity2() {
    	
    	int cardNumberInt = 123456;
    	String cardName = "satish";
    	int cvvNumberInt = 123;
    	
    	boolean flag = false;

    	UserProfileDao userDao = new UserProfileDaoImpl();
        boolean result = userDao.getPaymentValidity(cardNumberInt, cardName, cvvNumberInt);
       assertEquals(false, result);
    }
    
    
    @Test
    public void testSaveBookingDetails() {
    	
    	RoomBookingDetails roomBookingDetails = new RoomBookingDetails();
    	roomBookingDetails.setFromDate("11/30/2016");
    	roomBookingDetails.setToDate("12/02/2016");
    	roomBookingDetails.setRoomType("deluxe");
    	roomBookingDetails.setNoOfRooms(2);
    	roomBookingDetails.setBasicPrice(2000);
    	roomBookingDetails.setTaxAmount(750);
    	roomBookingDetails.setTotalPrice(7700);
    	
    	boolean flag = false;

    	UserProfileDao userDao = new UserProfileDaoImpl();
        int result = userDao.saveBookingDetails(roomBookingDetails);
        assertEquals(1, result);
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
        boolean result = userDao.updateRoomAvailable(roomBookingDetails);
        assertEquals(true, result);
    }
    
}
