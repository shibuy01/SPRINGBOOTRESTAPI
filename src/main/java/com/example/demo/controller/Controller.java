package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Book;
import com.example.demo.service.BookServices;

@RestController
public class Controller {

	@Autowired
	private BookServices bookServices;
	
	@GetMapping("/books")
	public List<Book> getBooks(){
		return this.bookServices.getAllBooks();
	}
	
	@GetMapping("/book/{id}")
	public Book getBook(@PathVariable("id") int id) {
		return this.bookServices.getBookById(id);
	}
	
	@PostMapping("/addBook")
	public Book addBook(@RequestBody Book b) {
		return this.bookServices.addBook(b);
	}
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable("bookId") int bookId) {
	    this.bookServices.deleteBook(bookId);
	}
	
	@PutMapping("/books/{bookId}")
	public Book updateBook(@RequestBody Book book, @PathVariable("bookId") int bookId ) {
		this.bookServices.updateBook(book, bookId);
		return book;
	}
}
