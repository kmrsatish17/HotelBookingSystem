package com.ssdi.project.beans.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ssdi.project.beans.RoomEntryDetails;
import com.ssdi.project.beans.UserContactDetail;

public class RoomEntryDetailsTest {
	
	

	
	private RoomEntryDetails roomEntryDetails;

	public RoomEntryDetailsTest() {
    }

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() throws Exception {
		

	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of GetFromDate method, of class roomSearchDetail.
	 */

	@Test
	public void test1() throws Exception {
		
		roomEntryDetails = new RoomEntryDetails();
		
		roomEntryDetails.setBookId("11");
		roomEntryDetails.setFirstName("satish");
		roomEntryDetails.setFromDate("2016-11-02");
		roomEntryDetails.setLastName("kmr");
		roomEntryDetails.setNoOfRooms(2);
		roomEntryDetails.setOprUserName("ksanju");
		roomEntryDetails.setRoomNumber("101");
        roomEntryDetails.setRoomType("luxury");
        roomEntryDetails.setToDate("2016-11-04");
        
		
		assertEquals("11", roomEntryDetails.getBookId());
		assertEquals("satish", roomEntryDetails.getFirstName());
		assertEquals("2016-11-02", roomEntryDetails.getFromDate());
		assertEquals("kmr", roomEntryDetails.getLastName());
		assertEquals(2, roomEntryDetails.getNoOfRooms());
		assertEquals("ksanju", roomEntryDetails.getOprUserName());
		assertEquals("101", roomEntryDetails.getRoomNumber());
		assertEquals("luxury", roomEntryDetails.getRoomType());
		assertEquals("2016-11-04",  roomEntryDetails.getToDate());
	}
	
	



}
