package com.ssdi.project.access.db.test;

import static org.junit.Assert.*;

import java.sql.*;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        UserProfile user = null;
        int expResult = 0;
        UserProfileDao userDao = new UserProfileDaoImpl();
        int result = userDao.insertProfile(user);
        assertEquals(expResult, result);
    }

    
    @Test
    public void testSearchForRoom() {
        Date fromDate = null; 
        Date toDate = null;
        UserProfileDao userDao = new UserProfileDaoImpl();
        List<RoomSearchDetail>  expResult = null;
        List<RoomSearchDetail>  result = userDao.searchForRoom(fromDate, toDate);
        assertEquals(expResult, result);
    }

    
    @Test
    public void testGetUserProfile() {
        String username = "";
        UserProfile userProfileExp = new UserProfile();
        UserProfileDao userDao = new UserProfileDaoImpl();
        UserProfile result = userDao.getUserProfile(username);
        assertEquals(userProfileExp, result);
    }

    
    @Test
    public void testGetPaymentValidity() {
    	
    	int cardNumberInt = 0;
    	String cardName = "";
    	int cvvNumberInt = 0;
    	
    	boolean flag = false;

    	UserProfileDao userDao = new UserProfileDaoImpl();
        boolean result = userDao.getPaymentValidity(cardNumberInt, cardName, cvvNumberInt);
        assertEquals(flag, result);
    }
    
    
    @Test
    public void testSaveBookingDetails() {
    	
    	RoomBookingDetails roomBookingDetails = new RoomBookingDetails();
    	
    	boolean flag = false;

    	UserProfileDao userDao = new UserProfileDaoImpl();
        userDao.saveBookingDetails(roomBookingDetails);
        //assertEquals(flag, result);
    }
    
    
    @Test
    public void testUpdateRoomAvailable() {
    	
    	RoomBookingDetails roomBookingDetails = new RoomBookingDetails();
    	
    	boolean flag = false;

    	UserProfileDao userDao = new UserProfileDaoImpl();
        userDao.updateRoomAvailable(roomBookingDetails);
        //assertEquals(flag, result);
    }
    
	
	
	
}
