package com.ssdi.project.controller.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ssdi.project.access.db.test.UserProfileDaoImplTest;
import com.ssdi.project.beans.UserProfile;
import com.ssdi.project.controller.SubmitBookingDetail;
import com.ssdi.project.controller.UserLoginServlet;

public class UserLoginServletTest {

	public UserLoginServletTest() {
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
		UserLoginServlet instance = new UserLoginServlet();
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
		UserLoginServlet instance = new UserLoginServlet();
		instance.doPost(request, response);
	}

}
