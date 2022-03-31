package com.bookapp.model.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.bookapp.model.dao.BookDAO;
import com.bookapp.model.entities.Book;
import com.bookapp.model.exception.BookNotFoundException;

@Service
public class BookServiceImpl implements BookService{

	private BookDAO bookDAO;
	
	public BookServiceImpl(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}
	
	

	@Override
	public List<Book> getAllBooks() {
		return bookDAO.findAll();
	}

	@Override
	public Book getBookById(int id) {
		return bookDAO.findById(id)
				.orElseThrow(()->new BookNotFoundException("book with id "+ id +" is not found"));
	}

	@Override
	public Book addBook(Book book) {
		bookDAO.save(book);
		return book;
	}

	@Override
	public List<Book> getBookByTitle(String title) {
		return (List<Book>) bookDAO.findByTitle(title);
	}

	@Override
	public Book updateBook(int bookId, Book book) {
		Book bookToUpdate = getBookById(bookId);
		bookToUpdate.setPrice(book.getPrice());
		bookDAO.save(bookToUpdate);
		return bookToUpdate;
	}

	@Override
	public Book deleteBook(int bookId) {
		Book bookToDelete = getBookById(bookId);

		bookDAO.delete(bookToDelete);

		return bookToDelete;
	}

}
