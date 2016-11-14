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
import com.ssdi.project.beans.UserProfile;

@WebServlet(name = "SearchServlet", urlPatterns = { "/SearchServlet" })
public class UserSearchServlet extends HttpServlet {

	private static final String USER_PASS_NOT_MATCHING = "Username and Password not matching.";

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String fromDateStr = request.getParameter("fromDate");
		String toDateStr = request.getParameter("toDate");
		String noOfRoomsStr = request.getParameter("noOfRooms");
		String url;

		if (fromDateStr.isEmpty() || toDateStr.isEmpty() || noOfRoomsStr.isEmpty()) {

			url = "/searchRoom.jsp";
			String emptySearch = "Please enter the search fields";
			request.setAttribute("emptySearch", emptySearch);
			getServletContext().getRequestDispatcher(url).forward(request, response);

		} else {

			int noOfRooms = Integer.parseInt(noOfRoomsStr);

			Date fromDate = null;
			Date toDate = null;

			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

			try {

				fromDate = (Date) formatter.parse(fromDateStr);
				toDate = (Date) formatter.parse(toDateStr);

			} catch (ParseException e) {
				e.printStackTrace();
			}

			List<RoomSearchDetail> roomSearchList = new ArrayList<RoomSearchDetail>();
			List<RoomSearchDetail> roomSearchListReq = new ArrayList<RoomSearchDetail>();
			List<String> roomTypeList = new ArrayList<String>();
			UserProfileDao userDao = new UserProfileDaoImpl();

			roomSearchList = userDao.searchForRoom(fromDate, toDate);

			if (roomSearchList != null && !(roomSearchList.size() == 0)) {

				for (RoomSearchDetail room : roomSearchList) {

					if (room.getNoOfRooms() >= noOfRooms) {
						room.setFromDate(fromDateStr);
						room.setToDate(toDateStr);

						roomTypeList.add(room.getRoomType());
						roomSearchListReq.add(room);

					}
				}

				if(roomSearchListReq != null && !(roomSearchListReq.size() == 0)){
				RoomSearchSelectDetails selectedDetails = new RoomSearchSelectDetails();
				selectedDetails.setFromDateSelected(fromDateStr);
				selectedDetails.setToDateSelected(toDateStr);
				selectedDetails.setNoOfRoomSelected(noOfRoomsStr);
				selectedDetails.setRoomTypeAvailable(roomTypeList);

				request.getSession().setAttribute("selectDetails", selectedDetails);

				request.setAttribute("roomSearchListReq", roomSearchListReq);
				url = "/searchRoomResult.jsp";
				RequestDispatcher rd = request.getRequestDispatcher(url);
				rd.forward(request, response);
				} else {
					
					url = "/searchRoom.jsp";
					String roomNotAvailable = "Room not Available";
					request.setAttribute("roomNotAvailable", roomNotAvailable);
					getServletContext().getRequestDispatcher(url).forward(request, response);
				}

			} else {
				url = "/searchRoom.jsp";
				String roomNotAvailable = "Room not Available";
				request.setAttribute("roomNotAvailable", roomNotAvailable);
				getServletContext().getRequestDispatcher(url).forward(request, response);

			}

		}

	}
}
