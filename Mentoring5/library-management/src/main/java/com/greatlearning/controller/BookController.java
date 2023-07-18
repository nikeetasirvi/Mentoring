package com.greatlearning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatlearning.entity.Book;
import com.greatlearning.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	BookService bookService;
	
	@GetMapping("/list")
	public String listBooks(Model theModel) {
		List<Book> theBooks = bookService.findAll();
		theModel.addAttribute("books", theBooks);
		return "books/list-books";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Book theBook = new Book();
		theModel.addAttribute("book", theBook);
		return "books/book-form";
	}

	@PostMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId,
									Model theModel) {
		Book theBook = bookService.findById(theId);
		theModel.addAttribute("book", theBook);
		return "books/book-form";			
	}
	
	@PostMapping("/save")
	public String saveBook(@ModelAttribute("book") Book theBook) {
		bookService.save(theBook);
		return "redirect:/books/list";
	}
	
	@PostMapping("/delete")
	public String delete(@RequestParam("bookId") int theId) {
		bookService.deleteById(theId);
		return "redirect:/books/list";
	}
}
