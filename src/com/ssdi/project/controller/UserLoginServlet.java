package com.ssdi.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.ssdi.project.access.db.UserProfileDao;
import com.ssdi.project.access.db.UserProfileDaoImpl;
import com.ssdi.project.access.db.test.UserProfileDaoImplTest;
import com.ssdi.project.beans.RoomBookingDetails;
import com.ssdi.project.beans.UserProfile;

@WebServlet(name = "LoginServlet", urlPatterns = { "/LoginServlet" })
public class UserLoginServlet extends HttpServlet {

	private static final String USER_PASS_NOT_MATCHING = "Username and Password not matching.";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userName = request.getParameter("userName");
		String password = request.getParameter("password");

		String url;

		if (userName.isEmpty() || password.isEmpty()) {

			url = "/userLogin.jsp";
			String emptyLogin = "Please enter username and password";
			request.setAttribute("emptyLogin", emptyLogin);
			getServletContext().getRequestDispatcher(url).forward(request, response);

		} else {

			UserProfileDao userDao = new UserProfileDaoImpl();
			UserProfile user = userDao.getUserProfile(userName, false);
			
			if(user != null && !user.getPassword().isEmpty() && user.getPassword().equals(password)){
				
				String succLoginMsg = "You are Logged In";
				request.setAttribute("succLoginMsg", succLoginMsg);
				
				RoomBookingDetails roomBookingDetails =  (RoomBookingDetails) request.getSession().getAttribute("roomBookingDetails");
				roomBookingDetails.setUserName(userName);
				
				request.getSession().setAttribute("roomBookingDetails", roomBookingDetails);
				request.getSession().setAttribute("userName", userName);

				url = "/contactDetails.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				
			}else{
				
				request.setAttribute("userPassNotMatching", USER_PASS_NOT_MATCHING);
				url = "/userLogin.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
			
		}

	}

}
