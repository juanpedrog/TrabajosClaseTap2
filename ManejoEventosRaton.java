import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ManejoEventosRaton extends JFrame {

   JButton mouseButton = new JButton("Sin eventos de movimiento aún");

   public ManejoEventosRaton() {
   super("Manejo de eventos del ratón");
   this.initFrame();
  }

 private void initFrame() {
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setLayout( new FlowLayout());
    this.getContentPane().add(mouseButton);

    //agregar un MouseListener al JButton
    mouseButton.addMouseListener( new MouseListener() {

    public void mouseEntered( MouseEvent e) { //override
        mouseButton.setText("Entrando al botón!");
    }
    public void mouseExited( MouseEvent e) { // override
       mouseButton.setText("Saliendo del botón");
    }
  });

 }

public static void main( String[] args) {
   ManejoEventosRaton frame = new ManejoEventosRaton();
   frame.pack();
   frame.setVisible(true);
 }

}
