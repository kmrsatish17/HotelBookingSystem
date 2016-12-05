package com.ssdi.project.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssdi.project.access.db.UserProfileDao;
import com.ssdi.project.access.db.UserProfileDaoImpl;
import com.ssdi.project.beans.RoomBookingDetails;
import com.ssdi.project.beans.RoomSearchDetail;
import com.ssdi.project.beans.UserProfile;

@WebServlet(name = "ExistingLoginServlet", urlPatterns = { "/ExistingLoginServlet" })
public class ExistingLoginServlet extends HttpServlet {

	private static final String USER_PASS_NOT_MATCHING = "Username and Password not matching.";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		String url;

		if (userName.isEmpty() || password.isEmpty()) {

			url = "/existingUserLogin.jsp";
			String emptyLogin = "Please enter username and password";
			request.setAttribute("emptyLogin", emptyLogin);
			getServletContext().getRequestDispatcher(url).forward(request, response);

		} else {

			UserProfileDao userDao = new UserProfileDaoImpl();
			UserProfile user = userDao.getUserProfile(userName, false);

			if (user != null && !user.getPassword().isEmpty() && user.getPassword().equals(password)) {

				String succLoginMsg = "You are Logged In";
				request.getSession().setAttribute("userNameExist", userName);
				
				// Get all booking details and display on Dashboard page
				
				List<RoomBookingDetails> bookingDetailList = userDao.getBookingDetails(userName, false);
				System.out.println("^^^ bookingDetailList " + bookingDetailList);
				request.setAttribute("bookingDetailList", bookingDetailList);
				url = "/userDashboard.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);

			} else {

				request.setAttribute("userPassNotMatching", USER_PASS_NOT_MATCHING);
				url = "/existingUserLogin.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}

		}
	}
}