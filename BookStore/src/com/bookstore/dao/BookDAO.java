package com.bookstore.dao;

import java.util.List;

import com.bookstore.entity.Book;

public interface BookDAO {

	public List<Book> getAllBook();
	public List<Book> getAllBook(int start, int total);
	public void deleteBook(Integer bid);
	public void addBook(Book book);
	public Book getBookById(Integer bid);
	public void updateBook(Book book);
	public int totalAvailableBooks();
}
