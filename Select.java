import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;   
import javax.sound.sampled.*;

public class Select extends WindowAdapter implements ActionListener{

JFrame frame;
JPanel panel_select;
CheckboxGroup checkbox;
JCheckBox charmander, bulbasaur;
GridLayout grid;
JPanelBackground back;
Charmander charmanderChoice;
Bulbasaur bulbasaurChoice;
public Select(){}

public void ChoicePokegochi(){
    frame = new JFrame("Pokegochi");
    panel_select = new JPanel();
    grid = new GridLayout(0,2,1,1);
    back =new JPanelBackground(".\\Image\\fondo\\landscape_1.png");
    charmander = new JCheckBox("Charmander",new ImageIcon(getClass().getResource("\\Image\\Charmander.png")),false);
    bulbasaur = new JCheckBox("Bulbasaur",new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")),false);

    frame.add(back);
    frame.addWindowListener(this);
    frame.setLayout(new BorderLayout());
    back.setLayout(grid); 
    frame.setContentPane(back);
    back.add(charmander);
    back.add(bulbasaur);
    charmander.addActionListener(this); 
    bulbasaur.addActionListener(this); 
    
    charmander.setContentAreaFilled(false);
    charmander.setBorderPainted(false);
    bulbasaur.setContentAreaFilled(false);
    bulbasaur.setBorderPainted(false);
    
    frame.setVisible(true);
    frame.setSize(400,600);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
}

public void actionPerformed (ActionEvent e){
  this.reproduce("button2.wav"); 
     if(e.getSource().equals(charmander)){
      int answer = JOptionPane.showConfirmDialog(null, "Deseas seleccionar a Charmander?","Select",0, JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if (answer ==JOptionPane.YES_OPTION){ 
          this.reproduce("button2.wav");
           charmanderChoice = new Charmander();
          charmanderChoice.CharmanderGame();
          frame.setVisible(false);
        }
    }
    if(e.getSource().equals(bulbasaur)){
      this.reproduce("button2.wav"); 
        int answer =JOptionPane.showConfirmDialog(null,"Deseas seleccionar a Bulbasaur?","Select", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if (answer ==JOptionPane.YES_OPTION){
          this.reproduce("button2.wav");
          bulbasaurChoice = new Bulbasaur();
          bulbasaurChoice.Start();
          frame.setVisible(false);  
        }
    }
    }
    public void reproduce(String tema){
      try {
        BufferedInputStream bis=new 
        BufferedInputStream(getClass().getResourceAsStream("/Sounds/"+tema));
        AudioInputStream audioIn = AudioSystem.getAudioInputStream(bis);
        Clip clip = AudioSystem.getClip();
        clip.open(audioIn);
        clip.start();
      } catch (UnsupportedAudioFileException e) {
         System.out.println("Audio NO soportado");
      } catch (IOException e) {
         System.out.println("Error de E/S");
      } catch (LineUnavailableException e) {
         System.out.println("Linea No disponible");
      }
    }

    public class JPanelBackground extends JPanel {
        private Image background;
          public JPanelBackground(String imagePath){
             setBackground(imagePath);
          }
            public void paintComponent(Graphics g) {
              int width = this.getSize().width;
              int height = this.getSize().height;
              if (this.background != null) {
                g.drawImage(this.background, 0, 0, width, height, null);
              }
              super.paintComponent(g);
            }
        
            public void setBackground(String ruta) {
              this.setOpaque(false);
              this.background = new ImageIcon(ruta).getImage();
              repaint();
            }  
          }

public void windowClosing (WindowEvent e){
    System.exit(0);
}

}