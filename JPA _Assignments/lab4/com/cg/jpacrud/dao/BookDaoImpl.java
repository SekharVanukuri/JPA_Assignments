package com.cg.jpacrud.dao;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.jpacrud.entities.Author;
import com.cg.jpacrud.entities.Book;

public class BookDaoImpl implements BookDao {

	private EntityManager entityManager;

	public BookDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

	@Override
	public Book getBookById(int id) {
		Book book = entityManager.find(Book.class, id);
		return book;
	}

	

	@Override
	public Long getBookCount() {
		String qStr = "SELECT COUNT(book.id) FROM Book book";
		TypedQuery<Long> query = entityManager.createQuery(qStr, Long.class);
		Long count = query.getSingleResult();
		return count;
	}

	@Override
	public Set<Book> getAuthorBooks(String authorName) {
		HashSet<Book> books = new HashSet<Book>();
		String qStr = "SELECT author FROM Author author WHERE author.name=:pAuthor";
		TypedQuery<Author> query = entityManager
				.createQuery(qStr, Author.class);
		query.setParameter("pAuthor", authorName);
		// Author author = query.getSingleResult(); // for single author
		List<Author> authors = query.getResultList();
		for (Author author : authors) {
			for (Book book : author.getBooks()) {
				books.add(book);
			}
		}
		return books;
	}

	@Override
	public List<Book> getAllBooks() {
		Query query = entityManager.createNamedQuery("getAllBooks");
		@SuppressWarnings("unchecked")
		List<Book> bookList = query.getResultList();
		return bookList;
	}

	@Override
	public List<Book> getBooksInPriceRange(double low, double high) {
		String qStr = "SELECT book FROM Book book WHERE book.price between :low and :high";
		TypedQuery<Book> query = entityManager.createQuery(qStr, Book.class);
		query.setParameter("low", low);
		query.setParameter("high", high);
		List<Book> bookList = query.getResultList();
		return bookList;
	}

}
