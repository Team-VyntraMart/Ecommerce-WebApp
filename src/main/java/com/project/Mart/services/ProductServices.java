package com.project.Mart.services;

import java.util.List;

import com.project.Mart.models.Category;
import com.project.Mart.models.Products;

public interface ProductServices {
	
	List<Products>addProducts(String name,long category_id,double price) throws Exception;
	List<Products>getAllProducts();
	List<Products>getProductsByCategory(Long product_id);
	List<Products>removeProductByCategoryIdAndProductId(Long product_id,Long category_id);
	
	List<Category>addCategories(String name);
	List<Category>getAllCategory();
	Products getProductsById(long productId) throws Exception;
}
