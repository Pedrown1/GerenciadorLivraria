package com.ph.project.GerenciadorLivraria.dto;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

public class BookDTO {

    private Long id;

    @NotBlank
    @Size(max = 200)
    private String name;

    @NotNull
    private Integer pages;

    @NotNull
    private Integer chapters;

    @NotBlank
    @Size(max = 100)
    @Pattern(regexp = "^(?:ISBN(?:-10)?:?)?(?:[0-9X]{10}|[0-9]{13})$", message = "ISBN não está no formato correto!")
    private String isbn;

    @NotBlank
    @Size(max = 200)
    private String publisherName;

    @NotNull
    @Valid
    private AuthorDTO author;

    public BookDTO(Long id, String name, Integer pages, Integer chapters, String isbn, String publisherName, AuthorDTO author) {
        this.id = id;
        this.name = name;
        this.pages = pages;
        this.chapters = chapters;
        this.isbn = isbn;
        this.publisherName = publisherName;
        this.author = author;
    }
    public BookDTO(){}

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

    public AuthorDTO getAuthor() {
        return author;
    }

    public void setAuthor(AuthorDTO author) {
        this.author = author;
    }
}
