package com.bookstoreWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstoreWeb.model.AddBookModel;

@Repository
public interface AddBookRepository extends JpaRepository<AddBookModel, Long> {

}
