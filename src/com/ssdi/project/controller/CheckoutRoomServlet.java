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


@WebServlet(name = "CheckoutRoom", urlPatterns = { "/CheckoutRoom" })
public class CheckoutRoomServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String roomNumberSelected = request.getParameter("myradio");
		UserProfileDao userDao = new UserProfileDaoImpl();
		
		if (roomNumberSelected != null && !roomNumberSelected.isEmpty()){
			
			System.out.println("^^^ roomNumberSelected " + roomNumberSelected);
			
			
			//Get selected booking detail
			RoomEntryDetails roomEntryDetails = (RoomEntryDetails)userDao.getRoomEntryDetailsByRoomNo(roomNumberSelected, false);
			
			boolean cancelFlag = userDao.checkoutRoomEntryDetail(roomEntryDetails, false);
			String succCancleMsg = "Room with Room No. = " + roomNumberSelected + " has been checkedout.";
			String unSuccCancleMsg = "Not able to checkout Room for Room Number = " + roomNumberSelected;
			String url;

			if (cancelFlag) {

				// Get all booking details and display on Dashboard page
				
				List<RoomEntryDetails> entryDetailList = userDao.getRoomEntryDetails(false);
				System.out.println("^^^ entryDetailList " + entryDetailList);
				request.setAttribute("entryDetailList", entryDetailList);
				request.setAttribute("succCancleMsg", succCancleMsg);
				url = "/operatorDashboard.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
				
			} else {

				request.setAttribute("unSuccCancleMsg", unSuccCancleMsg);
				List<RoomEntryDetails> entryDetailList = userDao.getRoomEntryDetails(false);
				System.out.println("^^^ entryDetailList " + entryDetailList);
				request.setAttribute("entryDetailList", entryDetailList);
				url = "/operatorDashboard.jsp";
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}
			
		}else {
			
			request.setAttribute("radioNotSelected", "Room Number not selected");
			List<RoomEntryDetails> entryDetailList = userDao.getRoomEntryDetails(false);
			System.out.println("^^^ entryDetailList " + entryDetailList);
			request.setAttribute("entryDetailList", entryDetailList);
			String url = "/operatorDashboard.jsp";
			getServletContext().getRequestDispatcher(url).forward(request, response);
		}

	}

}
