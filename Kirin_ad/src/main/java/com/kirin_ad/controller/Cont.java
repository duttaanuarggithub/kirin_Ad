package com.kirin_ad.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import com.kirin_app.model.Service;
import com.kirin_app.model.ServiceImpl;

@WebServlet("/login")
public class Cont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public Cont() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		Service ser= new ServiceImpl();
		ser.connectionDB() ;
		boolean status=ser.verifyCredentials(email,password);
		if(status==true) {
			HttpSession session = request.getSession(true);
			session.setAttribute("email", email);
	RequestDispatcher d = request.getRequestDispatcher("WEB-INF/views/NewRegistration.jsp")	;
	d.forward(request, response);
			
		}
		else {
			request.setAttribute("error", "Invalid Username/Password");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
	}

}
