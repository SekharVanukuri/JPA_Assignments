package com.cg.jpacrud.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Author_master")
public class Author implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	private String name;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = " Book_Author", joinColumns = { @JoinColumn(name = "Author_id") }, inverseJoinColumns = { @JoinColumn(name = "Book_id") })
	private Set<Book> books = new HashSet<>(); // required to avoid
												// NullPointerException

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Book> getBooks() {
		return books;
	}

	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void addBook(Book Book) {
		this.getBooks().add(Book);
	}

	@Override
	public String toString() {
		return "Author [id=" + id + ", name=" + name + "]";
	}

}
