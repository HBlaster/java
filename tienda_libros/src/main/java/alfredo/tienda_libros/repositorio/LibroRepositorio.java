package alfredo.tienda_libros.repositorio;

import alfredo.tienda_libros.modelo.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepositorio extends JpaRepository<Libro, Integer> {

}
