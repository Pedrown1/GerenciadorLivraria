package com.ph.project.GerenciadorLivraria.service;

import com.ph.project.GerenciadorLivraria.dto.BookDTO;
import com.ph.project.GerenciadorLivraria.dto.MessageResponseDTO;
import com.ph.project.GerenciadorLivraria.entity.Author;
import com.ph.project.GerenciadorLivraria.entity.Book;
import com.ph.project.GerenciadorLivraria.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private BookRepository repository;

    @Autowired
    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public MessageResponseDTO create(BookDTO bookDTO) {
        // Converte o AuthorDTO em Author
        Author author = new Author(bookDTO.getAuthor().getId(), bookDTO.getAuthor().getName(), bookDTO.getAuthor().getAge());

        // Usando o builder para criar o objeto Book
        Book bookToSave = new Book.Builder()
                .withName(bookDTO.getName())
                .withPages(bookDTO.getPages())
                .withChapters(bookDTO.getChapters())
                .withIsbn(bookDTO.getIsbn())
                .withPublisherName(bookDTO.getPublisherName())
                .withAuthor(author) // Passando o Author convertido
                .build();

        // Salvando o livro
        Book savedBook = repository.save(bookToSave);

        // Retornando a resposta com a mensagem
        return new MessageResponseDTO.Builder()
                .withMessage("Livro Criado com ID - " + savedBook.getId())
                .build();
    }




}
