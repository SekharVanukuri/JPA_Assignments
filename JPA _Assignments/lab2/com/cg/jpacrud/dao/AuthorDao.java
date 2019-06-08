package com.cg.jpacrud.dao;

import com.cg.jpacrud.entites.Author;



public interface AuthorDao {

	
	public abstract Author getAuthorById(int id);

	public abstract void addAuthor(Author author);

	public abstract void removeAuthor(Author author);

	public abstract void updateAuthor(Author author);

	public abstract void commitTransaction();

	public abstract void beginTransaction();

}
