package com.frontalterdemo1;

import static org.mockito.ArgumentMatchers.booleanThat;

import com.repository.BookRepository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FrontAlterDemo1ApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	private BookRepository bookRepository;
	@Test
	void findAll(){
		System.out.println(bookRepository.findAll());
	}
}
