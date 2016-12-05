package com.ssdi.project.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;




@WebServlet(name = "HomepageServlet", urlPatterns = { "/HomepageServlet" })
public class HomepageServlet extends HttpServlet {


	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
		
		
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*HttpSession session = request.getSession();
		
		session=request.getSession();  
        session.invalidate();  
        System.out.println("Log out successful "); 
         String messageLogOut = "You are successfully logged out!";*/
        String url = "/searchRoom.jsp";
       // request.setAttribute("messageLogOut", messageLogOut);
        request.getServletContext().getRequestDispatcher(url).forward(request, response);

	}

}
