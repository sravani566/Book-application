package com.filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bookstore.model.dao.user.*;


@WebFilter("*.do")
public class Filterssec implements Filter {
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		HttpSession session = req.getSession(false);
		boolean isValid = false; //let assume he is not valid user!
		if(session != null) {
			User user = (User) session.getAttribute("user");
			if(user != null) {
				isValid = true;
			}
		}
		if(isValid) {
			chain.doFilter(request, response);
		} else {
			res.sendRedirect("login.jsp?message=please login");
		}
	}
}

