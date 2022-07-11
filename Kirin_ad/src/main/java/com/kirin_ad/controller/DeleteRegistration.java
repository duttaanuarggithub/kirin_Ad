package com.kirin_ad.controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

import com.kirin_app.model.Service;
import com.kirin_app.model.ServiceImpl;
@WebServlet("/delete")

public class DeleteRegistration extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public DeleteRegistration() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email=request.getParameter("email");
		Service ser= new ServiceImpl();
		ser.connectionDB() ;
		ser.deleteRegistration(email);
		ResultSet result= ser.listAllReg();
        request.setAttribute("result", result);
        RequestDispatcher dis = request.getRequestDispatcher("WEB-INF/views/SearchRegistration.jsp");
		dis.include(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
