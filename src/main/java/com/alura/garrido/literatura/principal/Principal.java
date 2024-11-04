package com.alura.garrido.literatura.principal;

import com.alura.garrido.literatura.model.*;
import com.alura.garrido.literatura.repository.AutorRepository;
import com.alura.garrido.literatura.repository.LibroRepository;
import com.alura.garrido.literatura.service.ConsumoAPI;
import com.alura.garrido.literatura.service.ConvierteDatos;
import org.springframework.dao.DataIntegrityViolationException;

import java.util.*;

public class Principal {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoAPI consumoAPI = new ConsumoAPI();
    private final String URL_BASE = "https://gutendex.com/books/";
    // autores entre rango de años
    //?author_year_start=1800&author_year_end=1899
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibroRepository libroRepository;
    private AutorRepository autorRepository;
    private List<Libro> libros;
    private List<Autor> autores;


    public Principal(AutorRepository autorRepository, LibroRepository libroRepository) {
        this.autorRepository = autorRepository;
        this.libroRepository = libroRepository;

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
                    6 - Top 10 libros mas descargados
                    7 - Buscar autor por nombre
                          
                    0 - Salir
                    """;
            System.out.println(menu);
            try {
                opcion = teclado.nextInt();
                teclado.nextLine();

                switch (opcion) {
                    case 1:
                        buscarLibroWeb();
                        break;
                    case 2:
                        listarLibroRegistrado();
                        break;
                    case 3:
                        listarAutorRegistrado();
                        break;
                    case 4:
                        buscarAutorVivoPorAnio();
                        break;
                    case 5:
                        buscarLibroPorIdioma();
                        break;
                    case 6:
                        buacarTop10LibrosDescargados();
                    case 7:
                        buscarAutorPorNombre();

                    case 0:
                        System.out.println("Cerrando la aplicación...");
                        break;
                    default:
                        System.out.println("Opción inválida");
                }
            } catch (InputMismatchException e) {
                System.out.println("Ingrese una opción valida");
                teclado.nextLine();
            }
        }

    }


    private Datos getDatosLibro() {
        System.out.println("Escribe el titulo del libro que desea buscar");
        var nombreLibro = teclado.nextLine();
        var json = consumoAPI.obtenerDatos(URL_BASE + "?search=" + nombreLibro.replace(" ", "%20"));
        System.out.println(json);
        Datos datos = conversor.obtenerDatos(json, Datos.class);
        System.out.println(datos);
        return datos;
    }

    private void buscarLibroWeb() {
        try {
            Datos datos = getDatosLibro();
            Libro libro = new Libro(datos.resultados().get(0));
            Autor autor = new Autor(datos.resultados().get(0));


            List<Libro> libros = new ArrayList<>();


            List<Autor> autorList = autorRepository.findAll();

            Optional<Autor> optionalAutor = autorList.stream()
                    .filter(a -> a.getNombre().contains(autor.getNombre()))
                    .findFirst();
            if (optionalAutor.isPresent()) {
                try{
                    var autorEncontrado = optionalAutor.get();
//            autorEncontrado.setLibros(librosAutor);
//            autorRepository.save(autorEncontrado);
                    libro.setAutor(autorEncontrado);
                    libroRepository.save(libro);
                    System.out.println(libro);
                }catch (DataIntegrityViolationException e){
                    System.out.println("El libro ya esta registrado");
                }



            } else {
                libros.add(libro);
                autor.setLibros(libros);
                autorRepository.save(autor);
                System.out.println(libro);
            }
        } catch (IndexOutOfBoundsException | IllegalArgumentException exception) {
            System.out.println("libro no encontrado");
        }


    }

    private void listarLibroRegistrado() {
        System.out.println("Libros Registrados\n");
        libros = libroRepository.findAll();

        libros.stream()
                .sorted(Comparator.comparing(Libro::getTitulo))
                .forEach(System.out::println);

    }

    private void listarAutorRegistrado() {
        System.out.println("Autores Registrados\n");
        autores = autorRepository.findAll();

        autores.stream()
                .sorted(Comparator.comparing(Autor::getNombre))
                .forEach(System.out::println);
    }

    private void buscarAutorVivoPorAnio() {
        System.out.println("opcion 4");
    }

    private void buscarLibroPorIdioma() {
        System.out.println("opcion 5");
    }

    private void buscarAutorPorNombre() {
    }

    private void buacarTop10LibrosDescargados() {
    }

}
