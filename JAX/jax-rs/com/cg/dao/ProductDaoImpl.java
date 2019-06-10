package com.cg.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.cg.beans.Product;
  
 
import com.cg.staticdb.ProductDB;
 

public class ProductDaoImpl implements IProductDao{
	static HashMap<Integer, Product> productIdMap = ProductDB.getProductIdMap();

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> Products = new ArrayList<Product>(productIdMap.values());
		return Products;
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		productIdMap.put(product.getId(),product);
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		if (product.getId() <=0)
		return null;
		productIdMap.put(product.getId(), product);
		return product;
	}

	 

	@Override
	public Product deleteProduct (int id) {
		// TODO Auto-generated method stub
		return productIdMap.remove(id);
	}

	

	 

}
