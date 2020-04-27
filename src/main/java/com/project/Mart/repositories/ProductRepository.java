package com.project.Mart.repositories;

import java.util.List;

import com.project.Mart.models.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
	
	@Query("Select pro FROM Products pro WHERE pro.category_id=:cat_id")
	List<Products> getByCategoryId(@Param("cat_id")String cat_id);
}
