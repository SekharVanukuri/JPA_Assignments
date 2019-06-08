package com.cg.jpacrud.client;

import com.cg.jpacrud.entities.Book;
import com.cg.jpacrud.service.BookService;
import com.cg.jpacrud.service.BookServiceImpl;

public class Client {

	public static void main(String[] args) {

		BookService service = new BookServiceImpl();

		 System.out
		 .println("************Listing total number of books*************");
		 System.out.println("Total books:" + service.getBookCount());
		
		 System.out
		 .println("************Listing book with id 1001*************");
		 System.out.println("Boo with ID 106:" + service.getBookById(1001));
		
		 System.out.println("************Listing All books*************");
		 for (Book book : service.getAllBooks()) {
		 System.out.println(book);
		 }

		System.out
				.println("************Listing book written by Sekhar*************");
		for (Book book : service.getAuthorBooks("Sekhar")) {
			System.out.println(book);
		}

		 System.out.println("************Listing book on id1*************");
		
		 System.out.println(service.getBookById(12));
		
		
		 System.out
		 .println("************Listing All books between 500 and 600*************");
		 for (Book book : service.getBooksInPriceRange(1000, 5000)) {
		 System.out.println(book);
		 }

	}
}
