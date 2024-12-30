package com.ph.project.GerenciadorLivraria.repository;

import com.ph.project.GerenciadorLivraria.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
