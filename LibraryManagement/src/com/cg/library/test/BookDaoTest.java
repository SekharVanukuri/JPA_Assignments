package com.cg.library.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.cg.library.dao.BookDao;
import com.cg.library.dao.BookDaoImpl;
import com.cg.library.dto.Book;
import com.cg.library.exception.BookException;
import com.cg.library.service.BookServiceImpl;

public class BookDaoTest {

	BookServiceImpl service;
	BookDao dao;
	
	@Before
	public void init()
	{
		dao = new BookDaoImpl();
		service  = new BookServiceImpl();
		service.setDao(dao);
	}
	@Test
	public void testGetAllBook() throws BookException
	{
		ArrayList<Book>list = service.getAllBook();
		assertNotNull(list);
	}
	@Test
	public void testAddBook() throws BookException
	{
		Book emp = new Book();
		emp.setbId(12);
		emp.setbName("kuldeep");
		emp.setbPrice(458248124);
		emp.setbPage(458);
		emp.setbAuthor("kuyde");
		int id = service.addBook(emp);
		assertNotSame(id,0);
	}
	@Test
	public void testDeleteBook() throws BookException
	{
		Book emp = service.removeBook(2025);
		assertNotNull(emp);
	}
	@Test
	public void updateBook() throws BookException
	{
		Book emp = service.updateBook(2026, 100);
		assertNotNull(emp);
	}
	@After
	public void destroy()
	{
		dao = null;
		service = null;
	}
}
