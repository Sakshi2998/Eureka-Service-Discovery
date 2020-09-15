package com.example.bookinfoservice.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.bookinfoservice.models.Book;

@RestController
@RequestMapping("/book")
public class BookInfoResource {

	@GetMapping("/{id}")
	Book getBook(@PathVariable int id) {
		return new Book(id, "John Green", "Fault in our stars");
	}

}
