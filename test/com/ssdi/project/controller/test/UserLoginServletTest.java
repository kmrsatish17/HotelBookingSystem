package com.ssdi.project.controller.test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
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
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ssdi.project.access.db.UserProfileDao;
import com.ssdi.project.access.db.test.UserProfileDaoImplTest;
import com.ssdi.project.beans.UserProfile;
import com.ssdi.project.controller.SubmitBookingDetail;
import com.ssdi.project.controller.UserLoginServlet;
import com.ssdi.project.controller.UserSearchServlet;

import junit.framework.TestCase;

public class UserLoginServletTest extends TestCase {

	@Mock
	HttpServletRequest request;
	@Mock
	HttpServletResponse response;
	@Mock
	HttpSession session;

	@Mock
	RequestDispatcher rd;

	@Before
	protected void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void test() throws Exception {

		HttpServletRequest request = mock(HttpServletRequest.class);
		HttpServletResponse response = mock(HttpServletResponse.class);
		HttpSession session = mock(HttpSession.class);
		RequestDispatcher rd = mock(RequestDispatcher.class);

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		when(request.getParameter("userName")).thenReturn("skumar");
		when(request.getParameter("password")).thenReturn("kumar123");
		when(request.getSession()).thenReturn(session);
		when(request.getRequestDispatcher("/contactDetails.jsp")).thenReturn(rd);

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);

		new UserLoginServlet().doPost(request, response);

		UserProfileDao userDaoTest = mock(UserProfileDao.class);

		Date fromDate = null;
		Date toDate = null;

		// SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		try {

			fromDate = (Date) formatter.parse("11/30/2016");
			toDate = (Date) formatter.parse("11/30/2016");

		} catch (ParseException e) {
			e.printStackTrace();
		}

		when(userDaoTest.getUserProfile("ksatish", true)).thenReturn(null);
		assertEquals(null, userDaoTest.getUserProfile("ksatish", true));

		/*
		 * when(userDaoTest.getRoomPricePerDay("deluxe",
		 * true)).thenReturn(2000.0);
		 * assertEquals(2000.0,userDaoTest.getRoomPricePerDay("deluxe", true));
		 */

		verify(rd).forward(request, response);
	}

}
