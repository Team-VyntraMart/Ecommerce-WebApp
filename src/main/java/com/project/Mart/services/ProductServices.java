package com.project.Mart.services;

import java.util.List;

import com.project.Mart.models.Products;

public interface ProductServices {
	
	List<Products>addProducts(String name,double price,String image) throws Exception;
	List<Products>getAllProducts();
	void deleteByProductId(Long id);
	Products getProductsById(long productId) throws Exception;
	List<Products> findAll(String searchText);
}
