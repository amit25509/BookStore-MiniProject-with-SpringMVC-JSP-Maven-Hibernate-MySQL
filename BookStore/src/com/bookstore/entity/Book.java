package com.bookstore.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "bid")
	private Integer bid;
	
	@Column(name = "bname")
	private String bname;
	
	@Column(name = "author")
	private String author;
	
	@Column(name = "price")
	private Double price;
	
	@Column(name = "edition")
	private String edition;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "pub")
	private String pub;

	public Book() {
		super();
	}

	public Book(Integer bid, String bname, String author, Double price, String edition, String category, String pub) {
		super();
		this.bid = bid;
		this.bname = bname;
		this.author = author;
		this.price = price;
		this.edition = edition;
		this.category = category;
		this.pub = pub;
	}

	public Integer getBid() {
		return bid;
	}

	public void setBid(Integer bid) {
		this.bid = bid;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getEdition() {
		return edition;
	}

	public void setEdition(String edition) {
		this.edition = edition;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPub() {
		return pub;
	}

	public void setPub(String pub) {
		this.pub = pub;
	}

	@Override
	public String toString() {
		return "Book [bid=" + bid + ", bname=" + bname + ", author=" + author + ", price=" + price + ", edition="
				+ edition + ", category=" + category + ", pub=" + pub + "]";
	}
	
	
}
