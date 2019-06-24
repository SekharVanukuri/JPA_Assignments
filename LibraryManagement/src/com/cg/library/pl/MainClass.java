package com.cg.library.pl;


import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.cg.library.dto.Book;
import com.cg.library.dto.Student;
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
			System.out.println("Enter Student ID");
			String studentId=sc.next();
			
			try {
				boolean Id=service.searchByStudentId(studentId);
				if(Id) {
					
			do
			{
				System.out.println("1-Add Book to studentAccount");
				System.out.println("2-Remove Book from studentAccount");
				System.out.println("3-Search By Book Id in library");
				System.out.println("4-Search issued Books to student");
				System.out.println("5- Update Book record into studentAccount ");
				System.out.println("6- Book issue date");
				System.out.println("7- Book return date");
				System.out.println("Enter your choice::");
				choice = sc.nextInt();
				switch(choice)
				{
					case 1 : 
						
						Book student = acceptBookDetails(); 
						student.setStudentId(studentId);
						
					if(student!=null){	
					try
					{
						int id = service.addBook(student);
						System.out.println("record inserted and id = "+id);
						
					}
					catch(BookException e)
					{
						System.out.println(e.getMessage());
					}}
					break;
					case 2: System.out.println("Enter Book  id to remove from studentAccount::");
					int id = sc.nextInt();
					try
					{
						Book student1 = service.removeBook(id);
						System.out.println("Book has been removed from account "+student1);
					}
					catch(BookException e)
					{
						System.out.println(e.getMessage());
					}
					break;
					
					case 3 : System.out.println("Enter id to search Book in library:");
					int bId = sc.nextInt();
					try
					{
						Book ref = service.getBookById(bId);
						System.out.println("Book Details:: "+ref);
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
					int bId1 = sc.nextInt();
					System.out.println("Enter new price amount of book:");
					int amount = sc.nextInt();
					try{
						Book eObj = service.updateBook(bId1, amount);
						System.out.println("records has been updated = "+eObj);
					}
					catch(BookException e)
					{
						System.out.println(e.getMessage());
					}
					break;
					//case 6: System.out.println("Enter Book issue Date::");
					
				}
				System.out.println("do you want to continue 1-yes   0-No");
				choice = sc.nextInt();
			}while(choice!=0);
		}else
			System.out.println("StudentId not pressent please create ");
		}
			catch (Exception e) {
				System.out.println("please enter proper studentId/create studentId ");
				System.out.println("create new  studentLogin::");
				String createId=sc.next();
				try {
				String create=service.insertNewLogin(createId);
				if(create!=null)
				System.out.println("new student succesfully created");
				}catch (Exception e1) {
					// TODO: handle exception
					System.out.println("Please try again");
				}
				
			}
		}

		
	}
	
	
	public static Book acceptBookDetails() throws ParseException
	{
		Book emp = null;
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			System.out.println("Enter Book name to add in StudentAccount:");
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
					/*
					 * System.out.println("Enter issue date"); SimpleDateFormat sdf = new
					 * SimpleDateFormat("d-MMM-yyyy"); String issued=sc.nextLine(); Date
					 * issueDate=sdf.parse(issued);
					 */
					
									
									
					
								
					        emp = new Book();
							emp.setbName(name);
							emp.setbAuthor(author);
							emp.setbPage(page);
							emp.setbPrice(price);
							//emp.setIssueDate((java.sql.Date) issueDate);
							break;
						}
					}
				
			
			return emp;
			}
				}
				
				}
			
		
	
		

