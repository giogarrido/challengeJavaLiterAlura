package com.alura.garrido.literatura.repository;

import com.alura.garrido.literatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LibroRepository extends JpaRepository<Libro,Long> {
    Optional<Libro> findByTituloContainingIgnoreCase(String titulo);
    boolean existsByTitulo(String titulo);
}
