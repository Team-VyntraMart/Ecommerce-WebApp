package com.project.Mart.repositories;


import org.springframework.data.jpa.repository.JpaRepository;

import com.project.Mart.models.CategoryModel;

public interface CategoryRepository  extends JpaRepository<CategoryModel, Long> {

}
