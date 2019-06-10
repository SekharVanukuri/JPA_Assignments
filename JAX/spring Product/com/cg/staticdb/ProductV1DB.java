package com.cg.staticdb;

import java.util.HashMap;


import com.cg.beans.ProductV1;

public class ProductV1DB {
static HashMap<Integer, ProductV1> productV1IdMap = getProductV1IdMap();
	
	static {
		if (productV1IdMap == null) {
			productV1IdMap = new HashMap<Integer, ProductV1>();
			ProductV1 indiaProduct = new ProductV1(1, "Pen");
			ProductV1 chinaProduct = new ProductV1(4, "Pencil");
			 
			productV1IdMap.put(1, indiaProduct);
			productV1IdMap.put(4, chinaProduct);
			 
		}
}
	public static HashMap<Integer, ProductV1> getProductV1IdMap() {
		return productV1IdMap;
	}

}