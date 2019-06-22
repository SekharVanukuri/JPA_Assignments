package com.cg.library.pl;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

import com.cg.library.dto.Book;
import com.cg.library.exception.BookException;
import com.cg.library.service.BookService;
import com.cg.library.service.BookServiceImpl;


public class MainClass {
	static BookService service = new BookServiceImpl();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int choice = 0;
		try(Scanner sc = new Scanner(System.in))
		{
			do
			{
				System.out.println("1-Add Book in library");
				System.out.println("2-Remove Book from library");
				System.out.println("3-Search By Book Id in library");
				System.out.println("4-Search All Book in library");
				System.out.println("5- update Book record in library ");
				System.out.println("Enter your choice::");
				choice = sc.nextInt();
				switch(choice)
				{
					case 1 : 
						
						Book emp = acceptBookDetails(); 
					if(emp!=null){	
					try
					{
						int id = service.addBook(emp);
						System.out.println("record inserted and id = "+id);
					}
					catch(BookException e)
					{
						System.out.println(e.getMessage());
					}}
					break;
					case 2: System.out.println("Enter Book  id to remove from library::");
					int id = sc.nextInt();
					try
					{
						Book emp1 = service.removeBook(id);
						System.out.println("patient has been removed  "+emp1);
					}
					catch(BookException e)
					{
						System.out.println(e.getMessage());
					}
					break;
					
					case 3 : System.out.println("Enter id to search Book in library:");
					int eid = sc.nextInt();
					try
					{
						Book ref = service.getBookById(eid);
						System.out.println("emp "+ref);
					}
					catch(BookException e)
					{
						System.out.println(e.getMessage());
					}
					break;
					
					case 4 : 
						try
						{							
							ArrayList<Book>list = service.getAllBook();
						
							for(Book obj : list)
						{
							System.out.println(obj);
						}
						}
						catch(BookException e)
						{
							System.out.println(e.getMessage());
						}
						break;
					case 5: System.out.println("Enter id of Book to update  record::");
					int pId = sc.nextInt();
					System.out.println("Enter new price amount of book:");
					int bill = sc.nextInt();
					try{
						Book eObj = service.updateBook(pId, bill);
						System.out.println("records has been updated = "+eObj);
					}
					catch(BookException e)
					{
						System.out.println(e.getMessage());
					}
					break;
				}
				System.out.println("do you want to continue 1-yes   0-No");
				choice = sc.nextInt();
			}while(choice!=0);
		}

		
	}
	public static Book acceptBookDetails()
	{
		Book emp = null;
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter Book name to add in library:");
			String name = sc.next();
			if(!service.validateName(name))
			{
				continue;
			}
			else
			{
				while(true)
				{
					System.out.println("Enter Book author of book");
					String author = sc.next();
					
					if(!service.validateName(author))
					{
						continue;
					}
					
					
						System.out.println("Enter no of  pages  of book");
							int page = sc.nextInt();
							
						System.out.println("Enter price of book");
									int price = sc.nextInt();
									
									
					
								
					        emp = new Book();
							emp.setbName(name);
							emp.setbAuthor(author);
							emp.setbPage(page);
							emp.setbPrice(price);
							break;
						}
					}
				
			
			return emp;
			}
				}
				
				}
			
		
	
		

