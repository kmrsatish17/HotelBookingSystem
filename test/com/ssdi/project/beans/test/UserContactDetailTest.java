package com.ssdi.project.beans.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ssdi.project.beans.OperatorProfile;
import com.ssdi.project.beans.UserContactDetail;

public class UserContactDetailTest {
	
	private UserContactDetail userContactDetail;

	public UserContactDetailTest() {
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
		
		userContactDetail = new UserContactDetail();
		userContactDetail.setAddress1("barton");
		userContactDetail.setAddress2("creek");
		userContactDetail.setCity("charlotte");
		userContactDetail.setState("NC");
		userContactDetail.setCountry("USA");
		userContactDetail.setFirstname("satish");
		userContactDetail.setLastname("kumar");
		userContactDetail.setPhoneNumber("1234567890");
		userContactDetail.setUsername("ksatish");
		userContactDetail.setZip("28262");

		assertEquals("barton", userContactDetail.getAddress1());
		assertEquals("creek", userContactDetail.getAddress2());
		assertEquals("charlotte", userContactDetail.getCity());
		assertEquals("NC", userContactDetail.getState());
		assertEquals("USA", userContactDetail.getCountry());
		assertEquals("satish", userContactDetail.getFirstname());
		assertEquals("kumar", userContactDetail.getLastname());
		assertEquals("1234567890", userContactDetail.getPhoneNumber());
		assertEquals("ksatish", userContactDetail.getUsername());
		assertEquals("28262", userContactDetail.getZip());
	}
	
	@Test
	public void test2() throws Exception {
		
		userContactDetail = new UserContactDetail();
		userContactDetail.setAddress1("bart");
		userContactDetail.setAddress2("creek drive");
		userContactDetail.setCity("bangalore");
		userContactDetail.setState("KA");
		userContactDetail.setCountry("India");
		userContactDetail.setFirstname("sanju");
		userContactDetail.setLastname("kumar");
		userContactDetail.setPhoneNumber("1234567890");
		userContactDetail.setUsername("ksatish");
		userContactDetail.setZip("28262");

		assertEquals("bart", userContactDetail.getAddress1());
		assertEquals("creek drive", userContactDetail.getAddress2());
		assertEquals("bangalore", userContactDetail.getCity());
		assertEquals("KA", userContactDetail.getState());
		assertEquals("India", userContactDetail.getCountry());
		assertEquals("sanju", userContactDetail.getFirstname());
		assertEquals("kumar", userContactDetail.getLastname());
		assertEquals("1234567890", userContactDetail.getPhoneNumber());
		assertEquals("ksatish", userContactDetail.getUsername());
		assertEquals("28262", userContactDetail.getZip());
	}

}
