package com.bookstore.model.dao.user;

import java.util.*;
import java.sql.*;
import java.util.*;
import com.bookstore.model.dao.exceptions.*;
import com.bookstore.model.dao.book.*;

public class UserDaoImpl implements UserDao {

	private Connection connection;

	public UserDaoImpl() {
		connection = ConnectionFactory.getConnection();
	}

	@Override
	public void addUser(User user) {
		// id | username | password | profile
		String add_book = "insert into users(username, password, profile) values (?,?,?)";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(add_book);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getPassword());
			pstmt.setString(3, user.getProfile());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
	}

	@Override
	public User getUser(String username, String password) {
		User user = null;
		String get_user = "select * from users where username=? and password=?";
		PreparedStatement pstmt;
		try {
			pstmt = connection.prepareStatement(get_user);
			pstmt.setString(1, username);
			pstmt.setString(2, password);

			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				user = new User(rs.getInt("id"), username, password, rs.getString("profile"));
				// user = new User(username, password, rs.getString("prfile"));
			} else {
				throw new UserNotFoundException("user with username " + username + " is not found");
			}

		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
		return user;

	}

}
