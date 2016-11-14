package com.ssdi.project.beans.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ssdi.project.beans.RoomSearchDetail;
import com.ssdi.project.beans.UserLoginProfile;

public class UserLoginProfileTest {

	private UserLoginProfile userLoginProfile;

	public UserLoginProfileTest() {
    }

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() throws Exception {
		userLoginProfile = new UserLoginProfile();
		userLoginProfile.setEmailId("sat@gmail.com");;
		userLoginProfile.setPassword("satish123");

	}

	@After
	public void tearDown() {
	}

	/**
	 * Test of GetFromDate method, of class roomSearchDetail.
	 */

	@Test
	public void testGetEmailId() throws Exception {
		String expResult = "sat@gmail.com";
		String result = userLoginProfile.getEmailId();
		assertEquals(expResult, result);
	}

	/**
	 * Test of GetToDate method, of class roomSearchDetail.
	 */
	@Test
	public void testGetPassword() {
		System.out.println("GetToDate");
		String expResult = "satish123";
		String result = userLoginProfile.getPassword();
		assertEquals(expResult, result);
	}

}
