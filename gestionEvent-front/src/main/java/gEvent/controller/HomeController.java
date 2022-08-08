package gEvent.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import gEvent.context.Singleton;
import gEvent.model.Admin;
import gEvent.model.Compte;
import gEvent.model.User;


@WebServlet("/home")
public class HomeController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		if(request.getParameter("disconnect")!=null) 
		{
			request.getSession().removeAttribute("compte");
			response.sendRedirect("home");
			
		}
		else 
		{
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("login");
		String password = request.getParameter("password");
		
		
		Compte connected = Singleton.getInstance().getDaoCompte().seConnecter(login, password);
		
		if(connected instanceof User) 
		{
			request.getSession().setAttribute("compte", connected);
			response.sendRedirect("menu");
		}
		else if(connected instanceof Admin) 
		{
			request.getSession().setAttribute("compte", connected);
			response.sendRedirect("menu");
		}
		else 
		{
			request.setAttribute("error", "Identifiants invalides");
			this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}

		
	}

}
