package com.example.controller;

import com.example.service.BookService;
import com.example.data.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    BookService bookService;

    @GetMapping("/allbooks")
    private List<Book> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{bookid}")
    private Book getBook(@PathVariable("bookid") int bookId){
        return bookService.getBookById(bookId);
    }

    @DeleteMapping("/delete/book/{bookid}")
    private void deleteBook(@PathVariable("bookid") int bookId){
         bookService.deleteBook(bookId);
    }

    @PostMapping("/newbook")
    private int saveBook(@RequestBody Book newBook){
        bookService.saveBook(newBook);
        return newBook.getBookId();
    }

    @PutMapping("/books/update")
    private Book update(@RequestBody Book book){
        bookService.updateBook(book);
        return book;
    }

}
