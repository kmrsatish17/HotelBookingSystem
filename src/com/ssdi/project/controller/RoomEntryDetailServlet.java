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
import com.ssdi.project.beans.RoomEntryDetails;
import com.ssdi.project.beans.UserProfile;

@WebServlet(name = "RoomEntryDetailServlet", urlPatterns = { "/RoomEntryDetailServlet" })
public class RoomEntryDetailServlet extends HttpServlet {

	private static final String USER_PASS_NOT_MATCHING = "Username and Password not matching.";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Get all entry details and display on entryDashBoard Page
		String url ;
		UserProfileDao userDao = new UserProfileDaoImpl();

		List<RoomEntryDetails> entryDetailList = userDao.getRoomEntryDetails(false);
		System.out.println("^^^ entryDetailList " + entryDetailList);
		request.setAttribute("entryDetailList", entryDetailList);
		url = "/operatorDashboard.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);

	}
}
