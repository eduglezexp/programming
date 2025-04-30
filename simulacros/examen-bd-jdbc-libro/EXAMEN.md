# Examen de Gestión de Préstamos (BD)

<img src="https://www.brandeis.edu/global/student-insights/images/midterm-2.jpg" alt="Texto alternativo" width="350" >

Este ejercicio está diseñado para gestionar una base de datos de préstamos de libros, donde se realiza un seguimiento de autores, libros, usuarios y los préstamos correspondientes. El ejercicio consiste en implementar distintas operaciones en CRUD (Crear, Consultar, Actualizar, Eliminar, etc de las entidades). Algunas de estas tablas de base de datos almacenan fechas en formato **yyyy-MM-dd**, que hay que tener en cuenta.

## Descripción General

El sistema tiene las siguientes entidades:

1. **Autor**: Representa a los autores de los libros.
2. **Libro**: Representa a los libros disponibles en el sistema.
3. **Usuario**: Representa a los usuarios que pueden solicitar préstamos de libros.
4. **Préstamo**: Representa los préstamos que los usuarios hacen de los libros.

El sistema debe ofrecer los siguientes servicios:

- **AutorService**: Gestiona la creación, lectura, actualización y eliminación de autores.
- **LibroService**: Gestiona la creación, lectura, actualización y eliminación de libros.
- **UsuarioService**: Gestiona la creación, lectura, actualización y eliminación de usuarios.
- **PrestamoService**: Gestiona la creación, lectura, actualización y eliminación de préstamos.


## 1. **`AutorService`**

La clase `AutorService` gestiona las operaciones relacionadas con la entidad `Autor` en la base de datos.

### Métodos

- **`crearAutor(Autor autor)`**:
  - **Descripción**: Inserta un nuevo autor en la base de datos.
  - **Parámetros**: Un objeto `Autor` con la información del autor.
  - **Retorno**: `true` si la inserción fue exitosa, de lo contrario, `false`.
  
- **`obtenerTodosAutores()`**:
  - **Descripción**: Obtiene todos los autores registrados en la base de datos.
  - **Retorno**: Una lista de objetos `Autor`, una **lista vacía** en caso contrario.

- **`obtenerAutorPorDni(String dni)`**:
  - **Descripción**: Obtiene un autor de la base de datos a partir del DNI proporcionado.
  - **Parámetros**: El DNI del autor a buscar.
  - **Retorno**: Un objeto `Autor` si existe el autor con ese DNI, o `null` si no se encuentra.

- **`actualizarAutor(Autor autor)`**:
  - **Descripción**: Actualiza la información de un autor existente en la base de datos.
  - **Parámetros**: Un objeto `Autor` con la nueva información.
  - **Retorno**: `true` si la actualización fue exitosa, de lo contrario, `false`.

- **`eliminarAutor(String dni)`**:
  - **Descripción**: Elimina un autor de la base de datos si no está asociado con ningún libro.
  - **Parámetros**: El DNI del autor a eliminar.
  - **Retorno**: `true` si el autor fue eliminado correctamente, de lo contrario, `false`.

---

## 2. **`LibroService`**

La clase `LibroService` gestiona las operaciones relacionadas con la entidad `Libro` en la base de datos.

### Métodos

- **`crearLibro(Libro libro)`**:
  - **Descripción**: Inserta un nuevo libro en la base de datos.
  - **Parámetros**: Un objeto `Libro` con la información del libro.
  - **Retorno**: `true` si la inserción fue exitosa, de lo contrario, `false`.

- **`obtenerTodosLibros()`**:
  - **Descripción**: Obtiene todos los libros registrados en la base de datos.
  - **Retorno**: Una lista de objetos `Libro`. Una **lista vacía** en caso contrario.

- **`obtenerLibroPorId(String idLibro)`**:
  - **Descripción**: Obtiene un libro de la base de datos a partir del ID proporcionado.
  - **Parámetros**: El ID del libro a buscar.
  - **Retorno**: Un objeto `Libro` si existe el libro con ese ID, o `null` si no se encuentra.

- **`actualizarLibro(Libro libro)`**:
  - **Descripción**: Actualiza la información de un libro existente en la base de datos.
  - **Parámetros**: Un objeto `Libro` con la nueva información.
  - **Retorno**: `true` si la actualización fue exitosa, de lo contrario, `false`.

