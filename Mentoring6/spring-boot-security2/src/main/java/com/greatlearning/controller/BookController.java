package com.greatlearning.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.greatlearning.entity.Book;
import com.greatlearning.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;

	@RequestMapping("/list")
	public String listBooks(Model theModel) {
		List<Book> theBooks = bookService.findAll();
		theModel.addAttribute("Books", theBooks);
		return "list-Books";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Book theBook = new Book();
		theModel.addAttribute("Book", theBook);
		return "Book-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("bookId") int theId,Model theModel) {
		Book theBook = bookService.findById(theId);
		theModel.addAttribute("Book", theBook);
		return "Book-form";
	}


	@PostMapping("/save")
	public String saveBook(@RequestParam("id") int id,
						   @RequestParam("name") String name,
						   @RequestParam("category") String category,
						   @RequestParam("author") String author) {

		System.out.println(id);
		Book theBook;
		if(id!=0)
		{
			theBook=bookService.findById(id);
			theBook.setName(name);
			theBook.setCategory(category);
			theBook.setAuthor(author);
		}
		else
			theBook=new Book(name, category, author);
		bookService.save(theBook);
		return "redirect:/books/list";
	}



	@RequestMapping("/delete")
	public String delete(@RequestParam("bookId") int theId) {
		bookService.deleteById(theId);
		return "redirect:/books/list";
	}


	@RequestMapping("/search")
	public String search(@RequestParam("name") String name,
						 @RequestParam("author") String author,
						 Model theModel) {
		if (name.trim().isEmpty() && author.trim().isEmpty()) {
			return "redirect:/books/list";
		}
		else {
			List<Book> theBooks =
					bookService.searchBy(name, author);
			theModel.addAttribute("Books", theBooks);
			return "list-Books";
		}
	}

	@RequestMapping(value = "/403")
	public ModelAndView accesssDenied(Principal user) {
		ModelAndView model = new ModelAndView();
		if (user != null) {
			model.addObject("msg", "Hi " + user.getName()
					+ ", you do not have permission to access this page!");
		} else {
			model.addObject("msg",
					"You do not have permission to access this page!");
		}
		model.setViewName("403");
		return model;
	}
}
