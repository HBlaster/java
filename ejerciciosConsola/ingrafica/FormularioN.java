import javax.swing.*;
import java.awt.event.*;

public class FormularioN extends JFrame implements ItemListener{
 
 private JComboBox combo1;

 public FormularioN(){
  setLayout(null);
  combo1 = new JComboBox();
  combo1.setBounds(10,10,80,20);
  add(combo1);
  
  combo1.addItem("Rojo");
  combo1.addItem("Azul");
  combo1.addItem("Verde");
  combo1.addItem("Amarillo");
  combo1.addItem("Negro");
  combo1.addItemListener(this);
  }
 
 public void itemStateChanged(ItemEvent e){
  if(e.getSource() == combo1){
    String seleccion = combo1.getSelectedItem().toString();
    setTitle(seleccion);
  }
 }

 public static void main (String args[]){
  FormularioN formulario1 = new FormularioN();
  formulario1.setBounds(0,0,200,150);
  formulario1.setVisible(true);
  formulario1.setResizable(false);
  formulario1.setLocationRelativeTo(null);
 }
























}