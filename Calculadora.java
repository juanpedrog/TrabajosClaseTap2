import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class Calculadora extends JFrame implements FocusListener{
  JTextField valor1=new JTextField("0",5);
  JLabel mas=new JLabel("+");
  JTextField valor2=new JTextField("0",5);
  JLabel igual=new JLabel("=");
  JTextField suma=new JTextField("0",5);

  public Calculadora(){
    super("Suma de dos numeros");
    setSize(350,90);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    FlowLayout fl=new FlowLayout(FlowLayout.CENTER);
    Container cont=getContentPane();
    cont.setLayout(fl);

    //agregar listener
    valor1.addFocusListener(this);
    valor2.addFocusListener(this);

    //configuracion del campo suma
    suma.setEditable(false);

    //agregar componentes
    cont.add(valor1);
    add(mas);
    add(valor2);
    add(igual);
    add(suma);
    setVisible(true);

  }
  public void focusGained(FocusEvent e){
    try{
      Float total=Float.parseFloat(valor1.getText())+Float.parseFloat(valor2.getText());
      suma.setText(" "+total);
    }catch(NumberFormatException nfe){
      valor1.setText("0");
      valor2.setText("0");
      suma.setText("0");
    }
  }
  public void focusLost(FocusEvent e){
    focusGained(e);
  }
  public static void main(String[] args){
    Calculadora n=new Calculadora();
  }
}
