package com.someonesmarter.bookstore.service;

import com.someonesmarter.bookstore.model.Author;
import com.someonesmarter.bookstore.model.Book;
import com.someonesmarter.bookstore.repository.AuthorRepository;
import com.someonesmarter.bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository=bookRepository;
        this.authorRepository = authorRepository;
    }

    public Book addBook(Book book) {
        bookRepository.save(book);
        return book;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book getBookById(long id) {
        return bookRepository.getOne(id);
    }

    public void deleteBook(Book book) {
        bookRepository.delete(book);
    }

    public void deleteBookById(long bookId) {
        bookRepository.deleteById(bookId);
    }

    public List<Book> getBooksByAuthor(String authorName) {
        Author author = authorRepository.findByName(authorName);
        return author.getBooks();
    }
}
