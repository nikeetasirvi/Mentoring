package com.greatlearning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.entity.Book;
import com.greatlearning.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	BookRepository bookRepository;
	
	public List<Book> findAll() {
        List<Book> books=bookRepository.findAll();
        return books;
    }

    public Book findById(int theId) {
        return bookRepository.findById(theId).get();
    }

    public void save(Book book) {
        bookRepository.save(book);

    }

    public void deleteById(int id) {
        bookRepository.deleteById(id);
    }

    public List<Book> searchBy(String name, String author){
        List<Book> books = bookRepository.findByNameContainsAndAuthorContainsAllIgnoreCase(name, author);
        return books;
    }
}
