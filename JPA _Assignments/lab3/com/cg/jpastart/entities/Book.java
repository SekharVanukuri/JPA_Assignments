package com.cg.jpastart.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

 
@Entity
@Table(name="Book_master")
public class Book  implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int id;
	
	private String tittle;
	private double price;
	 
		@ManyToMany(fetch=FetchType.LAZY,mappedBy="books")
		private Set<Author> Authors = new HashSet<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Set<Author> getAuthors() {
		return Authors;
	}

	public void setAuthors(Set<Author> authors) {
		Authors = authors;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
