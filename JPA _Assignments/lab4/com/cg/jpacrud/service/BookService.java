package com.cg.jpacrud.service;

import java.util.List;
import java.util.Set;

import com.cg.jpacrud.entities.Book;

public interface BookService {

	public abstract Book getBookById(int id);

	
	public abstract Long getBookCount();

	public abstract Set<Book> getAuthorBooks(String author);

	public abstract List<Book> getAllBooks();

	public abstract List<Book> getBooksInPriceRange(double low, double high);

}