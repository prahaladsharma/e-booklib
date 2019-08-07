package com.bookstoreWeb.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "bookissue")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"createdAt","updatedAt"}, allowGetters = true)
public class BookIssueModel {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@NotBlank
	private String bookName;
	
	@NotNull
	private int bookId;
	
	@NotNull
	private int userId;
	
	@NotBlank
	private String bookIssueDate;
	
	@NotBlank
	private String bookSubmitDate;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date createdAt;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updatedAt;
	

	
	/**
	 * 
	 */
	public BookIssueModel() {
		super();
	}




	/**
	 * @param bookName
	 * @param bookId
	 * @param userId
	 * @param bookIssueDate
	 * @param bookSubmitDate
	 * @param createdAt
	 * @param updatedAt
	 */
	public BookIssueModel(@NotBlank String bookName, @NotBlank int bookId, @NotBlank int userId,
			@NotBlank String bookIssueDate, @NotBlank String bookSubmitDate) {
		super();
		this.bookName = bookName;
		this.bookId = bookId;
		this.userId = userId;
		this.bookIssueDate = bookIssueDate;
		this.bookSubmitDate = bookSubmitDate;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	
	

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the bookIssueDate
	 */
	public String getBookIssueDate() {
		return bookIssueDate;
	}

	/**
	 * @param bookIssueDate the bookIssueDate to set
	 */
	public void setBookIssueDate(String bookIssueDate) {
		this.bookIssueDate = bookIssueDate;
	}

	/**
	 * @return the bookSubmitDate
	 */
	public String getBookSubmitDate() {
		return bookSubmitDate;
	}

	/**
	 * @param bookSubmitDate the bookSubmitDate to set
	 */
	public void setBookSubmitDate(String bookSubmitDate) {
		this.bookSubmitDate = bookSubmitDate;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	/**
	 * @return the bookId
	 */
	public int getBookId() {
		return bookId;
	}

	/**
	 * @param bookId the bookId to set
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}




	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return  bookName + userId + bookIssueDate + bookSubmitDate;
	}
	
	

	
	
	
	
	
	
}