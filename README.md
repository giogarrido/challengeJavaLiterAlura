# Challenge Java Liter Alura - Aplicación de Gestión de Libros

Este proyecto es una aplicación de consola desarrollada en Java con el patrón de diseño MVC (Modelo-Vista-Controlador), que permite gestionar un catálogo de libros y autores. Incluye la integración con la API de Gutendex para obtener información de libros.

## Características

- **Búsqueda de libros** por título y autor.
- **Listado de libros y autores** registrados en la base de datos.
- **Filtrado por idioma** de los libros.
- **Consulta de autores vivos** en un año determinado.
- **Top 10 de libros más descargados**.

## Funcionalidades

1. **Buscar libro por título**: Permite buscar libros en la base de datos por su título.
2. **Listar libros registrados**: Muestra todos los libros almacenados.
3. **Listar autores registrados**: Muestra todos los autores registrados en la base de datos.
4. **Listar autores vivos en un año**: Consulta qué autores estaban vivos en un año específico.
5. **Listar libros por idioma**: Filtra los libros según su idioma.
6. **Top 10 libros más descargados**: Muestra los 10 libros con más descargas.
7. **Buscar autor por nombre**: Permite buscar autores en la base de datos por su nombre.

## Tecnologías

- **Java**: Lenguaje de programación principal.
- **Spring Boot**: Framework utilizado para la estructura del proyecto.
- **API Gutendex**: Fuente de información sobre los libros.
- **MySQL**: Base de datos relacional utilizada para almacenar la información de los libros y autores.


## Requisitos

- **Java 17** o superior.
- **Maven** para la gestión de dependencias y construcción del proyecto.

## Instalación y Ejecución

1. **Clonar el repositorio**:
    ```bash
    git clone <URL_DEL_REPOSITORIO>
    cd <NOMBRE_DEL_PROYECTO>
    ```

2. **Compilar el proyecto**:
    ```bash
    mvn clean install
    ```

3. **Ejecutar la aplicación**:
    ```bash
    java -jar target/<NOMBRE_DEL_ARCHIVO_JAR>.jar
    ```
