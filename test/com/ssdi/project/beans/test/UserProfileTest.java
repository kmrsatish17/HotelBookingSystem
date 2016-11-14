package com.ssdi.project.beans.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ssdi.project.beans.UserLoginProfile;
import com.ssdi.project.beans.UserProfile;

public class UserProfileTest {
	
	
	private UserProfile userProfile;

	public UserProfileTest() {
    }

	@BeforeClass
	public static void setUpClass() {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() throws Exception {
		userProfile = new UserProfile();
		userProfile.setEmailId("sat@gmail.com");;
		userProfile.setPassword("satish123");
		userProfile.setUserName("ksatish");
		userProfile.setFirstName("satish");
		userProfile.setLastName("kumar");

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
		String result = userProfile.getEmailId();
		assertEquals(expResult, result);
	}

	/**
	 * Test of GetToDate method, of class roomSearchDetail.
	 */
	@Test
	public void testGetPassword() {
		System.out.println("GetToDate");
		String expResult = "satish123";
		String result = userProfile.getPassword();
		assertEquals(expResult, result);
	}
	
	@Test
	public void testGetUserName() throws Exception {
		String expResult = "ksatish";
		String result = userProfile.getUserName();
		assertEquals(expResult, result);
	}
	
	@Test
	public void testGetFirstName() throws Exception {
		String expResult = "satish";
		String result = userProfile.getFirstName();
		assertEquals(expResult, result);
	}
	
	@Test
	public void testGetLastName() throws Exception {
		String expResult = "kumar";
		String result = userProfile.getLastName();
		assertEquals(expResult, result);
	}


	
	

}
