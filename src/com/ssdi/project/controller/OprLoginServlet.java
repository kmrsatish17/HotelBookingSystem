package com.ssdi.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssdi.project.access.db.UserProfileDao;
import com.ssdi.project.access.db.UserProfileDaoImpl;
import com.ssdi.project.beans.OperatorProfile;
import com.ssdi.project.beans.RoomBookingDetails;
import com.ssdi.project.beans.UserProfile;


@WebServlet(name = "OprLoginServlet", urlPatterns = { "/OprLoginServlet" })
public class OprLoginServlet extends HttpServlet {

	private static final String USER_PASS_NOT_MATCHING = "Username and Password not matching.";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String oprUserName = request.getParameter("oprUserName");
		String oprPassword = request.getParameter("oprPassword");
		
		System.out.println("&&& oprUserName " + oprUserName);
		System.out.println("&&& oprPassword " + oprPassword);

		String url;

		if (oprUserName.isEmpty() || oprPassword.isEmpty()) {

			url = "/operatorLogin.jsp";
			String emptyLogin = "Please enter username and password";
			request.setAttribute("emptyLogin", emptyLogin);
			getServletContext().getRequestDispatcher(url).forward(request, response);

		} else {

			UserProfileDao userDao = new UserProfileDaoImpl();
			OperatorProfile operator = userDao.getOperatorProfile(oprUserName, false);
			
			if(operator != null && !operator.getOprPassword().isEmpty() && operator.getOprPassword().equals(oprPassword)){
				
				String succLoginMsg = "You are Logged In";
				request.setAttribute("succLoginMsg", succLoginMsg);
				
				Cookie userCookie = new Cookie("userCookie", oprUserName);
				Cookie userCookie2 = new Cookie("userCookie", oprPassword);
                userCookie.setMaxAge(1*60*60);
                userCookie.setPath("/");
                userCookie2.setMaxAge(1*60*60);
                userCookie2.setPath("/");
                response.addCookie(userCookie);
                response.addCookie(userCookie2);
				
				request.getSession().setAttribute("oprUserName", oprUserName);

				url = "/searchRoomForEntry.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				
			}else{
				
				request.setAttribute("userPassNotMatching", USER_PASS_NOT_MATCHING);
				url = "/operatorLogin.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
			
		}

	}

}