package com.ssdi.project.controller.test;

import javax.servlet.RequestDispatcher;
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
import com.ssdi.project.controller.BookRoomServlet;
import com.ssdi.project.controller.UserSearchServlet;

import com.ssdi.project.beans.RoomSearchSelectDetails;
import junit.framework.TestCase;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.ssdi.project.beans.RoomSearchSelectDetails;

public class BookRoomServletTest extends TestCase {

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

		when(request.getParameter("roomTypeName")).thenReturn("deluxe");
		when(request.getParameter("breakfastChecked")).thenReturn("breakfast");
		when(request.getParameter("parkingChecked")).thenReturn("parking");
		when(request.getParameter("cabeChecked")).thenReturn("cabe");
		when(request.getSession()).thenReturn(session);
		when(request.getRequestDispatcher("/bookingDetails.jsp")).thenReturn(rd);
		
		RoomSearchSelectDetails detail = (RoomSearchSelectDetails) mock(RoomSearchSelectDetails.class);

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);

		new BookRoomServlet().doPost(request, response);
		
		verify(session).setAttribute("selectDetails", detail);

		/*UserProfileDao userDaoTest = mock(UserProfileDao.class);

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

		when(userDaoTest.searchForRoom(fromDate, toDate, true)).thenReturn(null);
		assertEquals(null, userDaoTest.searchForRoom(fromDate, toDate, true));

		when(userDaoTest.getRoomPricePerDay("deluxe", true)).thenReturn(2000.0);
		assertEquals(2000.0, userDaoTest.getRoomPricePerDay("deluxe", true));*/

		verify(rd).forward(request, response);
	}

}