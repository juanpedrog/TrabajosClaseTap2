import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SeleccionarFrameWork extends JFrame implements ItemListener{
  String[] frameworks={"Selecciona FrameWork",
                      "YII",
                      "Cake PHP",
                      "Zend",
                      "Akelos"};
  String[] descripciones={"The fast, secure and professional PHP framework",
                          "Cake PHP makes building web application simpler, faster and requir",
                          "The most popular framework for modern, hight-performing PHP application",
                          "Akelos PHP framework"};
  JComboBox<String> frameBox =new JComboBox(frameworks);
  JLabel descriptionLabel=new JLabel("");

  public SeleccionarFrameWork(){
    super("Selecciona framework de PHP");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(420,300);
    Container cont=getContentPane();

    frameBox.addItemListener(this);
    cont.add(frameBox,BorderLayout.NORTH);
    cont.add(descriptionLabel,BorderLayout.CENTER);
    setVisible(true);
  }
  //Override
  public void itemStateChanged(ItemEvent e){
    int choice=frameBox.getSelectedIndex();
    if(choice > 0){
      descriptionLabel.setText(descripciones[choice-1]);
    }else{
      descriptionLabel.setText("");
    }
  }
  //Override
  public Insets getInsets(){
    return new Insets(50,50,50,50);
  }
  public static void main(String[] args){
    SeleccionarFrameWork sf=new SeleccionarFrameWork();
  }
}
