package com.ph.project.GerenciadorLivraria.controller;

import com.ph.project.GerenciadorLivraria.dto.BookDTO;
import com.ph.project.GerenciadorLivraria.dto.MessageResponseDTO;
import com.ph.project.GerenciadorLivraria.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {

    private BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }


    @PostMapping
    public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO){
        return service.create(bookDTO);
    }


}
