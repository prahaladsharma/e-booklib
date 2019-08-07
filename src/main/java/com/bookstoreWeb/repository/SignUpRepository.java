package com.bookstoreWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstoreWeb.model.SignUpModel;

@Repository
public interface SignUpRepository extends JpaRepository<SignUpModel, Long> {

}
