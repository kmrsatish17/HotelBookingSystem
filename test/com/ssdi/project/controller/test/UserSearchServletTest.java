package com.ssdi.project.controller.test;

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
import java.util.ArrayList;
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

		/*
		 * HttpServletRequest request = mock(HttpServletRequest.class);
		 * HttpServletResponse response = mock(HttpServletResponse.class);
		 * HttpSession session = mock(HttpSession.class); RequestDispatcher
		 * rd=mock(RequestDispatcher.class);
		 */

		when(request.getParameter("fromDate")).thenReturn("12/01/2016");
		when(request.getParameter("toDate")).thenReturn("12/02/2016");
		when(request.getParameter("noOfRooms")).thenReturn("2");
		when(request.getSession()).thenReturn(session);
		when(request.getRequestDispatcher("/searchRoomResult.jsp")).thenReturn(rd);

		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);

		when(response.getWriter()).thenReturn(pw);

		new UserSearchServlet().doPost(request, response);
		
		RoomSearchSelectDetails selectedDetails = new RoomSearchSelectDetails();
		List<String> roomTypeList = new ArrayList<String>();
		roomTypeList.add("deluxe");
		roomTypeList.add("luxury");
		roomTypeList.add("super deluxe");
		selectedDetails.setFromDateSelected("12/01/2016");
		selectedDetails.setToDateSelected("12/02/2016");
		selectedDetails.setNoOfRoomSelected("2");
		selectedDetails.setRoomTypeAvailable(roomTypeList);

		// Verify the session attribute value
		//verify(session).setAttribute("selectDetails", selectedDetails);
		verify(rd).forward(request, response);

		String result = sw.getBuffer().toString().trim();

		System.out.println("Result: " + result);

		//assertEquals("Login successfull...", result);

	}

}
