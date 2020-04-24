package com.project.Mart.repositories;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.Mart.models.UserModel;

@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
	Optional<UserModel> findByMobile(String mobile);
}