package com.cg.jpacrud.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "Book_master")
@NamedQueries(@NamedQuery(name = "getAllBooks", query = "SELECT book FROM Book book"))
public class Book implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	private int id;

	private String tittle;
	private double price;

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "books")
	private Set<Author> authors = new HashSet<>();

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
		return authors;
	}

	public void setAuthors(Set<Author> authors) {
		this.authors = authors;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Book [id=" + id + ", tittle=" + tittle + ", price=" + price
				+ ", authors=" + authors + "]";
	}

}
