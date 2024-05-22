package com.example.bookmgmt.service;

import java.util.List;

import com.example.bookmgmt.dto.BookDetaiDto;
import com.example.bookmgmt.model.BookDetails;

public interface BookService {
	
	String getBookMessage();

	boolean saveBookDetails(BookDetaiDto bookDetaiDto);

	List<BookDetails> getAllBookDetails();

	BookDetails getBookDetailsById(Integer id);
	
	boolean updateBookDetails(BookDetaiDto bookDetaiDto);
}
