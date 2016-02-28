import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class ConversionGrados extends JFrame {
  //Declaracion de variables
  JLabel lblcel=new JLabel("Celcius");
  JLabel lblfar=new JLabel("Farhenheit");
  JTextField txtcel=new JTextField(10);
  JTextField txtfar=new JTextField(10);
  JButton btncel=new JButton("Celcius");
  JButton btnfar=new JButton("Farhenheit");

  //Constructor
  public ConversionGrados(){
    super("Convertidor de grados");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
    setSize(400,200);
    Container cont=getContentPane();
    cont.setLayout(new GridBagLayout());
    GridBagConstraints gbc=new GridBagConstraints();
    gbc.gridx=0;
    gbc.gridy=0;
    cont.add(lblcel,gbc);
    gbc.gridx=1;
    cont.add(txtcel,gbc);
    gbc.gridx=2;
    cont.add(btncel,gbc);
    gbc.gridx=0;
    gbc.gridy=1;
    cont.add(lblfar,gbc);
    gbc.gridx=1;
    cont.add(txtfar,gbc);
    gbc.gridx=2;
    cont.add(btnfar,gbc);


    //
    btnfar.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        ctof();
      }
    });
    btncel.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        ftoc();
      }
    });
    txtcel.addKeyListener(new KeyListener(){
      public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==10){
          ctof();
        }
      }
      public void keyReleased(KeyEvent e){}
      public void keyTyped(KeyEvent e){}
    });
    txtfar.addKeyListener(new KeyListener(){
      public void keyPressed(KeyEvent e){
        if(e.getKeyCode()==10){
          ftoc();
        }
      }
      public void keyReleased(KeyEvent e){}
      public void keyTyped(KeyEvent e){}
    });
    //btnfar.addActionListener(this);
  }

  public void ftoc(){
    float f=Float.parseFloat(txtfar.getText());
    JOptionPane.showMessageDialog(null,f);
    float c=(f-32)*5/9;
    txtcel.setText(c+"");
  }
  public void ctof(){
    float c=Float.parseFloat(txtcel.getText());
    float f=((9/5)*c)+32;
    txtfar.setText(f+"");
  }


  //Main
  public static void main(String[] args){
    new ConversionGrados();
  }
}
