package com.bookstoreWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstoreWeb.model.BookIssueModel;

@Repository
public interface BookIssueRepository extends JpaRepository<BookIssueModel, Long> {

}
