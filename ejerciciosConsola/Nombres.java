import java.util.Scanner;

public class Nombres{
  public static void main (String args []){
    String nombre_uno="", nombre_dos="";
    Scanner entrada = new Scanner (System.in);

    System.out.print("Porfavor ingresa el primer nombre:" + " ");
    nombre_uno = entrada.nextLine();

    System.out.print("Porfavor ingresa el segundo nombre:" + " ");
    nombre_dos = entrada.nextLine();

                                        /* si quieres que no distinga mayusculas y minusculas ".equalsIgnoreCase"*/

    if (nombre_uno.equals(nombre_dos)){
    System.out.print("El nombre es el mismo. ");
    }else {    System.out.print("El nombre no es el mismo. ");}
    
 } 
}