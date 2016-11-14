package com.ssdi.project.beans.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ssdi.project.beans.RoomSearchDetail;
import com.ssdi.project.beans.RoomSearchSelectDetails;

public class RoomSearchSelectDetailsTest {
	

    private RoomSearchSelectDetails roomSearchSelectDetails;
    
    
    public RoomSearchSelectDetailsTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() throws Exception{
    	roomSearchSelectDetails = new RoomSearchSelectDetails();
    	roomSearchSelectDetails.setFromDateSelected("2016-11-02");
    	roomSearchSelectDetails.setToDateSelected("2016-11-04");
    	List<String> roomType = new ArrayList<String>();
    	roomType.add("luxury");
    	roomSearchSelectDetails.setRoomTypeAvailable(roomType);
    	roomSearchSelectDetails.setNoOfRoomSelected("2");
	
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of GetFromDate method, of class roomSearchDetail.
     */
    
      @Test
    public void testGetFromDateSelected() throws Exception {
        System.out.println("GetFromDateSelected");
        String expResult = "2016-11-02";
        String result = roomSearchSelectDetails.getFromDateSelected();
        assertEquals(expResult, result);
    }
 

    /**
     * Test of GetToDate method, of class roomSearchDetail.
     */
    @Test
    public void testGetToDateSelected() {
        System.out.println("GetToDateSelected");
        String expResult="2016-11-04";
        String result = roomSearchSelectDetails.getToDateSelected();
        assertEquals(expResult, result);
    }

    /**
     * Test of getRoomType method, of class roomSearchDetail.
     */
    @Test
    public void testGetRoomTypeAvailable() {
        System.out.println("getRoomType");
        List<String> roomTypeExp = new ArrayList<String>();
        roomTypeExp.add("luxury");
        List<String> result = roomSearchSelectDetails.getRoomTypeAvailable();
        assertEquals(roomTypeExp, result);
    }

    /**
     * Test of getPricePerDay method, of class roomSearchDetail.
     */
    @Test
    public void testGetNoOfRoomSelected() {
        String expResult = "2";
        String result = roomSearchSelectDetails.getNoOfRoomSelected();
        assertEquals(expResult, result);
    }


}
