package com.bookstore.controller.model.web;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bookstore.model.dao.book.Book;
import com.bookstore.model.dao.book.BookDao;
import com.bookstore.model.dao.book.BookDaoImpl;

@WebServlet("/BookController.do")
public class BookController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private BookDao bookDao;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		bookDao = new BookDaoImpl();
		if(action.equals("showbooks")) {
			List<Book> books = bookDao.getAll();
			request.setAttribute("books", books);
			RequestDispatcher dispatcher = request.getRequestDispatcher("show.jsp");
			dispatcher.forward(request, response);
		
		} else if(action.equals("addbook")) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("addbook.jsp");
			dispatcher.forward(request, response);
		
		} else if(action.equals("deletebook")) {
			
			int id = Integer.parseInt(request.getParameter("id").trim());
			bookDao.delete(id);
			response.sendRedirect("BookController.do?action=showbooks");
			
		} else if(action.equals("updatebook")) {
			int id = Integer.parseInt(request.getParameter("id").trim());
			Book book = bookDao.getById(id);
			request.setAttribute("book", book);
			request.getRequestDispatcher("updatebook.jsp").forward(request, response);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		bookDao = new BookDaoImpl();
		int id = Integer.parseInt(request.getParameter("id").trim());
		System.out.println(id);
		
		String isbn = request.getParameter("isbn");
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String priceString = request.getParameter("price");
		
		
		
		Double price = Double.parseDouble(priceString);
		
		Book book = new Book(isbn, title, author, price);
		if(id == 0) {
			bookDao.add(book);
		} else if(id > 0) {
			bookDao.update(id, price);
		}
		response.sendRedirect("BookController.do?action=showbooks");
	}
}
