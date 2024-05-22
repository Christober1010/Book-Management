package com.example.bookmgmt.controler;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
	
	@GetMapping("/book")
	public String bookDetails(Model model) {
		model.addAttribute("message","book details");
		return "user/book";
	}

}
