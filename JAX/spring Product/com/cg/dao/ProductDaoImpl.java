package com.cg.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cg.beans.Product;
import com.cg.beans.ProductV1;
import com.cg.staticdb.ProductDB;
import com.cg.staticdb.ProductV1DB;

@Repository
public class ProductDaoImpl implements IProductDao {
	static HashMap<Integer, Product> productIdMap = ProductDB.getProductIdMap();
	static HashMap<Integer, ProductV1> productV1IdMap = ProductV1DB.getProductV1IdMap();
	
	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> Products = new ArrayList<Product>(productIdMap.values());
		return Products;
	}

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		productIdMap.put(product.getId(), product);
		return product;
	}

	@Override
	public Product updateProduct(Product product) {
		// TODO Auto-generated method stub
		if (product.getId() <= 0)
			return null;
		productIdMap.put(product.getId(), product);
		return product;
	}

	@Override
	public Product deleteProduct(int id) {
		// TODO Auto-generated method stub
		return productIdMap.remove(id);
	}

	@Override
	public Product getProduct(int id) {
		// TODO Auto-generated method stub
		Product product =productIdMap.get(id);
		return product;
	}

	@Override
	public List<ProductV1> getAllProductV1() {
		// TODO Auto-generated method stub
		List<ProductV1> ProductV1 = new ArrayList<ProductV1>(productV1IdMap.values());
		return ProductV1;
		
	}

}
