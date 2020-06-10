package com.project.Mart.repositories;

import java.util.List;

import javax.transaction.Transactional;

import com.project.Mart.models.Products;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
	
	@Query("Select pro FROM Products pro WHERE pro.category_id=:cat_id")
	List<Products> getByCategoryId(@Param("cat_id")Long cat_id);
	
	@Modifying
    @Transactional
	@Query("DELETE  FROM Products pro WHERE pro.id =:product_id and pro.category_id=:cat_id")
	void deleteProductByIdAndCategoryId(@Param("product_id")Long product_id,@Param("cat_id")Long cat_id);
}
