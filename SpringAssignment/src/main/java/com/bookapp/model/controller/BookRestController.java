package com.bookapp.model.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookapp.model.entities.Book;
import com.bookapp.model.service.BookService;

@RestController
@RequestMapping(path = "api")
public class BookRestController {
	private BookService bookService;

	@Autowired
	public BookRestController(BookService bookService) {
		this.bookService = bookService;
	}

	//------get all the books----- 
	@GetMapping(path = "books")
	List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	// ------get an the book--
		@GetMapping(path = "books/{id}")
		Book getAnBooks(@PathVariable(name = "id") int id) {
			return bookService.getBookById(id);
		}

		// ------delete the book--
		@DeleteMapping(path = "books/{id}")
		Book deleteAnBooks(@PathVariable(name = "id") int id) {
			return bookService.deleteBook(id);
		}

		// -----add a new book-
		@PostMapping(path = "books")
		Book postAnBooks(@RequestBody Book book) {
			return bookService.addBook(book);
		}

		// -----add a new book-
		@PutMapping(path = "books/{id}")
		Book updateAnBooks(@PathVariable(name = "id") int id, @RequestBody Book book) {
			return bookService.updateBook(id, book);
		}

	
}
