package com.example.service;

import com.example.data.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<Book> getAllBooks(){
        List<Book> books = new ArrayList<>();
        bookRepository.findAll().forEach(book -> books.add(book));
        return books;
    }

    public Book getBookById(int bookid){
        return bookRepository.findById(bookid).get();
    }

    public Book saveBook(Book book){
        return bookRepository.save(book);
    }

    public void deleteBook(int bookid){
        bookRepository.deleteById(bookid);
    }

    public void updateBook(Book book){
        bookRepository.save(book);
    }

}
