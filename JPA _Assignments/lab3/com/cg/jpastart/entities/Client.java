package com.cg.jpastart.entities;

 

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		EntityManagerFactory factory = Persistence
				.createEntityManagerFactory("JPA-PU");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		// first define few products before we place order

		Book  Book1= new Book();
		Book1.setId(1);
		Book1.setTittle("Html");
		Book1.setPrice(5000);

		Book Book2 = new Book();
		Book2.setId(2);
		Book2.setTittle("Java");
		Book2.setPrice(3000);

		Book Book3 = new Book();
		Book3.setId(3);
		Book3.setTittle("xml");
		Book3.setPrice(8000);

		Book Book4 = new Book();
		Book4.setId(4);
		Book4.setTittle("Sql");
		Book4.setPrice(6000);


		// now define first order and add few products in it
		Author firstAuthor = new Author();
		firstAuthor.setId(1000);
		firstAuthor.setName("Sekhar");

		firstAuthor.addBook(Book3);
		firstAuthor.addBook(Book2);
		firstAuthor.addBook(Book1);

		// now define second order and add few products in it
		Author secondAuthor = new Author();
		secondAuthor.setId(1001);
		secondAuthor.setName("Shiva");

		secondAuthor.addBook(Book3);		
		secondAuthor.addBook(Book2);
		secondAuthor.addBook(Book1);

		// save orders using entity manager

		em.persist(firstAuthor);
		em.persist(secondAuthor);
		
		System.out.println("Added Authors along with Author details to database.");

		em.getTransaction().commit();
		em.close();
		factory.close();
		

	}

}