- **`eliminarLibro(String idLibro)`**:
  - **Descripción**: Elimina un libro de la base de datos.
  - **Parámetros**: El ID del libro a eliminar.
  - **Retorno**: `true` si el libro fue eliminado correctamente, de lo contrario, `false`.

---

## 3. **`UsuarioService`**

La clase `UsuarioService` gestiona las operaciones relacionadas con la entidad `Usuario` en la base de datos.

### Métodos

- **`crearUsuario(Usuario usuario)`**:
  - **Descripción**: Inserta un nuevo usuario en la base de datos.
  - **Parámetros**: Un objeto `Usuario` con la información del usuario.
  - **Retorno**: `true` si la inserción fue exitosa, de lo contrario, `false`.

- **`obtenerTodosUsuarios()`**:
  - **Descripción**: Obtiene todos los usuarios registrados en la base de datos.
  - **Retorno**: Una lista de objetos `Usuario`. Una **lista vacía** en caso contrario.

- **`obtenerUsuarioPorId(String idUsuario)`**:
  - **Descripción**: Obtiene un usuario de la base de datos a partir del ID proporcionado.
  - **Parámetros**: El ID del usuario a buscar.
  - **Retorno**: Un objeto `Usuario` si existe el usuario con ese ID, o `null` si no se encuentra.

- **`actualizarUsuario(Usuario usuario)`**:
  - **Descripción**: Actualiza la información de un usuario existente en la base de datos.
  - **Parámetros**: Un objeto `Usuario` con la nueva información.
  - **Retorno**: `true` si la actualización fue exitosa, de lo contrario, `false`.

- **`eliminarUsuario(String idUsuario)`**:
  - **Descripción**: Elimina un usuario de la base de datos.
  - **Parámetros**: El ID del usuario a eliminar.
  - **Retorno**: `true` si el usuario fue eliminado correctamente, de lo contrario, `false`.

## 4. **`PrestamoService`**

La clase `PrestamoService` gestiona las operaciones relacionadas con la entidad `Prestamo` en la base de datos. Hereda de `DBConnection` y utiliza sentencias SQL para llevar a cabo las operaciones de inserción, actualización, consulta y eliminación de préstamos.

### Métodos

- **`crearPrestamo(Prestamo prestamo)`**:
  - **Descripción**: Inserta un nuevo préstamo en la base de datos.
  - **Parámetros**: Un objeto `Prestamo` con la información del préstamo.
  - **Retorno**: `true` si la inserción fue exitosa; `false` si hay campos nulos o ocurre un error.

- **`obtenerTodosPrestamos()`**:
  - **Descripción**: Recupera todos los registros de préstamos almacenados en la base de datos.
  - **Retorno**: Una lista de objetos `Prestamo`. Una **lista vacía** en caso contrario.

- **`obtenerPrestamoPorId(String id)`**:
  - **Descripción**: Busca un préstamo específico por su ID.
  - **Parámetros**: ID del préstamo a buscar.
  - **Retorno**: Un objeto `Prestamo` si se encuentra; de lo contrario, `null`.

- **`actualizarPrestamo(Prestamo prestamo)`**:
  - **Descripción**: Actualiza los datos de un préstamo existente.
  - **Parámetros**: Un objeto `Prestamo` con la información actualizada.
  - **Retorno**: `true` si la actualización fue exitosa; `false` si hay campos nulos o ocurre un error.

- **`eliminarPrestamo(String id)`**:
  - **Descripción**: Elimina un préstamo específico de la base de datos.
  - **Parámetros**: ID del préstamo a eliminar.
  - **Retorno**: `true` si la eliminación fue exitosa; de lo contrario, `false`.

- **`obtenerPrestamosVencidos(Date fechaLimite)`**:
  - **Descripción**: Obtiene todos los préstamos cuya fecha de devolución es anterior a una fecha límite especificada.
  - **Parámetros**: Objeto `Date` que representa la fecha límite.
  - **Retorno**: Lista de objetos `Prestamo` que están vencidos. Una **lista vacía** en caso contrario.

