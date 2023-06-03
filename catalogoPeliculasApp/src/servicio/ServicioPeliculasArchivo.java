package servicio;

import dominio.Pelicula;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ServicioPeliculasArchivo implements IServicioPeliculas{

    private final String NOMBRE_ARCHIVO = "peliculas.txt";

    public ServicioPeliculasArchivo(){
        var archivo = new File(NOMBRE_ARCHIVO);
        try {
            if(archivo.exists()){
                //Si ya existe el archivo no se vuelve a crear
                System.out.println("el archivo ya existe!");
            }
            else{
                //Si no existe, se crea vacio
                var salida = new PrintWriter(new FileWriter(archivo));
                salida.close();
                System.out.println("Se a creado el archivo");
            }

        }catch (Exception e){
            System.out.println("Ocurrio un error al abrir el archivo: "
            + e.getMessage());
        }
    }

    @Override
    public void listarPeliculas() {

    }

    @Override
    public void agregarPelicula(Pelicula pelicula) {

    }

    @Override
    public void buscarPelicula(Pelicula pelicula) {

    }
}
