import javax.swing.*;
import java.awt.event.*;

public class FormularioD extends JFrame implements ActionListener {
  
  JButton boton1;
  public FormularioD(){
 
   setLayout(null);
   boton1 = new JButton("Cerrar");
   boton1.setBounds(280,280,100,30);
   add (boton1);
   boton1.addActionListener(this);
 }

 public void actionPerformed(ActionEvent a){
 
   if(a.getSource()== boton1){
     System.exit(0);
   }   
 }
 
 public static void main(String args []){
 
  FormularioD formulario1 = new FormularioD();
  formulario1.setBounds(0,0,400,350);
  formulario1.setVisible(true);
  formulario1.setResizable(false);
  formulario1.setLocationRelativeTo(null);
 }  
}

