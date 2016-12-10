package com.ssdi.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssdi.project.access.db.UserProfileDao;
import com.ssdi.project.access.db.UserProfileDaoImpl;
import com.ssdi.project.beans.RoomBookingDetails;
import com.ssdi.project.beans.UserProfile;

@WebServlet(name = "CancelBooking", urlPatterns = { "/CancelBooking" })
public class CancelBookingServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String bookingId = request.getParameter("myradio");
		
		if (bookingId != null && !bookingId.isEmpty()){
			
			System.out.println("^^^ bookingId " + bookingId);
			String userNameExisting = (String) request.getSession().getAttribute("userNameExist");
			UserProfileDao userDao = new UserProfileDaoImpl();
			
			//Get selected booking detail
			RoomBookingDetails bookingDetailSelected = (RoomBookingDetails)userDao.getBookingDetailsById(bookingId, false);
			
			boolean cancelFlag = userDao.cancelBookingDetail(bookingDetailSelected, false);
			String succCancleMsg = "Your Booking with Booking Id = " + bookingId + " has been cancelled";
			String unSuccCancleMsg = "Not able to cancel booking for Booking Id = " + bookingId;
			String url;

			if (cancelFlag) {

				// Get all booking details and display on Dashboard page
				List<RoomBookingDetails> bookingDetailList = userDao.getBookingDetails(userNameExisting, false);
				System.out.println("^^^ bookingDetailList " + bookingDetailList);
				request.setAttribute("bookingDetailList", bookingDetailList);
				
				// Get contact details
				UserProfile userProfile = userDao.getUserProfile(userNameExisting, false);
				
				request.setAttribute("bookingDetailSelected", bookingDetailSelected);
				request.setAttribute("userProfile", userProfile);
				request.setAttribute("succCancleMsg", succCancleMsg);
				url = "/cancelBookingDetail.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);

			} else {

				request.setAttribute("unSuccCancleMsg", unSuccCancleMsg);
				url = "/userDashboard.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
			
		}else {
			
			request.setAttribute("radioNotSelected", "Booking id not selected");
			String userName = (String) request.getSession().getAttribute("userNameExist");
			UserProfileDao userDao = new UserProfileDaoImpl();
			
			// Get all booking details and display on Dashboard page
			List<RoomBookingDetails> bookingDetailList = userDao.getBookingDetails(userName, false);
			//System.out.println("^^^ bookingDetailList " + bookingDetailList);
			request.setAttribute("bookingDetailList", bookingDetailList);
			String url = "/userDashboard.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}

	}

}