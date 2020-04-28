package com.project.Mart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.project.Mart.models.Category;

public interface CategoryRepository  extends JpaRepository<Category, Long> {

}
