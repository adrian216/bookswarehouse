package com.someonesmarter.bookstore.rest;

import com.someonesmarter.bookstore.entity.Book;
import com.someonesmarter.bookstore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    private BookService bookService;

    @Autowired
    public void setBookService(BookService bookService) {
        this.bookService=bookService;
    }

    @PostMapping
    public Book saveBook(@Valid @RequestBody Book book) {
        return bookService.addBook(book);
    }

    @GetMapping
    public List<Book> getBooks() {
        return bookService.getAllBooks();
    }

    @GetMapping("/{bookId}")
    public Book getBookById(@PathVariable long bookId) {
        return bookService.getBookById(bookId);
    }

    @DeleteMapping
    public void deleteBook(@RequestBody Book book) {
        bookService.deleteBook(book);
    }

    @DeleteMapping("/{bookId}")
    public void deleteBookById(@PathVariable long bookId) {
        bookService.deleteBookById(bookId);
    }

    @GetMapping("/author/{authorName}")
    public List<Book> getBooksByAuthor(@PathVariable String authorName) {
        return bookService.getBooksByAuthor(authorName);
    }

    @GetMapping("/publisher/{publisherName}")
    public List<Book> getBooksByPublisher(@PathVariable String publisherName) {
        return  bookService.getBooksByPublisher(publisherName);
    }

    @GetMapping("/category/{categoryName}")
    public List<Book> getBooksByCategory(@PathVariable String categoryName) {
        return bookService.getBooksByCategory(categoryName);
    }




}
