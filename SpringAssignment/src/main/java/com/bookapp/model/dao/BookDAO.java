package com.bookapp.model.dao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.bookapp.model.entities.Book;

public interface BookDAO extends JpaRepository<Book, Integer>{

	public List<Book> findByTitle(String title);
}
