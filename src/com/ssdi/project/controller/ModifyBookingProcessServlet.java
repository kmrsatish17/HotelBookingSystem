package com.ssdi.project.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
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

@WebServlet(name = "ModifyBookingProcessServlet", urlPatterns = { "/ModifyBookingProcessServlet" })
public class ModifyBookingProcessServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String fromDateStr = request.getParameter("fromDate");
		String toDateStr = request.getParameter("toDate");
		String noOFrooms = request.getParameter("noOfRooms");
		String noOFAdults = request.getParameter("noOfAdults");
		String newRoomType = request.getParameter("roomTypeName");
		String url;

		if ( fromDateStr == null || fromDateStr.isEmpty() || toDateStr == null || toDateStr.isEmpty() ||  noOFrooms == null || noOFrooms.isEmpty() || noOFAdults == null  || noOFAdults.isEmpty()
				|| newRoomType == null || newRoomType.isEmpty()) {

			url = "/modifyBooking.jsp";
			String emptyModification = "Please enter the modification details";
			request.setAttribute("emptyModification", emptyModification);
			getServletContext().getRequestDispatcher(url).forward(request, response);

		} else {

			RoomBookingDetails oldRoomDetails = (RoomBookingDetails) request.getSession()
					.getAttribute("bookingDetailSelected");

			Date oldFromDate = null;
			Date oldToDate = null;
			Date newFromDate = null;
			Date newToDate = null;
			List<RoomSearchDetail> roomSearchList = new ArrayList<RoomSearchDetail>();
			UserProfileDao userDao = new UserProfileDaoImpl();
			RoomSearchDetail modifiedRoomDetails = new RoomSearchDetail();
			PerformBusinessOperation business = new PerformBusinessOperation();
			RoomBookingDetails modifiedRoomToDisplay = new RoomBookingDetails();
			boolean modifyFlag = false;

			SimpleDateFormat oldFormatter = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat newFormatter = new SimpleDateFormat("MM/dd/yyyy");

			try {

				newFromDate = (Date) newFormatter.parse(fromDateStr);
				newToDate = (Date) newFormatter.parse(toDateStr);
				oldFromDate = (Date) oldFormatter.parse(oldRoomDetails.getFromDate());
				oldToDate = (Date) oldFormatter.parse(oldRoomDetails.getToDate());

			} catch (ParseException e) {
				e.printStackTrace();
			}

			int newNoOfRooms = Integer.parseInt(noOFrooms);
			int newNoOfAdults = Integer.parseInt(noOFAdults);
			int oldNoOfRooms = oldRoomDetails.getNoOfRooms();
			int oldNoOfAdults = oldRoomDetails.getNoOfAdults();
			String oldRoomType = oldRoomDetails.getRoomType();

			modifiedRoomDetails.setFromDate(fromDateStr);
			modifiedRoomDetails.setToDate(toDateStr);
			modifiedRoomDetails.setRoomType(newRoomType);
			modifiedRoomDetails.setNoOfRooms(newNoOfRooms);
			modifiedRoomDetails.setNoOfAdults(newNoOfAdults);

			if (oldFromDate.compareTo(oldToDate) > 0) {

				url = "/modifyBooking.jsp";
				String dateNotProper = "From Date is after To Date. Please select the proper dates.";
				request.setAttribute("dateNotProper", dateNotProper);
				getServletContext().getRequestDispatcher(url).forward(request, response);

			}

			if (((newFromDate.compareTo(oldFromDate)) >= 0) && ((oldToDate.compareTo(newToDate)) >= 0)
					&& (oldRoomType.equals(newRoomType)) && (oldNoOfRooms >= newNoOfRooms)) {

				modifiedRoomToDisplay = business.getModificationDetails(modifiedRoomDetails, oldRoomDetails);
				userDao.updateBookingDetails(modifiedRoomToDisplay, false);
				
				modifiedRoomToDisplay.setNetAmountPay( modifiedRoomToDisplay.getTotalPrice() - oldRoomDetails.getTotalPrice());
				request.setAttribute("modifiedRoomToDisplay", modifiedRoomToDisplay);
				
				System.out.println("7777 modifiedRoomToDisplay.getTotalPrice()" + modifiedRoomToDisplay.getTotalPrice());
				System.out.println("7777 oldRoomDetails.getTotalPrice()" + oldRoomDetails.getTotalPrice());
				System.out.println("7777 modifiedRoomToDisplay.getNetAmountPay()" + modifiedRoomToDisplay.getNetAmountPay());
				
                System.out.println("7777 modifiedRoomToDisplay " + modifiedRoomToDisplay);
				url = "/modifiedBookingDetail.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);

			} else {

				roomSearchList = userDao.searchForRoom(newFromDate, newToDate, false);

				modifyFlag = business.validateModification(newRoomType, roomSearchList, newNoOfRooms);

				if (modifyFlag) {

					modifiedRoomToDisplay = business.getModificationDetails(modifiedRoomDetails, oldRoomDetails);

					userDao.updateBookingDetails(modifiedRoomToDisplay, false);
					modifiedRoomToDisplay.setNetAmountPay( modifiedRoomToDisplay.getTotalPrice() - oldRoomDetails.getTotalPrice());
					
					System.out.println("7777 modifiedRoomToDisplay.getTotalPrice()" + modifiedRoomToDisplay.getTotalPrice());
					System.out.println("7777 oldRoomDetails.getTotalPrice()" + oldRoomDetails.getTotalPrice());
					System.out.println("7777 modifiedRoomToDisplay.getNetAmountPay()" + modifiedRoomToDisplay.getNetAmountPay());
					
					
					request.setAttribute("modifiedRoomToDisplay", modifiedRoomToDisplay);
					System.out.println("7777 modifiedRoomToDisplay " + modifiedRoomToDisplay);
					url = "/modifiedBookingDetail.jsp";
					getServletContext().getRequestDispatcher(url).forward(request, response);

				}

			}

		}

	}

}
