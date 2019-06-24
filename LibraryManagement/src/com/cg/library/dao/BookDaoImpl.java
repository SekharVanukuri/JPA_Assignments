package com.cg.library.dao;



import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;

import org.apache.log4j.Logger;

import com.cg.library.dto.Book;
import com.cg.library.dto.Student;
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
	
	@Override
	public String insertNewLogin(String createId) {
		// TODO Auto-generated method stub
		logger.info("In Add Book");
		logger.info("Input is "+ createId);
		
		String query = "INSERT INTO StudentDetails VALUES(?)";
		try
		{
			PreparedStatement pstmt = 
					con.prepareStatement(query);
			pstmt.setString(1, createId);
			int row = pstmt.executeUpdate();
			if(row > 0)
			{
				
				logger.info("Inserted successfully and Id is = "+createId);
			}
			else
				throw new BookException("unable to insert"+createId);
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println("Please try again");
		}
		return createId;
	}

	@Override
	public boolean searchByStudentId(String studentId) {
		logger.info("enterd studentId is"+studentId);
		boolean studentIdNo=false;
		String qry="SELECT * From StudentDetails where studentId=?";
		try {
			Statement stmt = con.createStatement();
			PreparedStatement pstm=con.prepareStatement(qry);
			pstm.setString(1, studentId);
			ResultSet rs1=pstm.executeQuery();
			boolean rs = stmt.execute(qry);
			if(rs)
			{
				studentIdNo=true;
				logger.info("Successfully enter through StudentId"+studentId);
			}
			else {
				logger.info("In Add Book");
				logger.info("Input is "+ studentId);
				
				String query = "INSERT INTO StudentDetails VALUES(?)";
				try
				{
					PreparedStatement pstmt = 
							con.prepareStatement(query);
					pstmt.setString(1, studentId);
					int row = pstmt.executeUpdate();
					if(row > 0)
					{
						
						logger.info("Inserted successfully and Id is = "+studentId);
					}
					else
						throw new BookException("unable to insert"+studentId);
				}catch (Exception e) {
					// TODO: handle exception
					System.out.println("Please trry again");
				}
				
			}
		}catch (SQLException e) {
			// TODO: handle exception
			System.out.println("Please chec k with correct  details");
		}
		return studentIdNo;
	}

	public int getBookId()throws BookException
	{
		logger.info("In getBookId");
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
	public int addBook(Book student) throws BookException {
		// TODO Auto-generated method stub
		logger.info("In Add Book");
		logger.info("Input is "+student);
		int id = 0;
		String qry = "INSERT INTO BookJEE VALUES(bId_seq.NEXTVAL,?,?,?,?,SYSDATE,?)";

		String name = student.getbName();
		String author = student.getbAuthor();
		int page = student.getbPage();
		int price=student.getbPrice();
		String studentId=student.getStudentId();
		//Date issueDate=student.getIssueDate();
		//Date returnDate=student.getReturnDate();
		
		try
		{
			PreparedStatement pstmt = 
					con.prepareStatement(qry);
			pstmt.setString(1, name);
			pstmt.setString(2,author);
			pstmt.setInt(3, page);
			pstmt.setInt(4, price);
			pstmt.setString(5, studentId);
		//	pstmt.setDate(5, issueDate);
			//pstmt.setDate(6, returnDate);
			int row = pstmt.executeUpdate();
			if(row > 0)
			{
				id = getBookId();
				logger.info("Inserted successfully and Id is = "+id);
			}
			else
				throw new BookException("unable to insert"+student);
			
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
				throw new BookException("book-id "+bId+"not found");
			}
			else if(row > 0)
			{
				System.out.println("Deleted book from account  with Id "+bId);
				
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
				Date issueDate=rs.getDate(6);
				Date returnDate=rs.getDate(7);
				String studentId=rs.getString(8);
				
			
				emp = new Book(id,name,price,author,page,issueDate,returnDate,studentId);
			}
			else
				throw new BookException("Book-id "+bId+"not found");
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
			Date issueDate=rs.getDate(6);
			Date returnDate=rs.getDate(7);
			String studentId=rs.getString(8);
				
				Book emp = new Book(id,name,price,author,page,issueDate,returnDate,studentId);
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
	public Book updateBook(int bId, int  bPrice)throws BookException 
	{
		// TODO Auto-generated method stub
		Book emp = getBookById(bId);
		Date returnDate=null;
		if(emp==null)
			throw new BookException("Book-id "+bId+"Not found");
		else
		{
			String qry = "UPDATE BookJEE SET bPrice=?, returnDate=? WHERE bId=?";
			try{
				PreparedStatement pstmt = 
						con.prepareStatement(qry);
				pstmt.setInt(1, bPrice);
				pstmt.setInt(2, bId);
				pstmt.setDate(3, returnDate);
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
