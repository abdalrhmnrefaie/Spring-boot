package com.global.book.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PostLoad;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Formula;
import org.springframework.lang.NonNull;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.global.book.basic.BasicEntity;

@Entity
@Table(name = "books")
public class Book extends BasicEntity<Long> {

	@NonNull
	private String name;
	@Min(value = 5)
	@Max(value = 500)
	private double price;

	@NotNull
	@JsonBackReference
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "auther_id")
	private Auther auther;

	@Transient
	private double discound;

	@Formula("(select count(*) from books)")
	private Long bookcount;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Auther getAuther() {
		return auther;
	}

	public void setAuther(Auther auther) {
		this.auther = auther;
	}

	public double getDiscound() {
		return discound;
	}

	public void setDiscound(double discound) {
		this.discound = discound;
	}

	@PostLoad
	private void calDiscound() {
		this.setDiscound(price * .25);
	}

	public Long getBookcount() {
		return bookcount;
	}

	public void setBookcount(Long bookcount) {
		this.bookcount = bookcount;
	}

}
