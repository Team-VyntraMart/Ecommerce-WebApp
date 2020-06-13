package com.project.Mart.repositories;

import com.project.Mart.models.Products;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface ProductRepository extends JpaRepository<Products, Long> {
	
	@Query("From Products pro WHERE pro.name=:searchText")
	List<Products> findProduct(@Param("searchText") String searchText);
}
