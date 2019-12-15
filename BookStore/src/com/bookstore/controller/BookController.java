package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bookstore.entity.Book;
import com.bookstore.service.BookService;

@Controller
public class BookController {

	@Autowired
	BookService bookService;
	
	int from;
	int to=5;
	int totalDisplay=5;
	int totalBooks;
	
	private void showTotalBooks(Model model) {
		int from=0;
		int to=5;
		int totalDisplay=5;
		int totalBooks=bookService.totalAvailableBooks();
		this.totalBooks=totalBooks;
		
		model.addAttribute("FROM", from+1);
		model.addAttribute("TO", to);
		model.addAttribute("TOTAL", totalBooks);
		
		model.addAttribute("showPrevious", "FALSE");
		model.addAttribute("showNext", "TRUE");
	}
	
	@GetMapping("/next")
	public String next(Model model) {
		System.out.println("BookController>next()");
		from=from+totalDisplay;
		if(from<=0) {
			from=0;
			model.addAttribute("showPrevious", "FALSE");
		}
		else
			model.addAttribute("showPrevious", "TRUE");
		
		model.addAttribute("FROM", from+1);
		
		to=to+totalDisplay;
		if(to>=totalBooks) {
			model.addAttribute("TO", totalBooks);
			model.addAttribute("showNext", "FALSE");
		}
		else {
			model.addAttribute("TO", to);
			model.addAttribute("showNext", "TRUE");
		}
		
		List<Book> booksList= bookService.getAllBook(from,to);
		model.addAttribute("BOOKLIST", booksList);
		model.addAttribute("TOTAL", totalBooks);
		return "showAllBooks";
	}
	
	@GetMapping("/previous")
	public String previous(Model model) {
		from=from-totalDisplay;
		if(from<=0) {
			from=0;
			model.addAttribute("showPrevious", "FALSE");
		}
		else {
			model.addAttribute("showPrevious", "TRUE");
		}
		model.addAttribute("FROM", from+1);
		to=to-totalDisplay;
		if(to>=totalDisplay) {
			model.addAttribute("TO", totalBooks);
			model.addAttribute("showNext", "FALSE");
		}
		else {
			model.addAttribute("TO", to);
			model.addAttribute("showNext", "TRUE");
		}
		return "redirect:/showAllBooks";
	}
	
	@GetMapping("/")
	public String showIndex() {
		System.out.println("BookController>showIndex()");
		return "index";
	}
	
	@GetMapping("/showAllBooks")
	public String showAllBooks(Model model) {
		System.out.println("BookController>showAllBooks()");
		List<Book> booksList= bookService.getAllBook(from,to);
		model.addAttribute("BOOKLIST", booksList);
		showTotalBooks(model);
		return "showAllBooks";
	}
	
	@PostMapping("/deleteBook")
	public String deleteBook(@RequestParam("bookId") Integer bid) {
		System.out.println("BookController>deleteBook()");
		bookService.deleteBook(bid);
		return "redirect:/showAllBooks";
	}
	
	@PostMapping("/addBook")
	public String addBook(Model model) {
		System.out.println("BookController>addBook()");
		Book book= new Book();
		model.addAttribute("mybook", book);
		return "addBook";
	}
	
	@PostMapping("/saveBook")
	public String saveBook(@ModelAttribute("mybook") Book book, BindingResult result, Model model) {
		System.out.println("BookController>saveBook()");
		bookService.addBook(book);
		return "redirect:/showAllBooks";
	}
	
	@PostMapping("/editBook")
	public String editBook(@RequestParam("bookId") Integer bid, Model model) {
		System.out.println("BookController>saveBook()");
		Book book= bookService.getBookById(bid);
		model.addAttribute("mybook", book);
		return "editBook";
	}
	
	@PostMapping("/updateBook")
	public String updateBook(@ModelAttribute("mybook") Book book, BindingResult bindingResult, Model model) {
		System.out.println("BookController>updateBook()");
		bookService.updateBook(book);
		return "redirect:/showAllBooks";
	}
}
