package com.project.Mart.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Mart.models.CategoryModel;
import com.project.Mart.models.ProductsModel;
import com.project.Mart.services.ProductService.ProductServices;

@RestController
@RequestMapping("api/product")
public class ProductController {
	@Autowired
	ProductServices ProductServices;
	
	@RequestMapping("getAll")
	public List<ProductsModel> getAllPRoducts(){
		return ProductServices.getAllProducts();
	}
	@RequestMapping("getAllCategory")
	public List<CategoryModel> getAllCategory(){
		return ProductServices.getAllCategory();
	}
	@RequestMapping("getProductsByCategory")
	public List<ProductsModel> getProductsByCategory(@RequestBody HashMap<String,String> request){
		String category_id = request.get("cat_id");		
		return ProductServices.getProductsByCategory(category_id);
	}
	
	
	
	@GetMapping( value = "/getimage/{img_name}",produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageWithMediaType(@PathVariable("img_name") String img_name) throws IOException {
	    InputStream in = getClass().getResourceAsStream("/images/"+img_name);
	    return IOUtils.toByteArray(in);
	}
}