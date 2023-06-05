package alfredo.presentacion;

import alfredo.datos.EstudianteDAO;
import alfredo.dominio.Estudiante;

import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);
        // Se crea una instancia clase de servicio
        var estudianteDao = new EstudianteDAO();
        while (!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, estudianteDao);
            }
            catch (Exception e){
                System.out.println("Ocurrio un error al ejecutar operacion: "+ e.getMessage());
            }
            System.out.println();

        }//Fin while
    }

    private static void mostrarMenu() {
        System.out.print("""
                ***Sistema de estudiantes ***
                1. Listar estudiantes
                2. Buscar Estudiante
                3. Agregar Estudiante
                4. Modificar Estudiante
                5. Eliminar Estudiante
                6. Salir
                
                Elige una opcion:
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDAO){
        var opcion= Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 ->{ //Listar estudiantes
                System.out.println("Listado de estudiantes: ");
                var estudiantes = estudianteDAO.listarEstudiantes();
                estudiantes.forEach(System.out::println);
            }
            case 2->{ //Buscar estudiante por id
                System.out.println("Introduce el id del estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
                if(encontrado)
                    System.out.println("Estudiante encontrado: "+ estudiante);
                else
                    System.out.println("Estudiante no encontrado: "+ estudiante);
            }
            case 3 ->{ //Agregar estudiante
                System.out.println("Agregar estudiante: ");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();
                var nuevoEstudiante = new Estudiante(nombre, apellido,telefono,email);
                var agregado = estudianteDAO.agregarEstudiante(nuevoEstudiante);
                if(agregado)
                    System.out.println("Estudiante agregado: "+ nuevoEstudiante);
                else
                    System.out.println("Estudiante no agregado..." + nuevoEstudiante);
            }
            case 4 ->{ //Modificar Estudiante
                System.out.println("Modificar estudiante: ");
                System.out.print("Proporciona id del estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();
                var estudiante = new Estudiante(idEstudiante,nombre, apellido,telefono,email);
                var modificado = estudianteDAO.modificarEstudiante(estudiante);
                if (modificado)
                    System.out.println("Estudiante se modifico correctamente: "+estudiante);
                else
                    System.out.println("Estudiante no se pudo modificar... "+ estudiante);
            }
            case 5->{ // Eliminar estudiante
                System.out.println("Eliminar estudiante");
                System.out.print("Proporciona id del estudiante: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var eliminado = estudianteDAO.eliminarEstudiante(estudiante);
                if (eliminado)
                    System.out.println("Se elimino el estudiante: "+ eliminado);
                else
                    System.out.println("No se pudo eliminar el estudiante: "+estudiante);
            }
            case 6 ->{ //Salir del programa
                System.out.println("Hasta pronto...");
                salir = true;
            }
            default -> System.out.println("opcion incorrecta: "+ opcion);
        }
        return salir;
    }
}
