package com.cg.webservice;

import javax.jws.WebService;
@WebService(endpointInterface = "com.cg.webservice.ProductServer")
public class Product {
	public static String searchByName(String name){
	if (name.equals("Laptop"))
		return "price is 45000.0";
	else
		return "Product does not exist";
	
	}

}
	
	 

