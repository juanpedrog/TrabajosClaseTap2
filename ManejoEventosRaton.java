import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.event.MouseListener;
import java.awt.event.MouseEvent;

public class ManejoEventosRaton extends JFrame{
  JButton mouseButton=new JButton("Sin eventos de movimiento aun");
  public ManejoEventosRaton(){
    super("Manejo de eventos del raton");
    this.initFrame();
  }
  private void initFrame(){
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new FlowLayout());
    this.getContentPane().add(mouseButton);

    //agregar un MouseListener al JButton
    mouseButton.addMouseListener(new MouseListener(){
    public void mouseClicked(MouseEvent e){/*Override*/}
    public void mousePressed(MouseEvent e){/*Override*/}
    public void mouseReleased(MouseEvent e){/*Override*/}
    public void mouseEntered(MouseEvent e){mouseButton.setText("Entrando al boton!");}
    public void mouseExited(MouseEvent e){mouseButton.setText("Saliendo del boton!");}
    });
  }
  public static void main(String[] args){
    ManejoEventosRaton frame=new ManejoEventosRaton();
    frame.pack();
    frame.setVisible(true);
  }
}
