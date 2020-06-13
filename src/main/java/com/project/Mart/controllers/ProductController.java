package com.project.Mart.controllers;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.Mart.models.Products;
import com.project.Mart.services.ProductServicesImpl;

@RestController
@RequestMapping("/api/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
	@Autowired
	ProductServicesImpl productServices;
	
	@RequestMapping("/getAll")
	public List<Products> getAllProducts(){
		return productServices.getAllProducts();
	}
	
	@GetMapping("/search/{searchText}")
	public List<Products> getSearchedProduct(@PathVariable("searchText") String searchText){
		return productServices.findAll(searchText);
	}
	
	@GetMapping( value = "/getimage/{img_name}",produces = MediaType.IMAGE_JPEG_VALUE)
	public @ResponseBody byte[] getImageWithMediaType(@PathVariable("img_name") String img_name) throws IOException {
	    InputStream in = getClass().getResourceAsStream("/images/"+img_name);
	    return IOUtils.toByteArray(in);
	}
}