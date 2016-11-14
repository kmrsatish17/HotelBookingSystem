package com.ssdi.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ssdi.project.beans.RoomBookingDetails;

@WebServlet(name = "SubmitBookingDetail", urlPatterns = { "/SubmitBookingDetail" })
public class SubmitBookingDetail extends HttpServlet{

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req , resp);
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		RoomBookingDetails roomBookingDetails =  (RoomBookingDetails) request.getSession().getAttribute("roomBookingDetails");
		
		request.setAttribute("totalAmount", roomBookingDetails.getTotalPrice());
		//request.getSession().setAttribute("totalAmount", roomBookingDetails.getTotalPrice());
		
		String url = "/userPayment.jsp";
		getServletContext().getRequestDispatcher(url).forward(request, response);
		
		
	}
	
	
	

}
