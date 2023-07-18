package com.greatlearning.service;

import org.springframework.data.domain.Page;

import com.greatlearning.model.Library;

public interface LibraryService {

	public Library saveLibrary(Library library);
	
	public void deleteById(long id);
	
	public Library findById(long id);
	
	public Library updateLibrary(long id,Library updatedLibrary);
	
	public Page<Library> findAll(int page, int size, String direction, String property);
}
