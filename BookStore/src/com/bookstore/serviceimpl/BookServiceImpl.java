package com.bookstore.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.dao.BookDAO;
import com.bookstore.entity.Book;
import com.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
	BookDAO bookDAO;
	
	@Override
	public List<Book> getAllBook() {
		// TODO Auto-generated method stub
		System.out.println("BookServiceImpl>getAllBook()");
		return bookDAO.getAllBook();
	}
	
	@Override
	public List<Book> getAllBook(int start, int total) {
		// TODO Auto-generated method stub
		return bookDAO.getAllBook(start, total);
	}


	@Override
	public void deleteBook(Integer bid) {
		// TODO Auto-generated method stub
		bookDAO.deleteBook(bid);
	}

	@Override
	public void addBook(Book book) {
		// TODO Auto-generated method stub
		bookDAO.addBook(book);
	}

	@Override
	public Book getBookById(Integer bid) {
		// TODO Auto-generated method stub
		return bookDAO.getBookById(bid);
	}

	@Override
	public void updateBook(Book book) {
		// TODO Auto-generated method stub
		bookDAO.updateBook(book);
	}

	@Override
	public int totalAvailableBooks() {
		// TODO Auto-generated method stub
		return bookDAO.totalAvailableBooks();
	}
}
