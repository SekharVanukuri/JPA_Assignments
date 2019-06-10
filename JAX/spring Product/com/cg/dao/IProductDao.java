package com.cg.dao;

import java.util.List;

import com.cg.beans.Product;
import com.cg.beans.ProductV1;
 

 

public interface IProductDao {
	public List<Product> getAllProducts();
	public List<ProductV1>getAllProductV1();
	public Product addProduct(Product product);
	public Product updateProduct(Product product);
	public Product deleteProduct(int id);
	public Product getProduct(int id);
}
