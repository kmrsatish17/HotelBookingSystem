package com.ssdi.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssdi.project.access.db.UserProfileDao;
import com.ssdi.project.access.db.UserProfileDaoImpl;
import com.ssdi.project.beans.RoomBookingDetails;
import com.ssdi.project.beans.UserContactDetail;
import com.ssdi.project.beans.UserProfile;


@WebServlet(name = "ContactDetailServlet", urlPatterns = { "/ContactDetailServlet" })
public class ContactDetailServlet extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req , resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String country = request.getParameter("country");
		String zip = request.getParameter("zip");
		String phoneNumber = request.getParameter("phoneNumber");

		String url;

		if (address1.isEmpty() || city.isEmpty() || zip.isEmpty() || phoneNumber.isEmpty() || country.isEmpty()
				) {

			url = "/contactDetails.jsp";
			String emptyContactMsg = "Contact Details are empty";
			request.setAttribute("emptyContactMsg", emptyContactMsg);
			getServletContext().getRequestDispatcher(url).forward(request, response);

		} else {
			
			String userName = (String) request.getSession().getAttribute("userName");
			
			UserProfileDao userDao = new UserProfileDaoImpl();

			UserProfile profile = userDao.getUserProfile(userName, false);
			
			UserContactDetail contactDetail = new UserContactDetail(profile.getFirstName(), profile.getLastName(), userName, address1, address2, city, state, country, zip, phoneNumber);

			request.getSession().setAttribute("contactDetail", contactDetail);
			
			int count = userDao.insertContactDetails(contactDetail, false);
			
			/*if(count == 0){
				
				request.setAttribute("userContactExist", "User Contact Detail Exists");
				url = "/userLogin.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				
			}*/
			//request.setAttribute("contLoginMsg", REGISTERED);
			
			double totalAmount = (double) request.getSession().getAttribute("totalAmount");
			System.out.println("%%% totalAmount " + totalAmount);
			request.setAttribute("totalAmount", totalAmount);
			url = "/userPayment.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}
	
		
		
	}
	

}