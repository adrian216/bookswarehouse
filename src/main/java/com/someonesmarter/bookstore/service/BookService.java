package com.someonesmarter.bookstore.service;

import com.someonesmarter.bookstore.model.Author;
import com.someonesmarter.bookstore.model.Book;
import com.someonesmarter.bookstore.model.Category;
import com.someonesmarter.bookstore.model.Publisher;
import com.someonesmarter.bookstore.repository.AuthorRepository;
import com.someonesmarter.bookstore.repository.BookRepository;
import com.someonesmarter.bookstore.repository.CategoryRepository;
import com.someonesmarter.bookstore.repository.PublisherRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private BookRepository bookRepository;
    private AuthorRepository authorRepository;
    private PublisherRepository publisherRepository;
    private CategoryRepository categoryRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository, PublisherRepository publisherRepository, CategoryRepository categoryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.publisherRepository = publisherRepository;
        this.categoryRepository = categoryRepository;
    }

    public Book addBook(Book book) {
        Author author = book.getAuthor();
        Author authorFound = authorRepository.findByName(author.getName());
        if (authorFound == null) {
            authorRepository.save(author);
        }

        Publisher publisher = book.getPublisher();
        Publisher publisherFound = publisherRepository.findByName(publisher.getName());
        if (publisherFound == null) {
            publisherRepository.save(publisher);
        }
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

    public List<Book> getBooksByPublisher(String publisherName) {
        Publisher publisher = publisherRepository.findByName(publisherName);
        return publisher.getBooks();
    }

    public List<Book> getBooksByCategory(String categoryName) {
        Category category = categoryRepository.findByName(categoryName);
        return category.getBooks();
    }
}
