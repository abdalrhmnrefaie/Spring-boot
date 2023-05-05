package com.global.book.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.global.book.entity.Auther;
import com.global.book.entity.Book;
import com.global.book.service.AutherService;
import com.global.book.service.BookService;

@Component
public class StartUpApp implements CommandLineRunner{
	
	
	@Autowired
	private AutherService autherService;
	
	@Autowired
	private BookService bookService;
	

	@Override
	public void run(String... args) throws Exception {
		
//		adding some data for authers
		if (autherService.findAll().isEmpty()) {
		Auther auther1=new Auther();
		auther1.setName("Abdalrhmn");
		
		Auther auther2=new Auther();
		auther2.setName("Mohamed");
		
		Auther auther3=new Auther();
		auther3.setName("Hossam");
		
		autherService.insertAll(Arrays.asList(auther1,auther2,auther3));
		}
		
//		adding some data for Books
		if(bookService.findAll().isEmpty()) {
		Book book1=new Book();
		book1.setName(" java basics");
		book1.setPrice(200);
		book1.setAuther(autherService.findById(1L));
		
		Book book2=new Book();
		book2.setName("java advanced");
		book2.setPrice(300);
		book2.setAuther(autherService.findById(2L));
		
		Book book3=new Book();
		book3.setName("java web");
		book3.setPrice(400);
		book3.setAuther(autherService.findById(3L));
		
		bookService.insertAll(Arrays.asList(book1,book2,book3));
		
		
	}
	}

}
