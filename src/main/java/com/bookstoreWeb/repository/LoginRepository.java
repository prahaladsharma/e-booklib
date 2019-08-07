package com.bookstoreWeb.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bookstoreWeb.model.SignUpModel;

@Repository
public interface LoginRepository extends JpaRepository<SignUpModel, Long> {
	
	@Query("SELECT v FROM com.bookstoreWeb.model.SignUpModel v where v.email = :email and v.password = :password")
    List<SignUpModel> getLoginResponse(@Param("email") String email, @Param("password") String password);
}
