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
import com.ssdi.project.beans.RoomSearchDetail;
import com.ssdi.project.beans.RoomSearchSelectDetails;

@WebServlet(name = "SearchRoomEntryServlet", urlPatterns = { "/SearchRoomEntryServlet" })
public class SearchRoomEntryServlet extends HttpServlet {

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String noOfRoomsStr = request.getParameter("noOfRooms");
		String roomTypeName = request.getParameter("roomTypeName");

		String url;

		if (roomTypeName == null || roomTypeName.isEmpty() || noOfRoomsStr == null || noOfRoomsStr.isEmpty()) {

			url = "/searchRoomForEntry.jsp";
			String emptySearch = "Please enter the search details";
			request.setAttribute("emptySearch", emptySearch);
			getServletContext().getRequestDispatcher(url).forward(request, response);

		} else {

			int noOfRooms = Integer.parseInt(noOfRoomsStr);

			List<String> roomList = new ArrayList<String>();
			UserProfileDao userDao = new UserProfileDaoImpl();
			double roomPrice;

			roomList = userDao.searchRoomForEntry(roomTypeName, noOfRooms, false);

			if (roomList != null && !(roomList.size() == 0) && (roomList.size() >= noOfRooms)) {

				//request.getSession().setAttribute("selectDetails", selectedDetails);
				request.setAttribute("roomList", roomList);
				request.setAttribute("roomTypeName", roomTypeName);
				request.setAttribute("noOfRooms", noOfRooms);
				request.getSession().setAttribute("roomTypeList", roomList);
				request.getSession().setAttribute("roomTypeNameSelected", roomTypeName);
				request.getSession().setAttribute("noOfRoomsSelected", noOfRooms);

				url = "/performRoomEntry.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
			} else {

				url = "/searchRoomForEntry.jsp";
				String roomNotAvailable = "Room not Available";
				request.setAttribute("roomNotAvailable", roomNotAvailable);
				getServletContext().getRequestDispatcher(url).forward(request, response);
			}

		}

	}

}
