package servicio;

import dominio.Pelicula;

import java.util.ArrayList;
import java.util.List;

public class ServicioPeliculasLista implements IServicioPeliculas {

    private final List<Pelicula> peliculas;

    public ServicioPeliculasLista(){
        this.peliculas = new ArrayList<>();
    }
    @Override
    public void listarPeliculas() {
        System.out.println("Listado de peliculas: ");
        peliculas.forEach(System.out::println);
    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {
        peliculas.add(pelicula);
        System.out.println("Se agrego la pelicula: "+pelicula);
    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {
        //Regresar el indice de la pelicula encontrada en la lista
        var indice = peliculas.indexOf(pelicula);
        if (indice ==-1)
            System.out.println("No se encontro la pelicula: "+ pelicula);
        else
        System.out.println("Pelicula encontrada en el indice: "+indice);
    }

    public static void main(String[] args) {
        //Se crean objetos de tipo pelicula para probar servicio
        var pelicula1 = new Pelicula("batman");
        var pelicula2 = new Pelicula("Superman");
        var pelicula3 = new Pelicula("ant man");
        //Creacion del servicio (patron de disenio service)
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();

        //Se agregan las peliculas a la lista
        servicioPeliculas.agregarPelicula(pelicula1);
        servicioPeliculas.agregarPelicula(pelicula2);

        //listar peliculas
        servicioPeliculas.listarPeliculas();

        //Buscar una pelicula
        //Se debe implementar el metodo equals y hashCode
        servicioPeliculas.buscarPelicula(pelicula3);

    }
}
