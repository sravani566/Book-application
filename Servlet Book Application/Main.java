package com.bookstore.model.dao.book;

import java.util.List;

import com.bookstore.model.dao.user.User;
import com.bookstore.model.dao.user.UserDao;
import com.bookstore.model.dao.user.UserDaoImpl;

public class Main {

	
	//add 
	UserDao dao=new UserDaoImpl();
	
	Book book=new Book("A12", "java", "john", 900.0);
	dao.add(book);
	//update price
//	dao.update(6, 4000);
//	System.out.println("done");
	
	//del book
//	dao.delete(10);
	
	
}

