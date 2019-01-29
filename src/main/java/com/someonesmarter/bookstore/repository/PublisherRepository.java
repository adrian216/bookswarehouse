package com.someonesmarter.bookstore.repository;

import com.someonesmarter.bookstore.model.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findByName(String publisherName);
}
