package com.ssdi.project.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssdi.project.access.db.UserProfileDao;
import com.ssdi.project.access.db.UserProfileDaoImpl;
import com.ssdi.project.beans.RoomEntryDetails;
import com.ssdi.project.beans.UserContactDetail;
import com.ssdi.project.beans.UserProfile;

@WebServlet(name = "RoomEntryServlet", urlPatterns = { "/RoomEntryServlet" })
public class RoomEntryServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String fromDate = request.getParameter("fromDate");
		String toDate = request.getParameter("toDate");
		String bookId = request.getParameter("roomBookingId");
		String[] roomNumberChecked = request.getParameterValues("roomNumberChecked");

		String roomType = (String) request.getSession().getAttribute("roomTypeNameSelected");
		Integer noOfRoomsInt = (Integer) request.getSession().getAttribute("noOfRoomsSelected");
		List<String> roomList = (List<String>)request.getSession().getAttribute("roomTypeList");
		RoomEntryDetails roomEntryDetails = new RoomEntryDetails();
		boolean roomEntry = false;

		//int noOfRoomsInt = Integer.parseInt(noOfRooms);
		System.out.println("&&& firstName " + firstName);
		System.out.println("&&& lastName " + lastName);

		String url;

		if (firstName == null || firstName.isEmpty() ||lastName == null || lastName.isEmpty() ||fromDate == null || fromDate.isEmpty() || toDate == null || toDate.isEmpty() || bookId == null || bookId.isEmpty() || roomNumberChecked == null
				|| roomNumberChecked.length == 0) {

			url = "/performRoomEntry.jsp";
			String emptyEntryMsg = "Entry Details are empty";
			request.setAttribute("emptyEntryMsg", emptyEntryMsg);
			
			request.setAttribute("roomList", roomList);
			request.setAttribute("noOfRooms", noOfRoomsInt);
			request.setAttribute("roomTypeName", roomType);
			getServletContext().getRequestDispatcher(url).forward(request, response);

		} else {
			
			Date fromDateUt = null;
			Date toDateUt = null;

			//SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

			try {

				fromDateUt = (Date) formatter.parse(fromDate);
				toDateUt = (Date) formatter.parse(toDate);

			} catch (ParseException e) {
				e.printStackTrace();
			}
			
			if (fromDateUt.compareTo(toDateUt) > 0) {

				url = "/performRoomEntry.jsp";
				String dateNotProper = "From Date is after To Date. Please select the proper dates.";
				request.setAttribute("dateNotProper", dateNotProper);
				
				request.setAttribute("roomList", roomList);
				request.setAttribute("noOfRooms", noOfRoomsInt);
				request.setAttribute("roomTypeName", roomType);
				getServletContext().getRequestDispatcher(url).forward(request, response);

			}

			if (!(noOfRoomsInt == roomNumberChecked.length)) {

				url = "/performRoomEntry.jsp";
				String roomReqNotMatchingMsg = "No of Checkbox selected is not equl to no of room required";
				request.setAttribute("roomReqNotMatchingMsg", roomReqNotMatchingMsg);
				
				request.setAttribute("roomList", roomList);
				request.setAttribute("noOfRooms", noOfRoomsInt);
				request.setAttribute("roomTypeName", roomType);
				getServletContext().getRequestDispatcher(url).forward(request, response);

			} else {

				String oprUserName = (String) request.getSession().getAttribute("oprUserName");
				
				roomEntryDetails.setOprUserName(oprUserName);
				roomEntryDetails.setFromDate(fromDate);
				roomEntryDetails.setToDate(toDate);
				roomEntryDetails.setRoomNumberChecked(roomNumberChecked);
				roomEntryDetails.setBookId(bookId);
				roomEntryDetails.setRoomType(roomType);
				roomEntryDetails.setFirstName(firstName);
				roomEntryDetails.setLastName(lastName);
				roomEntryDetails.setNoOfRooms(noOfRoomsInt);

				UserProfileDao userDao = new UserProfileDaoImpl();

				roomEntry = userDao.saveRoomEntryDetails(roomEntryDetails, false);

				request.setAttribute("roomEntryDetails", roomEntryDetails);
				
				url = "/roomEntryDetail.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
		}

	}

}
