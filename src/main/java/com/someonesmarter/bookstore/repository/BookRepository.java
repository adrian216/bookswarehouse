package com.someonesmarter.bookstore.repository;

import com.someonesmarter.bookstore.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
