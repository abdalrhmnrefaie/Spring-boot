package com.global.book.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

import org.hibernate.annotations.Formula;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.global.book.basic.BasicEntity;
import com.global.book.validator.IpAddress;

@Entity
@Table(name = "authers")
public class Auther extends BasicEntity<Long> {

	
	@NonNull
	private String name;
	
//	@Pattern(regexp = "^([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})\\.([0-9]{1,3})$")
	@IpAddress()
	private String ipAddress;
	
	@Email(message = "{validation.constraints.email.message}")
	private String email;

	@Formula("(select count(*) from books book where book.auther_id=id)")
	private Long bookcount;


	
	@JsonManagedReference
	@OneToMany(mappedBy = "auther")
	private List<Book> books = new ArrayList<>();

	public void addBook(Book book) {

		books.add(book);
	}

	public void removeBook(Book book) {

		books.remove(book);
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getBookcount() {
		return bookcount;
	}

	public void setBookcount(Long bookcount) {
		this.bookcount = bookcount;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}




}
