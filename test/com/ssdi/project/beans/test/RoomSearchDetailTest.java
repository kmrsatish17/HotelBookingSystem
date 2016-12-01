package com.ssdi.project.beans.test;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ssdi.project.beans.RoomSearchDetail;

import static org.junit.Assert.*;


public class RoomSearchDetailTest {
    private RoomSearchDetail roomSearchDetail;
    
    
    public RoomSearchDetailTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
    	roomSearchDetail = new RoomSearchDetail();
    	roomSearchDetail.setFromDate("2016-11-02");
    	roomSearchDetail.setToDate("2016-11-04");
    	roomSearchDetail.setRoomType("luxury");
    	roomSearchDetail.setPricePerDay(2500);
    	roomSearchDetail.setNoOfRooms(2);
	
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of GetFromDate method, of class roomSearchDetail.
     */
    
      @Test
    public void testGetFromDate() throws Exception {
        System.out.println("GetFromDate");
        String expResult = "2016-11-02";
        String result = roomSearchDetail.getFromDate();
        assertEquals(expResult, result);
    }
 

    /**
     * Test of GetToDate method, of class roomSearchDetail.
     */
    @Test
    public void testGetToDate() {
        System.out.println("GetToDate");
        String expResult="2016-11-04";
        String result = roomSearchDetail.getToDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoomType method, of class roomSearchDetail.
     */
    @Test
    public void testGetRoomType() {
        System.out.println("getRoomType");
        String expResult = "luxury";
        String result = roomSearchDetail.getRoomType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPricePerDay method, of class roomSearchDetail.
     */
    @Test
    public void testGetPricePerDay() {
        System.out.println("getPricePerDay");
        double expResult = 2500;
        double result = roomSearchDetail.getPricePerDay();
        assertEquals(expResult, result);
    }

    /**
     * Test of getNoOfRooms method, of class roomSearchDetail.
     */
    @Test
    public void testGetNoOfRooms() {
        System.out.println("getNoOfRooms");
        int expResult = 2;
        int result = roomSearchDetail.getNoOfRooms();
        assertEquals(expResult, result);
    }

}

