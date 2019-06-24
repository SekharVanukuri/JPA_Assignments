package com.cg.library.service;
import java.util.ArrayList;
import java.util.regex.Pattern;

import com.cg.library.dao.BookDao;
import com.cg.library.dao.BookDaoImpl;
import com.cg.library.dto.Book;
import com.cg.library.dto.Student;
import com.cg.library.exception.BookException;

public class BookServiceImpl implements BookService {

	BookDao dao;
	
	public void setDao(BookDao dao)
	{
		this.dao = dao;
	}
	
	public BookServiceImpl()
	{
		dao = new BookDaoImpl();
	}
	
	@Override
	public String insertNewLogin(String createId) {
		// TODO Auto-generated method stub
		
		
		return dao.insertNewLogin(createId);
	}
	@Override
	public boolean searchByStudentId(String studentId) {
		// TODO Auto-generated method stub
		return dao.searchByStudentId(studentId);
	}

	@Override
	public int addBook(Book emp) throws BookException {
		// TODO Auto-generated method stub
		return dao.addBook(emp);
	}

	@Override
	public Book removeBook(int empId) throws BookException {
		// TODO Auto-generated method stub
		return dao.removeBook(empId);
	}

	@Override
	public Book getBookById(int bId) throws BookException {
		// TODO Auto-generated method stub
		return dao.getBookById(bId);
	}

	@Override
	public ArrayList<Book> getAllBook() throws BookException {
		// TODO Auto-generated method stub
		return dao.getAllBook();
	}

	@Override
	public Book updateBook(int bId, int amount)
			throws BookException {
		// TODO Auto-generated method stub
		return dao.updateBook(bId, amount);
	}

	
	
	public boolean validateName(String name)
	{
		String pattern = "[A-z]{1}[a-z]{2,}";
		if(Pattern.matches(pattern,name))
		{
			return true;
		}
		else
			return false;
	}
	public boolean validateSalary(int salary)
	{
		String pattern = "[0-9]{4,6}";
		String sal = ""+salary;
		if(Pattern.matches(pattern,sal))
		{
			return true;
		}
		else 
			return false;
	}

	@Override
	public boolean validateName(String name, String author) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
