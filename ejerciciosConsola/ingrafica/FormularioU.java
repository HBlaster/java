import javax.swing.*;

public class FormularioU extends JFrame{
 
 private JLabel label1;
 private JLabel label2;

  public FormularioU(){
    setLayout(null);
    label1 = new JLabel("Interfaz grafica.");
    label1.setBounds(10,20,300,30);
    add(label1);
    label2 = new JLabel("Version 1.0");
    label2.setBounds(10,100,100,30);
    add(label2);
  }

  public static void main (String args[]){
    
    FormularioU formulario1_1= new FormularioU();
    formulario1_1 = new FormularioU();
    formulario1_1.setBounds (0,0,300,200);
    formulario1_1.setResizable(false);
    formulario1_1.setVisible(true);
    formulario1_1.setLocationRelativeTo(null);
 }  
}