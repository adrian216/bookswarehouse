package com.someonesmarter.bookstore.service;

import com.someonesmarter.bookstore.entity.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
