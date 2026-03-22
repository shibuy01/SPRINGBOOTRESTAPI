package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.BookRepository;
import com.example.demo.entity.Book;

@Service
public class BookServices {
	
	@Autowired
	private BookRepository bookRepository;
    
    // get all books
    public List<Book> getAllBooks(){
    	List<Book> list = (List<Book>) this.bookRepository.findAll();
    	return list;
    }
    
    // get single book by id
    public Book getBookById(int id) {
    	Book book = null;
    	 book = this.bookRepository.findById(id);
        return book;
    }
    
    // add book
    public Book addBook(Book b) {
        Book result = this.bookRepository.save(b);
        return result;
    }
    
 // delete book
    public void deleteBook(int id) {
    	this.bookRepository.deleteById(id);
    }
    
    //update the book
    public void updateBook(Book book, int bookId) {
    	book.setId(bookId);
    	this.bookRepository.save(book);
    }
}