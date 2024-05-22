package com.example.bookmgmt.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.bookmgmt.dto.BookDetaiDto;
import com.example.bookmgmt.model.BookDetails;
import com.example.bookmgmt.service.BookService;

@Controller
public class BookController {
	@Autowired
	BookService bookService;

	@GetMapping("/books/message")
	@ResponseBody
	public String getBookMessage() {
		String response = bookService.getBookMessage();
		return response;
	}

	@RequestMapping(value = "/books/saveBookDetails", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public boolean saveBookDetails(@RequestBody BookDetaiDto bookDetaiDto) {
		boolean response = bookService.saveBookDetails(bookDetaiDto);
		return response;
	}

	@GetMapping("/book/getAllDetails")
	@ResponseBody
	public List<BookDetails> getAllBookDetails() {
		List<BookDetails> bookDetails = bookService.getAllBookDetails();
		return bookDetails;
	}

	@GetMapping("/book/getBookDetailsById")
	@ResponseBody
	public BookDetails getBookDetailsById(@RequestParam Integer id) {
		BookDetails response = bookService.getBookDetailsById(id);
		return response;
	}

	@RequestMapping(value = "/books/updateBookDetails", method = { RequestMethod.POST, RequestMethod.GET })
	@ResponseBody
	public boolean updateBookDetails(@RequestBody BookDetaiDto bookDetaiDto) {
		boolean response = bookService.updateBookDetails(bookDetaiDto);
		return response;
	}
}