- **`obtenerPrestamosPorUsuario(String idUsuario)`**:
  - **Descripción**: Filtra y retorna los préstamos asociados a un usuario específico.
  - **Parámetros**: ID del usuario.
  - **Retorno**: Lista de préstamos correspondientes al usuario.

- **`obtenerPrestamosActivos()`**:
  - **Descripción**: Recupera los préstamos cuya fecha de devolución es posterior a la fecha actual (es decir, aún activos).
  - **Retorno**: Lista de préstamos activos.


## Flujo de Ejecución en la Clase `PruebaApp`

En la clase `PruebaApp`, se realizan diversas pruebas para interactuar con los servicios y mostrar los resultados:

1. **Crear Autor, Libro, Usuario y Préstamo**: Se crean instancias de las entidades y se insertan en la base de datos.
   
   Ejemplo de datos creados:
   - Autor: "Gabriel García Márquez" (DNI `12345678A`).
   - Libro: "Cien años de soledad" (ID `LIB-001`).
   - Usuario: "Juan Pérez" (ID `USR001`).
   - Préstamo: ID `PRE001` con libro `LIB-001` y usuario `USR001`.

2. **Mostrar Todos los Registros**: El sistema muestra todos los autores, libros, usuarios y préstamos almacenados en la base de datos.

3. **Ejecutar Métodos Lógicos**: Se ejecutan los métodos lógicos para mostrar los resultados específicos de los préstamos vencidos, activos y por usuario.

---

## Ejemplo de Ejecución y Respuestas Esperadas

### Método `crearAutor()`

- **Acción**: Crea un nuevo autor "Gabriel García Márquez".
- **Resultado Esperado**: 

### Método `crearLibro()`

- **Acción**: Crea un nuevo libro "Cien años de soledad".
- **Resultado Esperado**:

### Método `crearUsuario()`

- **Acción**: Crea un nuevo usuario "Juan Pérez".
- **Resultado Esperado**:

### Método `crearPrestamo()`

- **Acción**: Crea un préstamo para el libro "Cien años de soledad" por parte del usuario "Juan Pérez".
- **Resultado Esperado**:

### Método `mostrarAutores()`

- **Acción**: Muestra todos los autores.
- **Resultado Esperado**:

### Método `mostrarLibros()`

- **Acción**: Muestra todos los libros.
- **Resultado Esperado**:

### Método `mostrarUsuarios()`

- **Acción**: Muestra todos los usuarios.
- **Resultado Esperado**:

### Método `mostrarPrestamos()`

- **Acción**: Muestra todos los préstamos.
- **Resultado Esperado**:

### Método `prestamosPorUsuario("USR001")`

- **Acción**: Muestra todos los préstamos realizados por el usuario con ID `USR001`.
- **Resultado Esperado**:

### Método `prestamosVencidos("2024-04-01")`

- **Acción**: Muestra los préstamos vencidos antes de la fecha `2024-04-01`.
- **Resultado Esperado**:

### Método `prestamosActivos()`

- **Acción**: Muestra todos los préstamos activos.
- **Resultado Esperado**:

---

## Calidad de la solución

<img src="https://w7.pngwing.com/pngs/995/92/png-transparent-exclamation-mark-interjection-warning-sign-red-exclamation-point-miscellaneous-angle-triangle.png" alt="Texto alternativo" width="100" >



A través de los test se verificará la calidad de la solución, teniendo en cuenta que si obtienes un mensaje similar al siguiente:

```code
[WARNING] Rule violated for class es.ies.puerto.PruebaApp: complexity total count is 26, but expected maximum is 25
[WARNING] Rule violated for class es.ies.puerto.modelo.db.services.PrestamoService: complexity total count is 26, but expected maximum is 25
[INFO] ------------------------------------------------------------------------
[INFO] BUILD FAILURE
[INFO] ------------------------------------------------------------------------
[INFO] Total time:  4.280 s
```

> Significa que los test pasan pero **la SOLUCIÓN NO** tiene la calidad suficiente por los *métodos que forman la clase*. Lo mismo modo puede suceder con los métodos de forma independiente.

---

## Conclusión

