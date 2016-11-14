package com.ssdi.project.beans.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ssdi.project.beans.RoomBookingDetails;
import com.ssdi.project.beans.RoomSearchDetail;

public class RoomBookingDetailsTest {
	

    private RoomBookingDetails roomBookingDetails;
    
    
    public RoomBookingDetailsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
    	roomBookingDetails = new RoomBookingDetails();
    	roomBookingDetails.setFromDate("2016-11-02");
    	roomBookingDetails.setToDate("2016-11-04");
    	roomBookingDetails.setRoomType("luxury");
    	roomBookingDetails.setNoOfRooms(2);
    	roomBookingDetails.setTotalPrice(2200);
    	roomBookingDetails.setTaxAmount(200);
    	roomBookingDetails.setBasicPrice(2000);
    	
	
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
        String result = roomBookingDetails.getFromDate();
        assertEquals(expResult, result);
    }
 

    /**
     * Test of GetToDate method, of class roomSearchDetail.
     */
    @Test
    public void testGetToDate() {
        System.out.println("GetToDate");
        String expResult="2016-11-04";
        String result = roomBookingDetails.getToDate();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoomType method, of class roomSearchDetail.
     */
    @Test
    public void testGetRoomType() {
        System.out.println("getRoomType");
        String expResult = "luxury";
        String result = roomBookingDetails.getRoomType();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPricePerDay method, of class roomSearchDetail.
     */
    @Test
    public void testGetTotalPrice() {
        System.out.println("GetTotalPrice");
        double expResult = 2200;
        double result = roomBookingDetails.getTotalPrice();
        assertEquals(expResult, result, 0.001);
    }

    /**
     * Test of getNoOfRooms method, of class roomSearchDetail.
     */
    @Test
    public void testGetBasicPrice() {
        System.out.println("GetBasicPrice");
        double expResult = 2000;
        double result = roomBookingDetails.getBasicPrice();
        assertEquals(expResult, result, 0.001);
    }
    
    @Test
    public void testGetTaxAmount() {
        System.out.println("GetTaxAmount");
        double expResult = 200;
        double result = roomBookingDetails.getTaxAmount();
        assertEquals(expResult, result, 0.001);
        //assertEquals(expected, actual, delta);
    }



}
