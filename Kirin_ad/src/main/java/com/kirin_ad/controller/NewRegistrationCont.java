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
@WebServlet("/new")

public class NewRegistrationCont extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public NewRegistrationCont() {
        super();
     
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/views/NewRegistration.jsp");
		dis.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session.getAttribute("email")!=null) {
			String name=request.getParameter("name");
			String city=request.getParameter("city");
			String email=request.getParameter("email");
			String mobile=request.getParameter("mobile");
			
			Service ser= new ServiceImpl();
			
			ser.connectionDB() ;
			
			ser.saveRegistration(name, city, email, mobile);
			request.setAttribute("msg", "Record is saved");
			
			RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/views/NewRegistration.jsp");
			dis.forward(request, response);
			
			
		}
		else {
			
			request.setAttribute("error", "LoggedOut");
			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
			rd.forward(request, response);
		}
		
	}

}
