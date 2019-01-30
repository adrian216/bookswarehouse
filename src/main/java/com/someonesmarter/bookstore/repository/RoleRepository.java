package com.someonesmarter.bookstore.repository;

import com.someonesmarter.bookstore.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
