package com.example.bookmgmt.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.bookmgmt.dto.BookDetaiDto;
import com.example.bookmgmt.model.BookDetails;
import com.example.bookmgmt.repository.BookDetailsRepository;
import com.example.bookmgmt.service.BookService;

@Service
public class BookServiceImpl implements BookService {
	@Autowired
	BookDetailsRepository bookDetailsRepository;

	@Override
	public String getBookMessage() {
		return "Improve Your Knwoledge";
	}

	@Override
	public boolean saveBookDetails(BookDetaiDto bookDetaiDto) {
		try {

			BookDetails bookDetails = new BookDetails();

			bookDetails.setBookname(bookDetaiDto.getBookname());
			bookDetails.setPrice(bookDetaiDto.getPrice());
			bookDetails.setRemarks(bookDetaiDto.getRemarks());

			bookDetailsRepository.save(bookDetails);

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

	@Override
	public List<BookDetails> getAllBookDetails() {
		List<BookDetails> bookDetails = (List<BookDetails>) bookDetailsRepository.findAll();
		return bookDetails;
	}

	@Override
	public BookDetails getBookDetailsById(Integer id) {
		Optional<BookDetails> bookDetails = bookDetailsRepository.findById(id);
		return bookDetails.get();
	}

	@Override
	public boolean updateBookDetails(BookDetaiDto bookDetaiDto) {
		try {

			Optional<BookDetails> bookDetails = bookDetailsRepository.findById(bookDetaiDto.getId());
			bookDetails.get().setBookname(bookDetaiDto.getBookname());
			bookDetails.get().setPrice(bookDetaiDto.getPrice());
			bookDetails.get().setRemarks(bookDetaiDto.getRemarks());
			
			bookDetailsRepository.save(bookDetails.get());
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}

}
