package com.alura.garrido.literatura.repository;

import com.alura.garrido.literatura.model.Idioma;
import com.alura.garrido.literatura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;



public interface LibroRepository extends JpaRepository<Libro,Long> {

    List<Libro> findByIdioma(Idioma idioma);

    @Query("SELECT l FROM Libro  l order by l.numeroDescargas DESC LIMIT 10")
    List<Libro> librosTop10Descargados();



}
