package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;

@Service
public class BookServices {

    private static List<Book> list = new ArrayList<>();
    
    static {
        list.add(new Book(122,"java","xyz"));
        list.add(new Book(113,"pythan","pqr"));
        list.add(new Book(102,".NET","abc"));
    }
    
    // get all books
    public List<Book> getAllBooks(){
        return list;
    }
    
    // get single book by id
    public Book getBookById(int id) {
        return list.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }
    
    // add book
    public Book addBook(Book b) {
        list.add(b);
        return b;
    }
    
 // delete book
    public void deleteBook(int id) {
        list.removeIf(b -> b.getId() == id);
    }
    
    //update the book
    public void updateBook(Book book, int bookId) {
    	list = list.stream().map(b->{
    		if(b.getId() == bookId) {
    			b.setTitle(book.getTitle());
    			b.setAuthor(book.getAuthor());
    		}
    		return b;
    	}).collect(Collectors.toList());
    }
}