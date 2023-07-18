package com.greatlearning.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

import com.github.javafaker.Faker;
import com.greatlearning.model.Book;
import com.greatlearning.model.Library;
import com.greatlearning.repository.LibraryRepository;

@Configuration
public class BootstrapAppData {

	@Autowired
	LibraryRepository libraryRepository;
	
	private Faker faker = new Faker();
	
	@EventListener(ApplicationReadyEvent.class)
	public void onApplicationready(ApplicationReadyEvent event) {
		
		for (int i = 0; i < 2000; i++) {
			Library library = new Library();
			library.setName(faker.company().name());
			
			Book book = new Book();
			book.setName(faker.book().title());
			book.setPrice(faker.number().randomDouble(2, 200, 500));

			Book book1 = new Book();
			book1.setName(faker.book().title());
			book1.setPrice(faker.number().randomDouble(2, 200, 500));

			Book book2 = new Book();
			book2.setName(faker.book().title());
			book2.setPrice(faker.number().randomDouble(2, 200, 500));

			library.addBook(book);
			library.addBook(book1);
			library.addBook(book2);
			
			this.libraryRepository.save(library);
		}
		
	}
}
