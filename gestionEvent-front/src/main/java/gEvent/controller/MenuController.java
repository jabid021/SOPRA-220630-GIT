package gEvent.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gEvent.model.Admin;
import gEvent.model.Compte;
import gEvent.model.User;


@WebServlet("/menu")
public class MenuController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Compte connected = (Compte) request.getSession().getAttribute("compte");
		
		if(connected instanceof Admin) 
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/menuAdmin.jsp").forward(request, response);
		}
		else if(connected instanceof User)
		{
			this.getServletContext().getRequestDispatcher("/WEB-INF/menuUser.jsp").forward(request, response);
		}
		else {
			response.sendRedirect("home");
		}
	}

	
}
