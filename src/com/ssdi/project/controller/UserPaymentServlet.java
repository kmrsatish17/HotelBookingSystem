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

@WebServlet(name = "PaymentServlet", urlPatterns = { "/PaymentServlet" })
public class UserPaymentServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String cardNumber = request.getParameter("cardNumber");
		String cardName = request.getParameter("cardName");
		String cvvNumber = request.getParameter("cvvNumber");

		String url;
		UserProfileDao userDao = new UserProfileDaoImpl();

		if (cardNumber.isEmpty() || cardName.isEmpty() || cvvNumber.isEmpty()) {

			url = "/userPayment.jsp";
			String emptyPayMsg = "Payment deatils are empty";
			request.setAttribute("emptyPayMsg", emptyPayMsg);
			RoomBookingDetails roomBookingDetails = (RoomBookingDetails) request.getSession()
					.getAttribute("roomBookingDetails");
			request.setAttribute("totalAmount", roomBookingDetails.getTotalPrice());
			getServletContext().getRequestDispatcher(url).forward(request, response);

		} else {

			int cardNumberInt = Integer.parseInt(cardNumber);
			int cvvNumberInt = Integer.parseInt(cvvNumber);
			// int amountInt = Integer.parseInt(amount);
			boolean paymentFlag = true;

			paymentFlag = userDao.getPaymentValidity(cardNumberInt, cardName, cvvNumberInt);

			if (paymentFlag) {

				url = "/userBookingConf.jsp";
				request.setAttribute("bookSuccessful", "Your Booking is successful");
				RoomBookingDetails roomBookingDetails = (RoomBookingDetails) request.getSession()
						.getAttribute("roomBookingDetails");

				System.out.println("#### roomBookingDetails " + roomBookingDetails);

				// Save all data in DB
				userDao.saveBookingDetails(roomBookingDetails);
				
				//Update ROOM_AVAILABLE table
				userDao.updateRoomAvailable(roomBookingDetails);
				System.out.println("***** booking Details " + roomBookingDetails);
				request.setAttribute("bookSuccessfulDetails", roomBookingDetails);
				getServletContext().getRequestDispatcher(url).forward(request, response);

			} else {

				url = "/userPayment.jsp";
				request.setAttribute("bookNotSuccessful", "Payment details not matching. Booking is not successful");
				RoomBookingDetails roomBookingDetails = (RoomBookingDetails) request.getSession()
						.getAttribute("roomBookingDetails");
				request.setAttribute("totalAmount", roomBookingDetails.getTotalPrice());
				getServletContext().getRequestDispatcher(url).forward(request, response);

			}

		}
	}
}
