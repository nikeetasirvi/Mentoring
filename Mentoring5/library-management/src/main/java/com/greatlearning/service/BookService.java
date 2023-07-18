package com.greatlearning.service;

import java.util.List;

import com.greatlearning.entity.Book;

public interface BookService {

	public List<Book> findAll();

	public Book findById(int id);

	public void save(Book book);

	public void deleteById(int idd);
}
