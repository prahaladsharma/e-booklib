package com.bookstoreWeb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bookstoreWeb.model.UploadFile;

@Repository
public interface FileUploadRepository extends JpaRepository<UploadFile, Long> {

}
