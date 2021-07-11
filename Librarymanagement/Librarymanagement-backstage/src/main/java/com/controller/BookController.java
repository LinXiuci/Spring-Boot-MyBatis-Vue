package com.controller;
import java.util.List;

import com.entity.Book;
import com.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;





@RestController
public class BookController {
    
    @Autowired
    private BookRepository bookRepository;

    @GetMapping("/findAll/{page}/{size}")
    public Page<Book>findAll(@PathVariable("page")Integer page,@PathVariable("size")Integer size){
        Pageable pageable=PageRequest.of(page-1, size);
        return  bookRepository.findAll(pageable);
    }

    @GetMapping("/findById/{id}")
    public Book findById(@PathVariable("id")Integer id){
        return bookRepository.findById(id).get();
    }

    @PostMapping("/save")
    public String save(@RequestBody Book book){
        Book result=bookRepository.save(book);
        if (result != null) {
            return "success";
        }else{
            return "error";
        }
    }
    @PutMapping("/update")
    public String update(@RequestBody Book book){
        Book result=bookRepository.save(book);
        if (result != null) {
            return "success";
        }else{
            return "error";
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public void deleteById(@PathVariable("id")Integer id){
        bookRepository.deleteById(id);
    }
}
