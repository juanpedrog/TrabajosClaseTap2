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
    fileMenu.addSeparator();
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
    JMenuItem aboutMenuItem=new JMenuItem("Acerca de ",KeyEvent.VK_C);

    //selecciona la tecla f1 para el menu index
    KeyStroke f1Key=KeyStroke.getKeyStroke(KeyEvent.VK_F1,0);

    helpMenu.add(indexMenuItem);
    helpMenu.addSeparator();
    helpMenu.add(aboutMenuItem);

    //Selecciona actionlistener a index lambda
    indexMenuItem.addActionListener(e ->
      msgText.append("Has seleccionado Help >> menu Index,\n"));
      return helpMenu;
  }

  private void createPopupMenu(){
    //Crea menu emergente y agrega mouseListener al frame
    //para que se muestre el menu emergente cuando el usuario hace Click derecho
    JMenuItem popup1=new JMenuItem("Menu emergente 1");
    JMenuItem popup2=new JMenuItem("Menu emergente 2");
    JMenuItem popup3=new JMenuItem("Menu emergente 3");

    //Crea actionlistener
    ActionListener al=e -> {
        JMenuItem menuItem=(JMenuItem)e.getSource();
        String menuText=menuItem.getText();
        String msg="Has seleccionado "+menuText+" .\n";
        msgText.append(msg);
    };
    //Agrega el mismo actionlistener a los menus poup
    popup1.addActionListener(al);
    popup2.addActionListener(al);
    popup3.addActionListener(al);

    //agrega los elementos al popup
    popupMenu.add(popup1);
    popupMenu.add(popup2);
    popupMenu.add(popup3);

    //Crear mouseListener para mostrar el menu emergente
    MouseListener ml=new MouseAdapter(){
        @Override
        public void mousePressed(MouseEvent e){
          displayPopupMenu(e);
        }
        @Override
        public void mouseReleased(MouseEvent e){
          displayPopupMenu(e);
        }
    };

    //agrega MouseListener a label y textArea
    msgText.addMouseListener(ml);
    msgLabel.addMouseListener(ml);
  }

  private void displayPopupMenu(MouseEvent e){
    //Asegurarse que se muestra el popupMenu
    if(e.isPopupTrigger()){
      this.popupMenu.show(e.getComponent(),e.getX(),e.getY());
    }
  }
  public static void main(String[] args){
    VentanaPrincipal vPrincipal=new VentanaPrincipal("Ventana Principal");
    vPrincipal.pack();
    vPrincipal.setVisible(true);
  }
}
