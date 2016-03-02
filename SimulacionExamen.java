import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SimulacionExamen extends JFrame{
  //Declaracion de variables
  JLabel lblLat=new JLabel("Latitud");
  JLabel lblELat=new JLabel("Latitud Incorrecta formato xx/xx/xx");
  JLabel lblLon=new JLabel("Longitud");
  JLabel lblELon=new JLabel("Longitud Incorrecta formato xx/xx/xx");
  JTextField txtLat=new JTextField(15);
  JTextField txtLon=new JTextField(15);
  JButton btnValidar=new JButton("Validar");
  Container cont;

  public void componentes(){
    cont.setLayout(new GridBagLayout());
    GridBagConstraints gbc=new GridBagConstraints();
    gbc.gridx=0;
    gbc.gridy=0;
    cont.add(lblLat,gbc);
    gbc.gridx=1;
    cont.add(txtLat,gbc);
    gbc.gridy=1;
    cont.add(lblELat,gbc);
    gbc.gridx=0;
    gbc.gridy=2;
    cont.add(lblLon,gbc);
    gbc.gridx=1;
    cont.add(txtLon,gbc);
    gbc.gridy=3;
    cont.add(lblELon,gbc);
    gbc.gridy=4;
    gbc.gridx=GridBagConstraints.REMAINDER;
    gbc.gridwidth=GridBagConstraints.REMAINDER;
    gbc.anchor=GridBagConstraints.CENTER;
    cont.add(btnValidar,gbc);
  }

  public boolean validarLat(){
    String[] lat=txtLat.getText().split("/");
    try{
    if(lat.length>3){
      lblELat.setVisible(true);
      return false;
    }
    if(Float.parseFloat(lat[0])>360 || Float.parseFloat(lat[0])<-360){
      lblELat.setVisible(true);
      return false;
    }
    if(Float.parseFloat(lat[1])>60){
      lblELat.setVisible(true);
      return false;
    }
    if(Float.parseFloat(lat[2])>60){
      lblELat.setVisible(true);
      return false;
    }
  }catch(NumberFormatException e){
    return false;
  }
    lblELat.setVisible(false);
    return true;
  }
  public boolean validarLon(){
    String[] lon=txtLat.getText().split("/");
    try{
    if(lon.length>3){
      lblELon.setVisible(true);
      return false;
    }
    if(Float.parseFloat(lon[0])>360 || Float.parseFloat(lon[0])<-360){
      lblELon.setVisible(true);
      return false;
    }
    if(Float.parseFloat(lon[1])>60){
      lblELon.setVisible(true);
      return false;
    }
    if(Float.parseFloat(lon[2])>60){
      lblELon.setVisible(true);
      return false;
    }
  }catch(NumberFormatException e){
    return false;
  }
    lblELon.setVisible(false);
    return true;
  }

  public void eventos(){
    btnValidar.addActionListener(e -> {
      validarLat();
    });
  }

  public SimulacionExamen(){
    super("Latitud y Longitud");
    initVentana();
    componentes();
    eventos();
  }
  public void initVentana(){
    this.setVisible(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(500,300);
    cont=this.getContentPane();
    lblELat.setVisible(false);
    lblELon.setVisible(false);
  }
  public static void main(String[] args){
    new SimulacionExamen();
  }
}
