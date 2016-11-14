package com.ssdi.project.controller.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ssdi.project.controller.UserLoginServlet;
import com.ssdi.project.controller.UserPaymentServlet;

public class UserPaymentServletTest {
	


	public UserPaymentServletTest() {
	    }

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

	/**
	 * Test of doGet method, of class HomeServlet.
	 */
	@Test
	public void testDoGet() throws Exception {
		System.out.println("doGet");
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		UserPaymentServlet instance = new UserPaymentServlet();
		instance.doGet(request, response);
	}

	/**
	 * Test of doPost method, of class HomeServlet.
	 */
	@Test
	public void testDoPost() throws Exception {
		System.out.println("doPost");
		HttpServletRequest request = null;
		HttpServletResponse response = null;
		UserPaymentServlet instance = new UserPaymentServlet();
		instance.doPost(request, response);
	}



}
