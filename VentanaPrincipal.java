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
      Container contentPane=this.getContentPane();

      //Agregar barra menu
      contentPane.add(new JScrollPane(msgText),BorderLayout.CENTER);
      contentPane.add(msgLabel,BorderLayout.SOUTH);

      //agregar menu
      JMenuBar menuBar=getCustomMenuBar();
      this.setJMenuBar(menuBar);

      //Crear menu emergente
      createPopupMenu();
  }

  private JMenuBar getCustomMenuBar(){
    JMenuBar menuBar=new JMenuBar();

    //Menu Archivo y Ayuda
    JMenu fileMenu=getFileMenu();
    JMenu helpMenu=getHelpMenu();

    //Agregar los menus a la barra de menu
    menuBar.add(fileMenu);
    menuBar.add(helpMenu);

    return menuBar;
  }

  private JMenu getFileMenu(){
    JMenu fileMenu=new JMenu("Archivo");

    //Alt-F tecla rapida
    fileMenu.setMnemonic(KeyEvent.VK_O);

    //Preparar un menu que contedra submenus
    JMenu newMenu=getNewMenu();
    fileMenu.add(newMenu);
    JMenuItem openMenuItem=new JMenuItem("Abrir",KeyEvent.VK_B);
    JMenuItem exitMenuItem=new JMenuItem("Salir",KeyEvent.VK_S);

    fileMenu.add(openMenuItem);
    fileMenu.addSeparador();
    fileMenu.add(exitMenuItem);

    //Agregar action listener al menu salir(lambda)
    exitMenuItem.addActionListener(e -> System.exit(0));

    return fileMenu;
  }

  private JMenu getNewMenu(){
    JMenu newMenu=new JMenu("Nuevo");

    //submenus
    JMenuItem policyMenuItem=new JMenuItem("Politicas",KeyEvent.VK_P);
    JMenuItem claimMenuItem=new JMenuItem("Reclamo",KeyEvent.VK_R);
    newMenu.add(policyMenuItem);
    newMenu.add(claimMenuItem);

    return newMenu;
  }

  private JMenu getHelpMenu(){
    JMenu helpMenu=new JMenu("Ayuda");
    helpMenu.setMnemonic(KeyEvent.VK_Y);

    JMenuItem indexMenuItem=new JMenuItem("Index",KeyEvent.VK_I);
    JMenuItem aboutMenuItem=new JMenuItem("Acerca de ",KeyEvent.VK_A);
  }
  public static void main(String[] args){

  }
}
