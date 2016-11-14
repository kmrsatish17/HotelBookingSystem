package com.ssdi.project.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
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
import com.ssdi.project.beans.RoomSearchSelectDetails;

@WebServlet(name = "BookRoomServlet", urlPatterns = { "/BookRoomServlet" })
public class BookRoomServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub

		RoomSearchSelectDetails selectDetails = (RoomSearchSelectDetails) request.getSession()
				.getAttribute("selectDetails");
		String roomTypeName = request.getParameter("roomTypeName");

		String url;

		if (roomTypeName != null && !roomTypeName.isEmpty()) {

			double totalPrice = 0;
			double basicPrice = 0;
			double taxAmount = 0;

			RoomBookingDetails bookDeatils = new RoomBookingDetails();
			bookDeatils.setFromDate(selectDetails.getFromDateSelected());
			bookDeatils.setToDate(selectDetails.getToDateSelected());
			bookDeatils.setRoomType(roomTypeName);
			bookDeatils.setNoOfRooms(Integer.parseInt(selectDetails.getNoOfRoomSelected()));

			basicPrice = calculateBasePrice(selectDetails, roomTypeName, basicPrice);

			taxAmount = basicPrice * 0.15;
			totalPrice = basicPrice + taxAmount;

			bookDeatils.setTotalPrice(totalPrice);
			bookDeatils.setBasicPrice(basicPrice);
			bookDeatils.setTaxAmount(taxAmount);
			request.setAttribute("bookingDetails", bookDeatils);
			request.getSession().setAttribute("roomBookingDetails", bookDeatils);
			url = "/bookingDetails.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);

		} else {

			url = "/searchRoom.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);

		}

	}

	private double calculateBasePrice(RoomSearchSelectDetails selectDetails, String roomTypeName, double basicPrice) {
		
		Date fromDate = null;
		Date toDate = null;

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

		try {

			fromDate = (Date) formatter.parse(selectDetails.getFromDateSelected());
			toDate = (Date) formatter.parse(selectDetails.getToDateSelected());

		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		long numberOfDays = ChronoUnit.DAYS.between(fromDate.toInstant(), toDate.toInstant()) + 1;
		
		System.out.println("@@@@ numberOfDays " + numberOfDays);
		
		if (roomTypeName.equals("deluxe")) {

			basicPrice = 2000 * (Integer.parseInt(selectDetails.getNoOfRoomSelected())) * numberOfDays;
		} else if (roomTypeName.equals("luxury")) {

			basicPrice = 2500 * (Integer.parseInt(selectDetails.getNoOfRoomSelected())) * numberOfDays;
		}else if (roomTypeName.equals("super deluxe")) {

			basicPrice = 3000 * (Integer.parseInt(selectDetails.getNoOfRoomSelected())) * numberOfDays;
		}
		
		return basicPrice;
	}

}
