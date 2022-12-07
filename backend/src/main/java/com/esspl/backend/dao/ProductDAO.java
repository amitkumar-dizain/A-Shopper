package com.esspl.backend.dao;

import java.util.List;

import com.esspl.backend.model.Product;

public interface ProductDAO {

	List<Product> list();
	Product get(int Productid);
	public boolean add(Product product);
	public boolean update(Product product);
	public boolean delete(Product product);
	
	//Raw Business Logic 
		//listOfProductByCategory,listofactiveproduct,recentactiveproduct
	
		List<Product> listActiveProducts();
		List<Product> listActiveProductByCategory(int categoryId);
		List<Product> getLatestActiveProduct(int count);

	
}
