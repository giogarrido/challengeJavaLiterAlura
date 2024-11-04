package com.alura.garrido.literatura.repository;

import com.alura.garrido.literatura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    Optional<Autor> findByNombreContainingIgnoreCase(String nombre);


    @Query("SELECT a FROM Autor a WHERE a.fechaNacimiento <= :anio AND (a.fechaMuerte IS NULL OR a.fechaMuerte > :anio )")
//    @Query("SELECT a FROM Autor a WHERE a.fechaNacimiento <= :year AND (a.fechaMuerte IS NULL OR a.fechaMuerte > :year)")
    List<Autor> autoresVivosEnAnio(int anio);


}
