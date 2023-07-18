package com.greatlearning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greatlearning.model.Library;
import com.greatlearning.service.LibraryService;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

	@Autowired
	LibraryService libraryService;
	
	@PostMapping
	public Library save(@RequestBody Library library) {
		return libraryService.saveLibrary(library);
	}
	
	@GetMapping
	public Page<Library> findAll(
			@RequestParam(name="page",required=false,defaultValue="0")int page,
			@RequestParam(name="size",required=false,defaultValue="10")int size,
			@RequestParam(name="sort",required=false,defaultValue="ASC")String direction,
			@RequestParam(name="onField",required=false,defaultValue="name")String property) {
		return libraryService.findAll(page, size, direction, property);
	}
	
	@DeleteMapping("/{id}")
	public void deleteById(@PathVariable("id") long id) {
		libraryService.deleteById(id);
	}
	
	@GetMapping("/{id}")
	public Library findById(@PathVariable("id") long id) {
		return libraryService.findById(id);
	}
	
	@PutMapping("/{id}")
	public Library update(@PathVariable("id") long id,Library updatedLibrary) {
		return libraryService.updateLibrary(id, updatedLibrary);
	}
}
