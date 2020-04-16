import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;   
import javax.sound.sampled.*;

public class Menu extends WindowAdapter implements KeyListener{
   JFrame  frame;
   private JPanelBackground back;

   private JButton Enter;
   public Menu(){
   }
   
   public void Start(){
   frame = new JFrame ("Pokegochi");
   Enter = new JButton ("Presione ENTER para continuar");
   back =new JPanelBackground(".\\Image\\fondo\\landscape.png");
 
   Enter.addKeyListener(this);
   frame.add(back);
   frame.setContentPane(back);
   back.setLayout(new GridLayout(1,1,1,1));
   frame.add(Enter);
   Enter.setFont(new Font ("",Font.PLAIN,25));
   

      
   Enter.setContentAreaFilled(false);
   Enter.setBorderPainted(false);
   frame.setVisible(true);
   frame.setSize(600,600);
   frame.setLocationRelativeTo(null);
   frame.addWindowListener(this);
   
   this.reproduce("poke 3.wav"); 
   }
   public void reproduce(String tema){
      try {
         // Open an audio input stream.
         BufferedInputStream bis=new 
         BufferedInputStream(getClass().getResourceAsStream("/Sounds/"+tema));
         AudioInputStream audioIn = AudioSystem.getAudioInputStream(bis);
         // Get a sound clip resource.
         Clip clip = AudioSystem.getClip();
         // Open audio clip and load samples from the audio input stream.
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

public void keyPressed(KeyEvent ek){
   int key = ek.getKeyCode(); 
   if (key ==  KeyEvent.VK_ENTER){
      frame.setVisible (false);
      Select select = new Select();
      select.ChoicePokegochi();
}
}
public void keyTyped(KeyEvent ek){}
public void keyReleased(KeyEvent ek){}

}