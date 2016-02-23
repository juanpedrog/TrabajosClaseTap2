import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class DosInterfaces extends JFrame implements MouseMotionListener,MouseListener{
  JTextField tf=new JTextField(30);
  JLabel label=new JLabel("Click y arrastra el raton");

  public DosInterfaces(){
    super("Dos Listeners");
  }
  public void abreMarco(){
    Container cont=getContentPane();
    cont.add(label,BorderLayout.NORTH);
    cont.add(tf,BorderLayout.SOUTH);

    this.addMouseMotionListener(this);
    this.addMouseListener(this);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(300,200);
    this.setVisible(true);
  }
  public void mouseDragged(MouseEvent e){
    String s="Arrastrando raton X="+e.getX()+" Y="+e.getY();
    tf.setText(s);
  }
  public void mouseEntered(MouseEvent e){
    String s="¡El raton ha entrado!";
    tf.setText(s);
  }
  public void mouseExited(MouseEvent e){
    String s="¡El raton ha salido!";
    tf.setText(s);
  }
  public void mouseMoved(MouseEvent e){}
  public void mousePressed(MouseEvent e){}
  public void mouseClicked(MouseEvent e){}
  public void mouseReleased(MouseEvent e){}
  public static void main(String[] args){
    DosInterfaces di=new DosInterfaces();
    di.abreMarco();
  }
}
