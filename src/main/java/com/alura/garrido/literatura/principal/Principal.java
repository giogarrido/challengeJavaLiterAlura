package com.alura.garrido.literatura.principal;

import com.alura.garrido.literatura.repository.LibroRepository;
import com.alura.garrido.literatura.service.ConsumoAPI;
import com.alura.garrido.literatura.service.ConvierteDatos;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    // autores entre rango de años
    //?author_year_start=1800&author_year_end=1899
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibroRepository repositorio;

    public Principal(LibroRepository repository) {
        this.repositorio = repository;
    }
//    private List<DatosLibro> datosLibros = new ArrayList<>();


    public void muestraElMenu() {
        var opcion = -1;
        while (opcion != 0) {
            var menu = """
                    Elija la opción a través de su número:
                    
                    1 - Buscar libro por titulo
                    2 - Listar libros registrados
                    3 - Listar autores registrados
                    4 - Listar autores vivos en un determinado año
                    5 - Listar libros por idioma
      
                    0 - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    buscarLibroWeb();
                    break;
                case 2:
                    buscarLibroRegistrado();
                    break;
                case 3:
                    buscarAutorRegistrado();
                    break;
                case 4:
                    buscarAutorVivoPorAnio();
                    break;
                case 5:
                    buscarLibroPorIdioma();
                    break;

                case 0:
                    System.out.println("Cerrando la aplicación...");
                    break;
                default:
                    System.out.println("Opción inválida");
            }
        }

    }

    private void buscarLibroWeb() {
        System.out.println("opcion 1");
        var json = consumoAPI.obtenerDatos(URL_BASE);
        System.out.println(json);
    }

    private void buscarLibroRegistrado() {
        System.out.println("opcion 2");
    }

    private void buscarAutorRegistrado() {
        System.out.println("opcion 3");
    }

    private void buscarAutorVivoPorAnio() {
        System.out.println("opcion 4");
    }

    private void buscarLibroPorIdioma() {
        System.out.println("opcion 5");
    }
}
