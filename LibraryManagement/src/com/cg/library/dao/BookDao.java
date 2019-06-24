package com.cg.library.dao;

import java.util.ArrayList;

import com.cg.library.dto.Book;
import com.cg.library.dto.Student;
import com.cg.library.exception.BookException;

public interface BookDao {
	int addBook(Book emp)throws BookException;
	Book removeBook(int empId)throws BookException;
	Book getBookById(int empId)throws BookException;
	ArrayList<Book>getAllBook()throws BookException;
	Book updateBook(int pId,int pBill)throws BookException;
	boolean searchByStudentId(String studentId);
	String insertNewLogin(String createId);

}
