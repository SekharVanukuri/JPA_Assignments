package com.cg.library.dao;



import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cg.library.dto.Book;
import com.cg.library.exception.BookException;
import com.cg.library.logger.MyLogger;
import com.cg.library.util.DBUtil;




public class BookDaoImpl implements BookDao{

	Connection con;
	Logger logger;
	
	
	public BookDaoImpl()
	{
		con = DBUtil.getConnect();
		logger = MyLogger.getLogger();
	}

	public int getBookId()throws BookException
	{
		logger.info("In getHospitalId");
		int id = 0;
		String qry = "SELECT bId_seq.CURRVAL FROM DUAL";
			try{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			if(rs.next())
			{
				id = rs.getInt(1);
				logger.info("Got Book With Id"+id);
			}
			}
			catch(SQLException e)
			{
				logger.error("Error"+e.getMessage());
				throw new BookException(e.getMessage());
			}
			logger.info("Completed getBookId");
			return id;
		
	}
	@Override
	public int addBook(Book emp) throws BookException {
		// TODO Auto-generated method stub
		logger.info("In Add Book");
		logger.info("Input is "+emp);
		int id = 0;
		String qry = "INSERT INTO BookJEE VALUES(bId_seq.NEXTVAL,?,?,?,?)";

		String name = emp.getbName();
		String author = emp.getbAuthor();
		int page = emp.getbPage();
		int price=emp.getbPrice();
		
		
		try
		{
			PreparedStatement pstmt = 
					con.prepareStatement(qry);
			pstmt.setString(1, name);
			pstmt.setString(2,author);
			pstmt.setInt(3, page);
			pstmt.setInt(4, price);
			
			int row = pstmt.executeUpdate();
			if(row > 0)
			{
				id = getBookId();
				logger.info("Inserted successfully and Id is = "+id);
			}
			else
				throw new BookException("unable to insert"+emp);
			
		}
		catch(SQLException e)
		{
			logger.error("Error in insert = "+e.getMessage());
			throw new BookException(e.getMessage());
		}
		return id;
		
		
		
		
		
	}

	
	

	@Override
	public Book removeBook(int bId) throws BookException {
		// TODO Auto-generated method stub
		Book emp = null;
		String qry = "DELETE FROM BookJEE WHERE bId=?";
		try
		{
			PreparedStatement pstmt = 
					con.prepareStatement(qry);
			pstmt.setInt(1, bId);
			emp = getBookById(bId);
			int row = pstmt.executeUpdate();
			if(emp==null)
			{
				throw new BookException("emp with id "+bId+"not found");
			}
			else if(row > 0)
			{
				System.out.println("Deleted Employee with Id "+bId);
				
			}
			
		}
		catch(SQLException e)
		{
			throw new BookException(e.getMessage());
		}
		return emp;
	}

	@Override
	public Book getBookById(int bId) throws BookException {
		// TODO Auto-generated method stub
		Book emp = null;
		String qry = "SELECT * FROM BookJEE WHERE bId=?";
		try
		{
			PreparedStatement pstmt = 
					con.prepareStatement(qry);
			pstmt.setInt(1, bId);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next())
			{
				
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String author = rs.getString(3);
				int page = rs.getInt(4);
				int price=rs.getInt(5);
				
			
				emp = new Book(id,name,price,author,page);
			}
			else
				throw new BookException("Book with id "+bId+"not found");
		}
		catch(SQLException e)
		{
			throw new BookException(e.getMessage());
		}
		return emp;
	}

	@Override
	public ArrayList<Book> getAllBook() throws BookException {
		// TODO Auto-generated method stub
		ArrayList<Book>list = new ArrayList<Book>();
		String qry = "SELECT * FROM BookJEE";
		try
		{
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(qry);
			while(rs.next())
			{
				int id = rs.getInt(1);
			String name = rs.getString(2);
			String author = rs.getString(3);
			int page = rs.getInt(4);
			int price=rs.getInt(5);
			
				
				Book emp = new Book(id,name,price,author,page);
				list.add(emp);
			}
		}
		catch(SQLException e)
		{
			throw new BookException(e.getMessage());
		}
		return list;
	}

	@Override
	public Book updateBook(int bId, int bPrice)throws BookException 
	{
		// TODO Auto-generated method stub
		Book emp = getBookById(bId);
		if(emp==null)
			throw new BookException("Book with id "+bId+"Not found");
		else
		{
			String qry = "UPDATE BookJEE SET bPrice=? WHERE bId=?";
			try{
				PreparedStatement pstmt = 
						con.prepareStatement(qry);
				pstmt.setInt(1, bPrice);
				pstmt.setInt(2, bId);
				int row = pstmt.executeUpdate();
				if(row > 0)
				{
					System.out.println("updated successfully");
					emp = getBookById(bId);
				}      
			}
			catch(SQLException e)
			{
				throw new BookException(e.getMessage());
			}
			
		}
		return emp;
	}


}
