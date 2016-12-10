package com.ssdi.project.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssdi.project.access.db.UserProfileDao;
import com.ssdi.project.access.db.UserProfileDaoImpl;
import com.ssdi.project.beans.RoomBookingDetails;
import com.ssdi.project.beans.UserProfile;

@WebServlet(name = "CancelHistoryServlet", urlPatterns = { "/CancelHistoryServlet" })
public class CancelHistoryServlet extends HttpServlet {

	private static final String USER_PASS_NOT_MATCHING = "Username and Password not matching.";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userNameExisting = (String) request.getSession().getAttribute("userNameExist");

		UserProfileDao userDao = new UserProfileDaoImpl();
		String url = null;
		// Get all booking details and display on Dashboard page

		List<RoomBookingDetails> bookingDetailList = userDao.getCancelledBookingDetails(userNameExisting, false);
		System.out.println("^^^ bookingDetailList " + bookingDetailList);
		request.setAttribute("bookingDetailList", bookingDetailList);
		url = "/cancelHistory.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);

	}
}
