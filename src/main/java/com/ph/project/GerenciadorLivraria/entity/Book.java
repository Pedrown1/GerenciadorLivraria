package com.ph.project.GerenciadorLivraria.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private Integer pages;

    @Column(nullable = false)
    private Integer chapters;

    @Column(nullable = false)
    private String isbn;

    @Column(name = "publisher_name", nullable = false, unique = true)
    private String publisherName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    @JoinColumn(name = "author_id")
    private Author author;

    public Book(Long id, String name, Integer pages, Integer chapters, String isbn, String publisherName, Author author) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.chapters = chapters;
        this.isbn = isbn;
        this.publisherName = publisherName;
        this.author = author;
    }
    public Book(){}

    // Método estático Builder
    public static class Builder {
        private Long id;
        private String name;
        private Integer pages;
        private Integer chapters;
        private String isbn;
        private String publisherName;
        private Author author;

        public Builder withId(Long id) {
            this.id = id;
            return this;
        }

        public Builder withName(String name) {
            this.name = name;
            return this;
        }

        public Builder withPages(Integer pages) {
            this.pages = pages;
            return this;
        }

        public Builder withChapters(Integer chapters) {
            this.chapters = chapters;
            return this;
        }

        public Builder withIsbn(String isbn) {
            this.isbn = isbn;
            return this;
        }

        public Builder withPublisherName(String publisherName) {
            this.publisherName = publisherName;
            return this;
        }

        public Builder withAuthor(Author author) {
            this.author = author;
            return this;
        }

        public Book build() {
            Book book = new Book();
            book.setId(this.id);
            book.setName(this.name);
            book.setPages(this.pages);
            book.setChapters(this.chapters);
            book.setIsbn(this.isbn);
            book.setPublisherName(this.publisherName);
            book.setAuthor(this.author);
            return book;
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getChapters() {
        return chapters;
    }

    public void setChapters(Integer chapters) {
        this.chapters = chapters;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
