package com.alura.garrido.literatura.service;

import com.alura.garrido.literatura.model.Autor;
import com.alura.garrido.literatura.dto.DatosLibro;
import com.alura.garrido.literatura.model.Libro;
import com.alura.garrido.literatura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class LibroService {
    private final LibroRepository libroRepository;

    @Autowired
    public LibroService(LibroRepository libroRepository) {
        this.libroRepository = libroRepository;
    }

    @Transactional
    public void guardarLibro(DatosLibro datosLibro, Autor autor) {
        Libro libro = new Libro(datosLibro);

        if (libroRepository.existsByTitulo(libro.getTitulo())) {
            System.out.println("El libro " + libro.getTitulo() + " ya existe en la base de datos.");
            return;
        }

        // Verifica si el autor ya existe
        Optional<Libro> libroExistente = libroRepository.findAll()
                .stream()
                .filter(l -> l.getAutor().getNombre().equals(libro.getAutor().getNombre()))
                .findFirst();

        if (libroExistente.isPresent()) {
            libro.setAutor(libroExistente.get().getAutor());
        }

        // Guarda el libro con el autor (si es nuevo, el autor se guarda automáticamente)
        libroRepository.save(libro);
        System.out.println("Libro guardado exitosamente: " + libro.getTitulo());
    }
}
