package com.cg.beans;

public class ProductV1 {
   private   int id;
   public int getId() {
	return id;
}
   
public ProductV1(int id, String name) {
	super();
	this.id = id;
	this.name = name;
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
private String name;
@Override
public String toString() {
	return "ProductV1 [id=" + id + ", name=" + name + "]";
}
}
