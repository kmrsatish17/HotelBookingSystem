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

@WebServlet(name = "ModifyBooking", urlPatterns = { "/ModifyBooking" })
public class ModifyBookingServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req , resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String bookingId = request.getParameter("myradio");
		
		if(bookingId != null && !bookingId.isEmpty()){
			
		

		System.out.println("^^^ bookingId " + bookingId);
		String userNameExisting = (String) request.getSession().getAttribute("userNameExist");
		UserProfileDao userDao = new UserProfileDaoImpl();
		
		//Get selected booking detail
		RoomBookingDetails bookingDetailSelected = (RoomBookingDetails)userDao.getBookingDetailsById(bookingId, false);
		request.setAttribute("bookingDetailSelected", bookingDetailSelected);
		request.getSession().setAttribute("bookingDetailSelected", bookingDetailSelected);
		
		String url = "/modifyBooking.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
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
