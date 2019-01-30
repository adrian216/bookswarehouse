package com.someonesmarter.bookstore.repository;

import com.someonesmarter.bookstore.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PublisherRepository extends JpaRepository<Publisher, Long> {
    Publisher findByName(String publisherName);
}