Este proyecto permite gestionar autores, libros, usuarios y préstamos a través de una base de datos. Los métodos lógicos proporcionan información sobre préstamos vencidos, activos y préstamos asociados a un usuario en particular. Al ejecutar la clase `PruebaApp`, se realiza la interacción con el sistema y se obtienen los resultados esperados en función de las operaciones realizadas.

## 📊 Rúbrica de Evaluación por Clase y Método – Total: 10 puntos

> Evaluación basada en la implementación, lógica, calidad del código y documentación técnica.

---

### 🔹 Conexión a Base de Datos (0.75 puntos)

| Elemento                                | Descripción                                                                      | Puntos |
|-----------------------------------------|----------------------------------------------------------------------------------|--------|
| Lectura desde fichero `.properties`     | Implementación de lectura de propiedades (usuario, password, url, driver)       | 0.25   |
| Uso correcto en clases hijas, si fuera necesario | Correcto uso de abstracción y reutilización  | 0.25   |
| Calidad y manejo de errores             | Control de excepciones, cierre de recursos, claridad en la implementación       | 0.25   |

---

### 🔹 UsuarioService (1.25 puntos)

| Elemento                | Descripción                              | Puntos |
|------------------------|------------------------------------------|--------|
| `crearUsuario`         | Inserta un nuevo usuario                 | 0.2    |
| `obtenerUsuarioPorId`  | Consulta un usuario por ID               | 0.2    |
| `obtenerTodosUsuarios` | Lista todos los usuarios                 | 0.2    |
| `actualizarUsuario`    | Modifica un usuario existente            | 0.2    |
| `eliminarUsuario`      | Elimina un usuario                       | 0.2    |
| Calidad + Documentación| Buenas prácticas + comentarios           | 0.25   |

---

### 🔹 AutorService (1.25 puntos)

| Elemento               | Descripción                               | Puntos |
|-----------------------|-------------------------------------------|--------|
| `crearAutor`          | Inserta un nuevo autor                    | 0.2    |
| `obtenerAutorPorDni`  | Consulta un autor por DNI                 | 0.2    |
| `obtenerTodosAutores` | Lista todos los autores                   | 0.2    |
| `actualizarAutor`     | Modifica un autor existente               | 0.2    |
| `eliminarAutor`       | Elimina un autor si no tiene libros       | 0.2    |
| Calidad + Documentación| Claridad y consistencia                  | 0.25   |

---

### 🔹 LibroService (1.25 puntos)

| Elemento               | Descripción                               | Puntos |
|-----------------------|-------------------------------------------|--------|
| `crearLibro`          | Inserta un nuevo libro                    | 0.2    |
| `obtenerLibroPorId`   | Consulta un libro por ID                  | 0.2    |
| `obtenerTodosLibros`  | Lista todos los libros                    | 0.2    |
| `actualizarLibro`     | Modifica un libro existente               | 0.2    |
| `eliminarLibro`       | Elimina un libro                          | 0.2    |
| Calidad + Documentación| Estilo y comentarios técnicos            | 0.25   |

---

### 🔹 PrestamoService (5.5 puntos)

| Elemento                          | Descripción                                                         | Puntos |
|----------------------------------|---------------------------------------------------------------------|--------|
| `crearPrestamo`                  | Inserta un nuevo préstamo                                           | 0.2    |
| `obtenerPrestamoPorId`           | Consulta un préstamo por ID                                        | 0.2    |
| `obtenerTodosPrestamos`          | Lista todos los préstamos                                          | 0.2    |
| `actualizarPrestamo`             | Modifica préstamo existente                                        | 0.2    |
| `eliminarPrestamo`               | Elimina un préstamo                                                | 0.2    |
| `obtenerPrestamosVencidos`       | Devuelve préstamos vencidos (lógica propia)                        | 0.6    |
| `obtenerPrestamosPorUsuario`     | Filtra préstamos por usuario (lógica propia)                       | 0.6    |
| `obtenerPrestamosActivos`        | Devuelve préstamos activos (lógica propia)                         | 0.6    |
| Validaciones de fechas           | Validación de `null`, formato y consistencia en las fechas         | 0.3    |
| Calidad general del código       | Excepciones, SQL seguro, limpieza de lógica                        | 0.45   |
| Documentación clara y completa   | JavaDoc, claridad de propósito, estructura                         | 0.45   |

---

### ✅ Total: **10 puntos**
