package com.global.book.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.global.book.basic.BasicService;
import com.global.book.entity.Book;
import com.global.book.repository.BookRepository;

@Service
public class BookService extends BasicService<Book, Long> {

	@Autowired
	private BookRepository bookRepository;

	public List<Book> insertAll(List<Book> entities) {

		return bookRepository.saveAll(entities);
	}

	public Book update(Book entity) {
		Book book = findById(entity.getId());
		book.setName(entity.getName());
		return update(book);
	}

	public int deleteByAutherId(Long id) {

		return bookRepository.deleteByAutherId(id);
	}

}
