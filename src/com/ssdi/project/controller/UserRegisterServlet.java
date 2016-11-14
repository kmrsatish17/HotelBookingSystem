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
import com.ssdi.project.beans.UserProfile;

@WebServlet(name = "RegisterServlet", urlPatterns = { "/RegisterServlet" })
public class UserRegisterServlet extends HttpServlet {

	private static final String REGISTERED = "User registered successfully. Please login to Continue. ";
	private static final String BOTH_PASS_NOT_MATCHING = "Password not matching.";
	private static final String USER_EXIST = "User already exist. Please login to continue.";

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
		String confirmPassword = request.getParameter("confirmPassword");
		String emailId = request.getParameter("emailId");
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");

		String url;

		if (userName.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || emailId.isEmpty()
				|| firstName.isEmpty() || lastName.isEmpty()) {

			url = "/userRegistration.jsp";
			String emptyMsg = "Registration form is empty";
			request.setAttribute("emptyMsg", emptyMsg);
			getServletContext().getRequestDispatcher(url).forward(request, response);

		} else if (password.equals(confirmPassword)) {

			UserProfile regProfile = new UserProfile(userName, firstName, lastName,
					emailId, password);

			UserProfileDao userDao = new UserProfileDaoImpl();
			int count = userDao.insertProfile(regProfile);
			
			if(count == 0){
				
				request.setAttribute("userExist", USER_EXIST);
				url = "/userLogin.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				
			}
			request.setAttribute("contLoginMsg", REGISTERED);
			url = "/userLogin.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}else{
			
			url = "/userRegistration.jsp";
			request.setAttribute("bothPassNoMatchMsg", BOTH_PASS_NOT_MATCHING);
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
	}
}
