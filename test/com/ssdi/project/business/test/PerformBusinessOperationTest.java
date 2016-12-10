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
		
		basicPrice = business.calculateBasePrice(fromDateStr, toDateStr, noOfRoomSelected, roomTypeName, basicPrice);
		
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
		
		basicPrice = business.calculateBasePrice(fromDateStr, toDateStr, noOfRoomSelected, roomTypeName, basicPrice);
		
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
		
		basicPrice = business.calculateBasePrice(fromDateStr, toDateStr, noOfRoomSelected, roomTypeName, basicPrice);
		
		System.out.println("### basicPrice " + basicPrice);
		assertEquals(3000.0, basicPrice, DELTA);

	}
	
	
	
	@Test
	public void testCalculateBreakfastCharge() {
		
		
		double resultPrice = 0;
		
		String fromDateStr = "11/30/2016";
		String toDateStr = "11/30/2016";
		String breakfastChecked = "breakfast" ; 
		
		PerformBusinessOperation business = new PerformBusinessOperation();
		
		resultPrice = business.calculateBreakfastCharge(fromDateStr, toDateStr, breakfastChecked);
		
		System.out.println("### resultPrice " + resultPrice);
		assertEquals(100.0, resultPrice, DELTA);

	}
	
	@Test
	public void testCalculateBreakfastCharge2() {
		
		
		double resultPrice = 0;
		
		String fromDateStr = "11/30/2016";
		String toDateStr = "12/02/2016";
		String breakfastChecked = "breakfast" ; 
		
		PerformBusinessOperation business = new PerformBusinessOperation();
		
		resultPrice = business.calculateBreakfastCharge(fromDateStr, toDateStr, breakfastChecked);
		
		System.out.println("### resultPrice " + resultPrice);
		assertEquals(300.0, resultPrice, DELTA);

	}
	
	@Test
	public void testCalculateBreakfastCharge3() {
		
		
		double resultPrice = 0;
		
		String fromDateStr = "11/30/2016";
		String toDateStr = "12/02/2016";
		String breakfastChecked = "" ; 
		
		PerformBusinessOperation business = new PerformBusinessOperation();
		
		resultPrice = business.calculateBreakfastCharge(fromDateStr, toDateStr, breakfastChecked);
		
		System.out.println("### resultPrice " + resultPrice);
		assertEquals(0.0, resultPrice, DELTA);

	}
	
	@Test
	public void testCalculateCabeCharge() {
		
		
		double resultPrice = 0;
		
		String fromDateStr = "11/30/2016";
		String toDateStr = "12/02/2016";
		String cabeChecked = "cabe" ; 
		
		PerformBusinessOperation business = new PerformBusinessOperation();
		
		resultPrice = business.calculateCabeCharge(fromDateStr, toDateStr, cabeChecked);
		
		System.out.println("### resultPrice " + resultPrice);
		assertEquals(3000.0, resultPrice, DELTA);

	}
	
	@Test
	public void testCalculateCabeCharge2() {
		
		
		double resultPrice = 0;
		
		String fromDateStr = "11/30/2016";
		String toDateStr = "12/02/2016";
		String cabeChecked = "" ; 
		
		PerformBusinessOperation business = new PerformBusinessOperation();
		
		resultPrice = business.calculateCabeCharge(fromDateStr, toDateStr, cabeChecked);
		
		System.out.println("### resultPrice " + resultPrice);
		assertEquals(0.0, resultPrice, DELTA);

	}
	
	@Test
	public void testCalculateParkingCharge() {
		
		
		double resultPrice = 0;
		
		String fromDateStr = "11/30/2016";
		String toDateStr = "12/02/2016";
		String parkChecked = "parking" ; 
		
		PerformBusinessOperation business = new PerformBusinessOperation();
		
		resultPrice = business.calculateParkingCharge(fromDateStr, toDateStr, parkChecked);
		
		System.out.println("### resultPrice " + resultPrice);
		assertEquals(900.0, resultPrice, DELTA);

	}
	
	@Test
	public void testCalculateParkingCharge2() {
		
		
		double resultPrice = 0;
		
		String fromDateStr = "11/30/2016";
		String toDateStr = "12/02/2016";
		String parkChecked = "" ; 
		
		PerformBusinessOperation business = new PerformBusinessOperation();
		
		resultPrice = business.calculateParkingCharge(fromDateStr, toDateStr, parkChecked);
		
		System.out.println("### resultPrice " + resultPrice);
		assertEquals(0.0, resultPrice, DELTA);

	}
	
	
	@Test
	public void testGetNumberOfDays() {
		
		
		long result = 0;
		
		String fromDateStr = "11/30/2016";
		String toDateStr = "12/02/2016";
		String parkChecked = "" ; 
		
		PerformBusinessOperation business = new PerformBusinessOperation();
		
		result = business.getNumberOfDays(fromDateStr, toDateStr);
		
		System.out.println("### result " + result);
		assertEquals(3, result, DELTA);

	}
	
	@Test
	public void testGetNumberOfDays2() {
		
		
		long result = 0;
		
		String fromDateStr = "12/03/2016";
		String toDateStr = "12/02/2016";
		String parkChecked = "" ; 
		
		PerformBusinessOperation business = new PerformBusinessOperation();
		
		result = business.getNumberOfDays(fromDateStr, toDateStr);
		
		System.out.println("### result " + result);
		assertEquals(0, result, DELTA);

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
