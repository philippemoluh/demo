package com.hellospring.Dao;

import java.util.List;

import com.hellospring.model.Product;

public interface ProductDao {
	
	void addProduct(Product product);
	
	Product getProductById(String id);
	
	List<Product> getAllProducts();
	
    void deleteProduct(String id);
}
