package com.project.Mart.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.project.Mart.models.CheckoutCartModel;


@Repository
public interface CheckoutRepository extends JpaRepository<CheckoutCartModel, Long> {
	@Query("Select checkCart  FROM CheckoutCart checkCart WHERE checkCart.user_id=:user_id")
	List<CheckoutCartModel> getByuserId(@Param("user_id")Long user_id);
}