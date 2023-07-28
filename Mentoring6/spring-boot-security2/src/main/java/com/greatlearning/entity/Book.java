package com.greatlearning.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="books")
public class Book {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
    private String name;
    
    private String category;

    private String author;

    public Book() {}

    public Book(String name, String category, String author) {
        this.name = name;
        this.category = category;
        this.author = author;
    }
}
