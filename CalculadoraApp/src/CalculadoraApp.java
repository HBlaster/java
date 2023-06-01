import java.util.Scanner;

public class CalculadoraApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        System.out.println("**** Aplicacion Calculadora****");
        //Mostrar el menu
        System.out.println("""
                1. Suma
                2. Resta
                3. Multiplicacion
                4. Division
                5. Salir
                """);
        System.out.print("Operacion a realizar: ");
        var operacion = Integer.parseInt(consola.nextLine());
        //Revisar que este dentro de las opciones mencionadas
        if(operacion >=1 && operacion<=4){
            System.out.print("Proporciona valor uno: ");
            var operando1 = Integer.parseInt(consola.nextLine());
            System.out.print("Proporciona valor uno: ");
            var operando2 = Integer.parseInt(consola.nextLine());
            int resultado;
            switch (operacion){
                case 1 ->{
                    resultado = operando1 + operando2;
                    System.out.println("El resultado de la suma es: "+ resultado);
                }
                case 2 ->{
                    resultado = operando1 - operando2;
                    System.out.println("El resultado de la resta es: "+resultado);
                }
                case 3 ->{
                    resultado = operando1 * operando2;
                    System.out.println("El resultado de la multiplicacion es: "+resultado);
                }
                case 4 ->{
                    resultado = operando1 / operando2;
                    System.out.println("El resultado de la division es: "+resultado);
                }
                default -> System.out.println("opcion erroena: " + operacion);

            }
        } else if (operacion == 5) { //salir
            System.out.println("Hasta pronto...");

        }
        else {
            System.out.println("Operacion erronea");
        }



    }
}
