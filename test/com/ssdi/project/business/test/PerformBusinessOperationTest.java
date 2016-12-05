package com.ssdi.project.business.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ssdi.project.business.PerformBusinessOperation;

public class PerformBusinessOperationTest {

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
	
	private static final double DELTA = 1e-15;

	@Test
	public void testCalculateBasePrice() {
		
		String fromDateStr = "11/30/2016";
		String toDateStr = "11/30/2016";
		int noOfRoomSelected = 1;
		String roomTypeName = "deluxe";
		double basicPrice = 0;
		
		PerformBusinessOperation business = new PerformBusinessOperation();
		
		//basicPrice = business.calculateBasePrice(fromDateStr, toDateStr, noOfRoomSelected, roomTypeName, basicPrice);
		
		System.out.println("### basicPrice " + basicPrice);
		assertEquals(2000.0, basicPrice, DELTA);

	}
	
	
	@Test
	public void testCalculateBasePrice2() {
		
		String fromDateStr = "11/30/2016";
		String toDateStr = "11/30/2016";
		int noOfRoomSelected = 1;
		String roomTypeName = "luxury";
		double basicPrice = 0;
		
		PerformBusinessOperation business = new PerformBusinessOperation();
		
		//basicPrice = business.calculateBasePrice(fromDateStr, toDateStr, noOfRoomSelected, roomTypeName, basicPrice);
		
		System.out.println("### basicPrice " + basicPrice);
		assertEquals(2500.0, basicPrice, DELTA);

	}
	
	@Test
	public void testCalculateBasePrice3() {
		
		String fromDateStr = "11/30/2016";
		String toDateStr = "11/30/2016";
		int noOfRoomSelected = 1;
		String roomTypeName = "super deluxe";
		double basicPrice = 0;
		
		PerformBusinessOperation business = new PerformBusinessOperation();
		
		//basicPrice = business.calculateBasePrice(fromDateStr, toDateStr, noOfRoomSelected, roomTypeName, basicPrice);
		
		System.out.println("### basicPrice " + basicPrice);
		assertEquals(3000.0, basicPrice, DELTA);

	}
	
	
	
	
	@Test
	public void testcalculateExtraFee() {
		
		int noOfRoomInt = 2;
		int noOfAdultsInt = 5;
		double extraPrice = 0;
		
		PerformBusinessOperation business = new PerformBusinessOperation();
		
		extraPrice = business.calculateExtraFee(noOfRoomInt, noOfAdultsInt);
		
		System.out.println("### extraPrice " + extraPrice);
		assertEquals(500.0, extraPrice, DELTA);

	}
	
	@Test
	public void testcalculateExtraFee2() {
		
		int noOfRoomInt = 2;
		int noOfAdultsInt = 6;
		double extraPrice = 0;
		
		PerformBusinessOperation business = new PerformBusinessOperation();
		
		extraPrice = business.calculateExtraFee(noOfRoomInt, noOfAdultsInt);
		
		System.out.println("### extraPrice " + extraPrice);
		assertEquals(1000.0, extraPrice, DELTA);

	}
	
}
