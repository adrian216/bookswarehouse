package com.someonesmarter.bookstore.repository;

import com.someonesmarter.bookstore.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
