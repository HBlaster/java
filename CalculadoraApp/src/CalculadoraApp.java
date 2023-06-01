import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {

        Scanner consola = new Scanner(System.in);
        System.out.println("**** Aplicacion Calculadora****");

        while (true) {
            mostrarMenu();
            try {
                var operacion = Integer.parseInt(consola.nextLine());
                //Revisar que este dentro de las opciones mencionadas

                if (operacion >= 1 && operacion <= 4) {

                    ejecutarOperaion(operacion, consola);

                } else if (operacion == 5) { //salir

                    System.out.println("Hasta pronto...");
                    break;

                } else {
                    System.out.println("Operacion erronea");
                }
                //Imprimir salto antes de repetir el ciclo
                System.out.println();
            } //fin de try
            catch (Exception e){
                System.out.println("ocurrio un error: " + e.getMessage());
            }
        } //fin de while

    } //fin de main
    private static void mostrarMenu(){
        //Mostrar el menu
        System.out.println("""
                    1. Suma
                    2. Resta
                    3. Multiplicacion
                    4. Division
                    5. Salir
                    """);
        System.out.print("Operacion a realizar: ");
    }
    private static void ejecutarOperaion(int operacion, Scanner consola){
        System.out.print("Proporciona valor uno: ");
        var operando1 = Double.parseDouble(consola.nextLine());
        System.out.print("Proporciona valor dos: ");
        var operando2 = Double.parseDouble(consola.nextLine());
        double resultado;
        switch (operacion) {
            case 1 -> {
                resultado = operando1 + operando2;
                System.out.println("El resultado de la suma es: " + resultado);
            }
            case 2 -> {
                resultado = operando1 - operando2;
                System.out.println("El resultado de la resta es: " + resultado);
            }
            case 3 -> {
                resultado = operando1 * operando2;
                System.out.println("El resultado de la multiplicacion es: " + resultado);
            }
            case 4 -> {
                resultado = operando1 / operando2;
                System.out.println("El resultado de la division es: " + resultado);
            }
            default -> System.out.println("opcion erroena: " + operacion);

        }
    }
} //fin de class
