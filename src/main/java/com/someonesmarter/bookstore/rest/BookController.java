package com.someonesmarter.bookstore.rest;

import com.someonesmarter.bookstore.model.Book;
import com.someonesmarter.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService=bookService;
    }

    @PostMapping("/book")
    public Book saveBook(@Valid @RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping("/book")
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/book/{bookId}")
    public Book getBookById(@PathVariable long bookId) {
        return bookService.getBookById(bookId);
    }

    @DeleteMapping("/book")
    public void deleteBook(@RequestBody Book book) {
        bookService.deleteBook(book);
    }

    @DeleteMapping("/book/{bookId}")
    public void deleteBookById(@PathVariable long bookId) {
        bookService.deleteBookById(bookId);
    }

    @GetMapping("/author/{authorName}")
    public List<Book> getBooksByAuthor(@PathVariable String authorName) {
        return bookService.getBooksByAuthor(authorName);
    }




}
