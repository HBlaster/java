import java.util.Scanner;
public class Huella{
  public static void main(String args[]){
  
    Scanner entrada = new Scanner (System.in);
    int Puerta = 0;
    int clave = 0;
    System.out.println ("*****************************************************************");
    System.out.println ("*ESTA ES UNA SIMULACION DE UN CORTA CORRIENTE CON HUELLA DIGITAL*");
    System.out.println ("*****************************************************************");
    System.out.println ("PUERTA ABIERTA (1), PUERTA CERRADA (0)");
    System.out.println (" ");
    System.out.println ("INGRESE EL NUMERO:");
    Puerta = entrada.nextInt();
    System.out.println (" ");


    if(Puerta == 1)
    {

    int i = 0;
    do{
       System.out.println ("**************************");
       System.out.println ("*LA PUERTA ESTA ABIERTA!!*");
       System.out.println ("**************************");
       System.out.println (" ");
       System.out.println ("HUELLA DIGITAL: CORRECTA (1), INCORRECTA (0)");
       System.out.println (" ");
       System.out.println ("INGRESE EL NUMERO");
       clave = entrada.nextInt();
       System.out.println (" ");     

    if(clave == 1) 
                   {   
                   System.out.println ("**********************************");
                   System.out.println ("*HUELLA CORRECTA MOTOR ENCIENDE!!*");
                   System.out.println ("**********************************");               
                   System.out.println (" ");
                   i=5;}
                   else {
                   System.out.println ("**********************************");
                   System.out.println ("*HUELLA INCORRECTA MOTOR NO ENCIENDE!!*");
                   System.out.println ("**********************************");               
                   System.out.println (" ");
                   i +=1; }
      

    
    }while (i<=5);


  }


  			
 }    
}