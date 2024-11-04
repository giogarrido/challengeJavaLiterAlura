package com.alura.garrido.literatura.model;

import jakarta.persistence.*;

import java.util.OptionalDouble;

@Entity
@Table (name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String titulo;
    @Enumerated(EnumType.STRING)
    private Idioma idioma;
    private double numeroDescargas;
    @ManyToOne
    private Autor autor;

    public Libro() {
    }


    public Libro (DatosLibro datosLibro){
        this.titulo = datosLibro.titulo();
        this.idioma = Idioma.fromString(datosLibro.idioma().get(0));
        this.numeroDescargas = OptionalDouble.of(Double.valueOf(datosLibro.numeroDescargas().doubleValue())).orElse(0);


    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Idioma getIdioma() {
        return idioma;
    }

    public void setIdioma(Idioma idioma) {
        this.idioma = idioma;
    }

    public double getNumeroDescargas() {
        return numeroDescargas;
    }

    public void setNumeroDescargas(double numeroDescargas) {
        this.numeroDescargas = numeroDescargas;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return  "\n--------Libro--------" +
                "\nTitulo: " + titulo +
                "\nAutores: " + autor.getNombre() +
                "\nIdioma: " + idioma +
                "\nNumero de Descargas: " + numeroDescargas  +
                "\n---------------------";
    }
}
