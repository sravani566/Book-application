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

import com.bookstore.model.dao.user.User;



@WebFilter("*.do")
public class Cachefilters implements Filter {

  	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		HttpSession session = req.getSession(false);
		boolean isValid = false;
		if (session != null ) {
			User user = (User) session.getAttribute("user");
			if(user != null) {
				isValid = true;
			}
		}
		
		if(isValid) {
			res.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
	    	res.setHeader("Pragma", "no-cache"); // HTTP 1.0.
	    	res.setDateHeader("Expires", 0);
	        chain.doFilter(req, res);  
		    } else {
		        res.sendRedirect("login.jsp?message=please login"); 
		    }
	}

	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
