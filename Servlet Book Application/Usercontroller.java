package com.bookstore.controller.model.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.model.dao.book.*;
import com.bookstore.model.dao.user.UserDao;

@WebServlet("/Usercontroller.do")
public class Usercontroller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UserDao userDao;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getParameter("action");
		
		if(action.equals("adduser")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("adduser.jsp");
			dispatcher.forward(request, response);
		}
	
	}
}

