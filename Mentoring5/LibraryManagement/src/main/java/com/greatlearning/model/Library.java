package com.greatlearning.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="libraries")
public class Library {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	private String name;
	
	@OneToMany(mappedBy="library", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JsonManagedReference
	private List<Book> books;
	
	// scaffolding code to set both sides of the relationshiop
	public void addBook(Book book) {
		if(books==null) {
			books = new ArrayList<>();
		}
		books.add(book);
		book.setLibrary(this);
	}
}
