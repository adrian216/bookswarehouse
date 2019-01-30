package com.someonesmarter.bookstore.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.persistence.JoinColumn;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"}) // ignores the 'garbage' from hibernate (was getting some when calling get/book/id
@Table(name="book")
public class Book implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name="title")
    @NotBlank(message = "Title cannot be empty")
    private String title;
    @Column(name="description", length = 2500)
    @NotBlank(message = "Description cannot be empty")
    private String description;

    @Column(name="price")
    private BigDecimal price;

    @Column(name="isbn")
    @NotBlank(message = "ISBN cannot be empty")
    @NumberFormat
    private String isbn;

    @ManyToOne
    @JoinColumn(name="author_id")
    @NotNull(message = "Author cannot be empty")
    private Author author;

    @ManyToOne()
    @JoinColumn(name="publisher_id")
    @NotNull(message="Publisher cannot be empty")
    private Publisher publisher;

    @ManyToMany
    @JoinTable(
            name="book_category",
            joinColumns=@JoinColumn(name="book_id"),
            inverseJoinColumns=@JoinColumn(name="category_id"))
    private List<Category> categories = new ArrayList<>();

    public Book() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Publisher getPublisher() {
        return publisher;
    }

    public void setPublisher(Publisher publisher) {
        this.publisher = publisher;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", isbn='" + isbn + '\'' +
                ", author=" + author +
                ", publisher=" + publisher +
                ", categories=" + categories +
                '}';
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        } else if (object == null || getClass() != object.getClass()) {
            return false;
        }

        Book book = (Book) object;
        return  Objects.equals(id, book.id) &&
                Objects.equals(title, book.title) &&
                Objects.equals(description, book.description) &&
                Objects.equals(author, book.author) &&
                Objects.equals(isbn, book.isbn) &&
                Objects.equals(categories, book.categories) &&
                Objects.equals(price, book.price) &&
                Objects.equals(publisher, book.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, author, isbn, categories, price, publisher);
    }
}
