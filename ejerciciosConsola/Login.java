import java.util.Scanner;

public class Login{
  public static void main (String args[]){
  
  String usuario= "", password= "";
  Scanner entrada= new Scanner (System.in);

  System.out.print("Ingresa nombre de usuario:");
  usuario = entrada.nextLine();

  System.out.print("Ingresa clave:");
  password = entrada.nextLine();

  if (usuario.equals("ernesto")&& password.equals("123456"))
  {
    System.out.println("Inicio de sesion correcto");}
  else
  {System.out.println("NOMBRE DE USUARIO O CLAVE INCORRECTOS!!"); }

 }
}