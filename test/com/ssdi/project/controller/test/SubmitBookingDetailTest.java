package com.ssdi.project.controller.test;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.ssdi.project.controller.BookRoomServlet;
import com.ssdi.project.controller.SubmitBookingDetail;

public class SubmitBookingDetailTest {
	

	
	  public SubmitBookingDetailTest() {
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
	        SubmitBookingDetail instance = new SubmitBookingDetail();
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
	        SubmitBookingDetail instance = new SubmitBookingDetail();
	        instance.doPost(request, response);
	    } 



}
