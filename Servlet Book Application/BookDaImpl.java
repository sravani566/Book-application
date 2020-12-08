package com.bookstore.model.dao.book;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.model.dao.exceptions.DataAccessException;



public class BookDaoImpl implements BookDao{

	private Connection conn;
	List<Book> books;
	Book book;
	
	public BookDaoImpl() {
		conn = ConnectionFactory.getConnection();
		books = new ArrayList<>();
		book = new Book();
	}
	@Override
	public List<Book> getAll() {
		
		String all_books_query = " select * from books";
		
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(all_books_query);
			
			while(rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"),
						rs.getString("author"),  rs.getDouble("price"));
			
				books.add(book);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
		return books;
	}

	@Override
	public Book add(Book book) {
		String add_book_query =
				"insert into books(isbn, title, author,  price) values(?, ?, ?, ?)";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(add_book_query, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, book.getIsbn());
			pstmt.setString(2, book.getTitle());
			pstmt.setString(3, book.getAuthor());
			pstmt.setDouble(5, book.getPrice());
			
			int numOfRowsEffected = pstmt.executeUpdate();
			
			if(numOfRowsEffected > 0) {
				ResultSet rs = pstmt.getGeneratedKeys();
				rs.next();
				book.setId(rs.getInt(1));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
		
		
		return book;
	}

	@Override
	public Book delete(int bookId) {
		Book bookToBeDeleted = getById(bookId);
		String delete_book_query = "delete from books where id = ?";
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(delete_book_query);
			pstmt.setInt(1, bookId);
			pstmt.execute();
			
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
		
		return bookToBeDeleted;
	}

	@Override
	public Book update(int id, double price) {
		Book bookToBeUpdated = getById(id);
		String add_book_query =
				"update books set price = ? where id = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(add_book_query);
			
			pstmt.setDouble(1, price);
			pstmt.setInt(2, id);
			pstmt.executeUpdate();
			 
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bookToBeUpdated.setPrice(price);
		return bookToBeUpdated;
	}

	@Override
	public Book getById(int bookId) {
		String get_book_by_id = "select * from books where id = ?";
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(get_book_by_id);
			pstmt.setInt(1, bookId);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"),
						rs.getString("author"), rs.getDouble("price"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
		
		return book;
	}
	@Override
	public Book getBookByIsbn(String isbn) {
	String get_book_by_id = "slect * from books where isbn = ?";
		
		PreparedStatement pstmt;
		try {
			pstmt = conn.prepareStatement(get_book_by_id);
			pstmt.setString(1, isbn);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				book = new Book(rs.getInt("id"), rs.getString("isbn"), rs.getString("title"),
						rs.getString("author"), rs.getDouble("price"));
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DataAccessException(e.getMessage());
		}
		return book;
	}

}

