import java.util.Scanner;
public class OperacionesS{
  public static void main(String args []){
    Scanner entrada = new Scanner (System.in);
    int num_uno = 0, num_dos= 0, resultado = 0;
    int parametro = 0;
    
    
    System.out.println("¿Cual es la operacion a realizar?: ");
    System.out.println("1) Suma");
    System.out.println("2) Resta ");
    System.out.println("3) Multiplicacion");
    System.out.println("4) Division");
    parametro = entrada.nextInt();
    System.out.println(" ");

    System.out.println("¿Cual es el primer valor?: ");
    num_uno = entrada.nextInt();

    System.out.println("¿Cual es el segundo valor?: ");
    num_dos = entrada.nextInt();

    switch(parametro){
      case 1: resultado = num_uno + num_dos; 
              System.out.println("El resoltado de la suma es" +" "+ resultado) ;
              break;
      case 2: resultado = num_uno - num_dos; 
              System.out.println("El resoltado de la resta es" +" "+ resultado) ;
              break;
      case 3: resultado = num_uno * num_dos; 
              System.out.println("El resoltado de la multiplicacion es" +" "+ resultado) ;
              break;
      case 4: resultado = num_uno / num_dos; 
              System.out.println("El resoltado de la division es" +" "+ resultado) ;
              break;
      default: System.out.println("Error, la opcion no existe");
               break;
    }
  }

}
