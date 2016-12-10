package com.ssdi.project.controller.test;

import com.ssdi.project.access.db.UserProfileDao;
import com.ssdi.project.beans.RoomSearchSelectDetails;
import com.ssdi.project.controller.UserSearchServlet;
import junit.framework.TestCase;
import static org.junit.Assert.assertEquals;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import junit.framework.TestCase;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class UserSearchServletTest extends TestCase {

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

		when(request.getParameter("fromDate")).thenReturn("11/30/2016");
		when(request.getParameter("toDate")).thenReturn("11/30/2016");
		when(request.getParameter("noOfRooms")).thenReturn("5");
		when(request.getParameter("noOfAdults")).thenReturn("5");
		when(request.getSession()).thenReturn(session);
		when(request.getRequestDispatcher("/searchRoomResult.jsp")).thenReturn(rd);

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);

		new UserSearchServlet().doPost(request, response);
		
		UserProfileDao userDaoTest =mock(UserProfileDao.class);
		
		Date fromDate = null;
		Date toDate = null;

		//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

		try {

			fromDate = (Date) formatter.parse("11/30/2016");
			toDate = (Date) formatter.parse("11/30/2016");

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		when(userDaoTest.searchForRoom(fromDate, toDate, true)).thenReturn(null);
		assertEquals(null,userDaoTest.searchForRoom(fromDate, toDate, true));
		
		when(userDaoTest.getRoomPricePerDay("deluxe", true)).thenReturn(2000.0);
		assertEquals(2000.0,userDaoTest.getRoomPricePerDay("deluxe", true));
		
		verify(rd).forward(request, response);
	}

}
