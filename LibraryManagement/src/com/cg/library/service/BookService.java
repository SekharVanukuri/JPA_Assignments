package com.cg.library.service;

import java.util.ArrayList;

import com.cg.library.dto.Book;
import com.cg.library.exception.BookException;

public interface BookService {
	int addBook(Book emp)throws BookException;
	Book removeBook(int empId)throws BookException;
	Book getBookById(int empId)throws BookException;
	ArrayList<Book>getAllBook()throws BookException;
	Book updateBook(int pId,int pBill)throws BookException;
	boolean validateSalary(int price);
	boolean validateName(String author);
	boolean validateName(String name, String author);
}
