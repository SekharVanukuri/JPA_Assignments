package com.cg.jpacrud.client;

import com.cg.jpacrud.entites.Author;
import com.cg.jpacrud.service.AuthorService;
import com.cg.jpacrud.service.AuthorServiceImpl;

public class client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

AuthorService service = new AuthorServiceImpl();
		
		Author author = new Author();
		author.setAuthorId(100);
		author.setFirstName("veera");
		author.setMiddleName("sekhar");
		author.setLastName("reddy");
		author.setPhoneno("8790336533");
		service.addAuthor(author);
		
		//at this breakpoint, we have added one record to table
		author = service.findAuthorById(100);
		System.out.print("ID:"+author.getAuthorId());
		System.out.println(" Name:"+author.getFirstName());
		System.out.println("middlename:"+author.getMiddleName());
		System.out.println("lastname:"+author.getLastName());
		
		author.setFirstName("vanukuri");
		service.updateAuthor(author);
		
		//at this breakpoint, we have updated record added in first section
		author = service.findAuthorById(100);
		System.out.print("ID:"+author.getAuthorId());
		System.out.println(" Name:"+author.getFirstName());
		System.out.println(" lastName:"+author.getLastName());
		System.out.println(" middle Name:"+author.getMiddleName());
		//at this breakpoint, record is removed from table
		service.removeAuthor(author);
		System.out.println("End of program...");
	}
}
