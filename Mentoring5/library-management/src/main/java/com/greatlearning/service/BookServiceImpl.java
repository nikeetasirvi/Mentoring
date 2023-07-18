package com.greatlearning.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.dao.BookRepository;
import com.greatlearning.entity.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookRepository bookRepository;

	@Override
	public List<Book> findAll() {
		return bookRepository.findAll();
	}

	@Override
	public Book findById(int id) {
		Optional<Book> result = bookRepository.findById(id);
		Book book = null;
		if (result.isPresent()) {
			book = result.get();
		} else {
			throw new RuntimeException("Did not find book id - " + id);
		}
		return book;
	}

	@Override
	public void save(Book book) {
		bookRepository.save(book);
	}

	@Override
	public void deleteById(int id) {
		bookRepository.deleteById(id);
	}

}
