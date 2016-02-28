import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame{
  JLabel msgLabel=new JLabel("Boton derecho para menu emergente");
  JTextArea msgText=new JTextArea(10,60);
  JPopupMenu popupMenu =new JPopupMenu();

  public VentanaPrincipal(String titulo){
  super(titulo);
  initVentana();
  }
  //inicializar la ventana agregar componentes
  private void initVentana(){
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
  }
}
