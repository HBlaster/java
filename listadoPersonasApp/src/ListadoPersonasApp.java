import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class ListadoPersonasApp {

    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);

        //Se define la lista fuera del ciclo while
        List<Persona> personas = new ArrayList<>();
        //Menu de listado
        var salir = false;
        while(!salir){
            mostrarMenu();
            try {
                salir = ejecutarOperacion(consola, personas);
            } catch (Exception e){
                System.out.println("ocurrio un error: " + e.getMessage());
            }

            System.out.println();
        }
    }

    private static void mostrarMenu(){
        //Mostrar las opciones
        System.out.print("""
                ***Listado Personas App
                1. Agregar
                2. Listar
                3. Salir
                """);
        System.out.print("Poporciona la opcion deseada: ");
    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        //Se revisa la opcion proporcionada
        switch (opcion){
            case 1 ->{ // Agregar persona a la lista
                System.out.println("Proporciona el nombre: ");
                var nombre = consola.nextLine();
                System.out.println("Proporciona el telefono: ");
                var tel = consola.nextLine();
                System.out.println("Proporciona el email: ");
                var email = consola.nextLine();

                //Crear el objeto Persona
                var persona = new Persona(nombre, tel, email);

                //Lo agregamos a la lista
                personas.add(persona);
                System.out.println("La lista tiene: "+personas.size()+ " elementos");

            } //fin caso 1
            case 2->{//listado de personas
                System.out.println("Listado de personas: ");
                //mejora usando lambda y metodo de refrencia
                //personas.forEach((persona)-> System.out.println(persona));
                personas.forEach(System.out::println);
            }
            case 3 ->{
                System.out.println("Hasta pronto...");
                salir=true;
            }
            default -> System.out.println("opcion erronea: "+opcion);
        } //fin de switch
        return salir;
    }
}