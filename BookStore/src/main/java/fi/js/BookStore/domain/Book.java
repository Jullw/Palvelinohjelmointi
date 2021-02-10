package fi.js.BookStore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author jsaja
 */
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title, author, isbn;
    private int year, price;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "departmentid")
    private Category category;

    public Book() {
        super();
    }

    public Book(String title, String author, String isbn, int year, int price, Category category) {
        super();
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.year = year;
        this.price = price;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        if (this.category != null) {
            return "[ " + this.id + " : " + this.title + " : " + this.author + " : " + this.isbn + " : " + this.year + " : " + this.price +   this.getCategory() + "]";
        } else {
            return "[ " + this.id + " : " + this.title + " : " + this.author + " : " + this.isbn + " : " + this.year + " : " + this.price + "]";
        }
    }
}
