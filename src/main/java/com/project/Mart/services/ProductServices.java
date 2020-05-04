package com.project.Mart.services;

import java.util.List;

import com.project.Mart.models.Category;
import com.project.Mart.models.Products;

public interface ProductServices {
	
	List<Products> addProducts(String name,String category_id,double price) throws Exception;
	List<Products>getAllProducts();
	List<Products>getProductsByCategory(String product_id);
	List<Category>addCategories(String name);
	List<Category>getAllCategory();
	Products getProductsById(long productId) throws Exception;
}
