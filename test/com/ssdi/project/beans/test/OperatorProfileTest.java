package com.ssdi.project.beans.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ssdi.project.beans.OperatorProfile;
import com.ssdi.project.beans.UserLoginProfile;

public class OperatorProfileTest {
	
	private OperatorProfile operatorProfile;

	public OperatorProfileTest() {
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
		
		operatorProfile = new OperatorProfile();
		operatorProfile.setOprEmailId("sanju@gmail.com");
		operatorProfile.setOprFirstName("sanju");
		operatorProfile.setOprLastName("kumar");
		operatorProfile.setOprPassword("sanju111");
		operatorProfile.setOprUserName("ksanju");
		
		
		assertEquals("sanju@gmail.com", operatorProfile.getOprEmailId());
		assertEquals("sanju", operatorProfile.getOprFirstName());
		assertEquals("kumar", operatorProfile.getOprLastName());
		assertEquals("sanju111", operatorProfile.getOprPassword());
		assertEquals("ksanju", operatorProfile.getOprUserName());
	}
	
	@Test
	public void test2() throws Exception {
		
		operatorProfile = new OperatorProfile();
		operatorProfile.setOprEmailId("san@gmail.com");
		operatorProfile.setOprFirstName("san");
		operatorProfile.setOprLastName("gauda");
		operatorProfile.setOprPassword("sanju123");
		operatorProfile.setOprUserName("kmrsanju");
		
		
		assertEquals("san@gmail.com", operatorProfile.getOprEmailId());
		assertEquals("san", operatorProfile.getOprFirstName());
		assertEquals("gauda", operatorProfile.getOprLastName());
		assertEquals("sanju123", operatorProfile.getOprPassword());
		assertEquals("kmrsanju", operatorProfile.getOprUserName());
	}

}
