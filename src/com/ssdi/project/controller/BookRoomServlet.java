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
import com.ssdi.project.business.PerformBusinessOperation;

@WebServlet(name = "BookRoomServlet", urlPatterns = { "/BookRoomServlet" })
public class BookRoomServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		RoomSearchSelectDetails selectDetails = (RoomSearchSelectDetails) request.getSession()
				.getAttribute("selectDetails");
		String roomTypeName = request.getParameter("roomTypeName");
		String breakfastChecked = request.getParameter("breakfastChecked");
		String parkingChecked = request.getParameter("parkingChecked");
		String cabeChecked = request.getParameter("cabeChecked");
		
		System.out.println("### breakfastChecked" + breakfastChecked);
		System.out.println("### parkingChecked" + parkingChecked);
		System.out.println("### cabeChecked" + cabeChecked);
		
		PerformBusinessOperation business = new PerformBusinessOperation();

		String url;

		if (roomTypeName != null && !roomTypeName.isEmpty()) {

			double totalPrice = 0;
			double basicPrice = 0;
			double taxAmount = 0;
			double extraGuestFee = 0;
			double breakfastCharge = 0;
			double cabeCharge = 0;
			double parkingCharge = 0;
			double taxFraction = 0.15;
			

			RoomBookingDetails bookDeatils = new RoomBookingDetails();
			bookDeatils.setFromDate(selectDetails.getFromDateSelected());
			bookDeatils.setToDate(selectDetails.getToDateSelected());
			bookDeatils.setRoomType(roomTypeName);
			bookDeatils.setNoOfRooms(Integer.parseInt(selectDetails.getNoOfRoomSelected()));
			bookDeatils.setNoOfAdults(Integer.parseInt(selectDetails.getNoOfAdultsSelected()));

			basicPrice = business.calculateBasePrice(selectDetails.getFromDateSelected(),
					selectDetails.getToDateSelected(), Integer.parseInt(selectDetails.getNoOfRoomSelected()),
					roomTypeName, basicPrice, breakfastChecked, parkingChecked, cabeChecked);
			
			breakfastCharge = business.calculateBreakfastCharge(selectDetails.getFromDateSelected(),
					selectDetails.getToDateSelected(), breakfastChecked);
			
			cabeCharge = business.calculateCabeCharge(selectDetails.getFromDateSelected(),
					selectDetails.getToDateSelected(), cabeChecked);
			
			parkingCharge = business.calculateParkingCharge(selectDetails.getFromDateSelected(),
					selectDetails.getToDateSelected(), parkingChecked);
			
			extraGuestFee = business.calculateExtraFee(Integer.parseInt(selectDetails.getNoOfRoomSelected()),
					Integer.parseInt(selectDetails.getNoOfAdultsSelected()));

			taxAmount = (basicPrice + extraGuestFee + cabeCharge + parkingCharge + breakfastCharge) * taxFraction;
			totalPrice = basicPrice + extraGuestFee + cabeCharge + parkingCharge + breakfastCharge + taxAmount;

			bookDeatils.setTotalPrice(totalPrice);
			bookDeatils.setBasicPrice(basicPrice);
			bookDeatils.setTaxAmount(taxAmount);
			bookDeatils.setExtraGuestFee(extraGuestFee);
			bookDeatils.setBreakfastCharge(breakfastCharge);
			bookDeatils.setParkingCharge(parkingCharge);
			bookDeatils.setCabeCharge(cabeCharge);
			
			request.setAttribute("bookingDetails", bookDeatils);
			request.getSession().setAttribute("roomBookingDetails", bookDeatils);
			url = "/bookingDetails.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);

		} else {

			url = "/searchRoom.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);

		}

	}

}
