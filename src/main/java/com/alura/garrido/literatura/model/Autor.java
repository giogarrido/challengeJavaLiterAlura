package com.alura.garrido.literatura.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private Integer fechaNacimiento;
    private Integer fechaMuerte;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;



    public Autor() {
    }
    public Autor (DatosLibro datosLibro){
        this.nombre = datosLibro.autor().get(0).nombre();
        this.fechaMuerte = datosLibro.autor().get(0).fechaMuerte();
        this.fechaNacimiento = datosLibro.autor().get(0).fechaNacimiento();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Integer fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Integer getFechaMuerte() {
        return fechaMuerte;
    }

    public void setFechaMuerte(Integer fechaMuerte) {
        this.fechaMuerte = fechaMuerte;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        libros.forEach(l ->l.setAutor(this));
        this.libros = libros;
    }

    @Override
    public String toString() {
        return
                "\n---------Autor---------" +
                "\nNombre: " + nombre + '\'' +
                "\nFechaNacimiento: " + fechaNacimiento + '\'' +
                "\nFechaMuerte: " + fechaMuerte + '\'' +
                "\nLibros: " + libros.stream().map(Libro::getTitulo).toList() +
                "\n-----------------------";
    }
}
