package com.someonesmarter.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    @NotBlank(message = "Category's name cannot be empty")
    private String name;

    @ManyToMany(mappedBy = "categories")
    @JsonIgnore
    private List<Book> books = new ArrayList<>();

    public Category() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Category{" +
                "name='" + name + '\'' +
                '}';
    }

    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object == null || (object.getClass() == getClass())) {
            return false;
        }
        Category category = (Category) object;
        return Objects.equals(category.id, id) &&
               Objects.equals(category.name, name) &&
               Objects.equals(category.books, books);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, books);
    }
}
