package com.greatlearning.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.greatlearning.model.Library;
import com.greatlearning.repository.LibraryRepository;

@Service
public class LibraryServiceImpl implements LibraryService{

	@Autowired
	LibraryRepository libraryRepository;
	
	@Override
	public Library saveLibrary(Library library) {
		return libraryRepository.save(library);
	}

	@Override
	public void deleteById(long id) {
		libraryRepository.deleteById(id);
	}

	@Override
	public Library findById(long id) {
		return libraryRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("invalid library id"));
	}

	@Override
	public Page<Library> findAll(int page, int size, String strdirection, String property) {
		Sort.Direction direction = strdirection.equalsIgnoreCase("asc")?Sort.Direction.ASC:Sort.Direction.DESC;
		PageRequest pageRequest = PageRequest.of(page, size, direction, property);
		return libraryRepository.findAll(pageRequest);
	}
	
	@Override
	public Library updateLibrary(long id, Library updatedLibrary) {
		return null;
	}

}
