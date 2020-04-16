import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;   
import javax.sound.sampled.*;
public class Charmander extends WindowAdapter implements ActionListener{
JFrame frame;
JPanel buttonsPosition, informationPosition;
JLabel information;
JPanelBackground back;
String chain[] = {"Play","Sleep","Eat","Drink","Battle"};
JButton buttons [], charmanderImage;
JButton buttonsInformation [];
GridLayout grid;
int answer;
short play=70, sleep=70, eat=70, drink=70, health=70, experience=200;
public Charmander(){} 

public void CharmanderGame(){
frame = new JFrame("Pokegochi");
back =new JPanelBackground(".\\Image\\fondo\\landscape_1.png");
charmanderImage = new JButton(new ImageIcon(getClass().getResource("\\Image\\Charmander\\moving.gif")));
information = new JLabel();
informationPosition = new JPanel();
information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
grid = new GridLayout(0,5,0,0);
information.setOpaque(false);
charmanderImage.addActionListener(this);
buttonsPosition = new JPanel();
buttons= new JButton [5];
charmanderImage.setContentAreaFilled(false);
charmanderImage.setBorderPainted(false);
buttonsPosition.setOpaque(false);
informationPosition.setOpaque(false);
back.setLayout(new BorderLayout());

for (int i=0; i<buttons.length; i++){
    buttons[i] = new JButton(chain[i]);
    buttons[i].setContentAreaFilled(false);
    buttons[i].setBorderPainted(false);
    buttonsPosition.add(buttons[i]);
    buttons[i].addActionListener(this);
}

frame.add(back);
back.add(buttonsPosition,BorderLayout.SOUTH);
back.add(charmanderImage, BorderLayout.CENTER);
back.add(informationPosition, BorderLayout.NORTH);
informationPosition.add(information, BorderLayout.CENTER);
frame.setVisible(true);
frame.setContentPane(back);
frame.setSize(600,600);
frame.setLocationRelativeTo(null);
frame.setResizable(false);
frame.addWindowListener(this);
JOptionPane.showInternalMessageDialog(null, "Bienvenido\n"+
"1.- Dale todo lo necesario a tu pokegochi para que pueda sobrevivir.\n "+
"2.- Podras realizar batallas dependiendo de la experiencia obtenida a lo largo del tiempo\n "+
"3.- Obtendras experiencia en el tiempo, dicha experiencia servira para entrar a batallas\n","How to Play", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Assistant.png")));
this.reproduce("pokemon 2.wav");
}

public void actionPerformed (ActionEvent e){
  if (e.getSource().equals(charmanderImage)) this.reproduce("charm 3.wav"); 

//------------------Play------------------\\
  if (e.getSource().equals(buttons[0])){
    if(play==100){
      this.reproduce("select.wav");
      JOptionPane.showInternalMessageDialog(null, "No es necesario jugar con Charmander","Play", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
      play--;
      sleep--;
      health--;
      information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
    }else if(play>=90 && play<100){
      answer =JOptionPane.showConfirmDialog(null,"Deseas jugar con Charmander?","Play", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null, "Haz jugado con CHarmander","Play", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
          play++;
          sleep--;
          eat-=2;
          drink--;
          health--;
          experience+=7;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(play>=70 && play<90){
      answer =JOptionPane.showConfirmDialog(null,"Deseas jugar con Charmander?","Play",0, JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");  
          JOptionPane.showInternalMessageDialog(null, "Haz jugado con Charmander","Play", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
          play+=3;
          sleep-=3;
          eat-=2;
          drink-=3;
          health--;
          experience+=10;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(play>=40 && play<70){
      answer =JOptionPane.showConfirmDialog(null,"Deseas jugar con Charmander?","Play", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");  
          JOptionPane.showInternalMessageDialog(null, "Haz jugado con Charmander","Play", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
          play++;
          sleep--;
          eat-=4;
          drink-=3;
          health-=2;
          experience+=5;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(play>=20 && play<40){
      answer =JOptionPane.showConfirmDialog(null,"Deseas jugar con Charmander?","Play", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");  
          JOptionPane.showInternalMessageDialog(null, "Haz jugado con Charmander","Play", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
          play+=5;
          sleep-=5;
          eat-=8;
          drink-=7;
          health-=4;
          experience+=7;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(play<20){
      answer =JOptionPane.showConfirmDialog(null,"Deseas jugar con Charmander?","Play", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");  
          JOptionPane.showInternalMessageDialog(null, "Haz jugado con Charmander","Play", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
          play+=10;
          sleep-=10;
          eat-=8;
          drink-=8;
          health-=3;
          experience+=20;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }
  }
//------------------Sleep------------------\\
  if (e.getSource().equals(buttons[1])){
    if(sleep==100){
      this.reproduce("select.wav");
      JOptionPane.showInternalMessageDialog(null, "No es necesario que duerma Charmander","Sleep", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
      play-=2;
      sleep--;
      eat--;
      drink--;
      health--;
      information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
    }else if(sleep>=90 && sleep<100){
      answer =JOptionPane.showConfirmDialog(null,"Deseas dormir a Charmander?","Sleep", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");  
          JOptionPane.showInternalMessageDialog(null, "Haz dormido a Charmander","Sleep", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
          sleep++;
          eat-=2;
          drink-=5;
          health++;
          experience+=3;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(sleep>=70 && sleep<90){
      answer =JOptionPane.showConfirmDialog(null,"Deseas dormir a Charmander?","Sleep",0, JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");  
          JOptionPane.showInternalMessageDialog(null,"Haz dormido a Charmander","Sleep", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
          sleep+=3;
          eat-=3;
          drink-=6;
          health++;
          experience+=9;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(sleep>=40 && sleep<70){
      answer =JOptionPane.showConfirmDialog(null,"Deseas dormir a Charmander?","Sleep", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");  
          JOptionPane.showInternalMessageDialog(null, "Haz dormido a Charmander","Sleep", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
          play-=2;
          sleep+=4;
          eat-=3;
          drink-=4;
          health++;
          experience+=7;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(sleep>=20 && sleep<40){
        answer =JOptionPane.showConfirmDialog(null,"Haz dormido a Charmander","Sleep", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");  
          JOptionPane.showInternalMessageDialog(null,"Haz dormido a Charmander","Sleep", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));            
          sleep+=8;
          eat-=10;
          drink-=8;
          health++;
          experience+=6;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(sleep<20){
        answer =JOptionPane.showConfirmDialog(null,"Haz dormido a Charmander","Sleep", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");  
          JOptionPane.showInternalMessageDialog(null, "Haz dormido a Charmander","Sleep", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
          sleep+=20;
          eat-=20;
          drink-=10;
          health+=10;
          experience+=20;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }
  }
  //Eat
  if (e.getSource().equals(buttons[2])){
    if(eat==100){
      this.reproduce("select.wav");
    JOptionPane.showInternalMessageDialog(null, "No es necesario que coma Charmander","Eat", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
    play-=2;
    sleep--;
    eat+=3;
    drink-=4;
    health--;
    experience+=4;
  }else if(eat>=90 && eat<100){
    answer =JOptionPane.showConfirmDialog(null,"Deseas que coma Charmander?","Eat", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          JOptionPane.showInternalMessageDialog(null, "Ha comido Charmander","Eat", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
          this.reproduce("select.wav");
            information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(eat>=70 && eat<90){
    answer =JOptionPane.showConfirmDialog(null,"Deseas que coma Charmander?","Eat",0, JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          JOptionPane.showInternalMessageDialog(null,"Ha comido Charmander","Eat", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
          play-=2;
          sleep--;
          eat+=3;
          drink-=4;
          health--;
          experience+=4;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(eat>=40 && eat<70){
    answer =JOptionPane.showConfirmDialog(null,"Deseas que coma Charmander?","Eat", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null, "Ha comido Charmander","Eat", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
          play-=2;  
          sleep-=4;
          eat+=7;
          drink-=8;
          health-=0.9;
          experience+=5;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(eat>=20 && eat<40){
        answer =JOptionPane.showConfirmDialog(null,"Deseas que coma Charmander?","Eat", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null,"Ha comido Charmander","Eat", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
          play-=2;
          sleep-=7;
          eat+=5;
          drink--;
          health-=8;
          experience+=6;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
          }
    }else if(eat<20){
        answer =JOptionPane.showConfirmDialog(null,"Deseas que coma Charmander?","Eat", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null, "Ha comido Charmander","Eat", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
          play+=1;
          sleep-=1;
          eat-=2;
          drink-=1;
          health-=10;
          experience+=10;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
          }
    }
  }
//------------------Drink------------------\\
  if (e.getSource().equals(buttons[3])){
    this.reproduce("select.wav");
    int answer;
    if(drink==100) JOptionPane.showInternalMessageDialog(null, "No es necesario que tome agua Charmander","Drink", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
    if(drink>=90 && drink<100){
    answer =JOptionPane.showConfirmDialog(null,"Deseas que tome agua Charmander?","Drink", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null,"Charmander ha tomado agua","Drink", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
          eat--;
          drink++;
          play-=2;
          experience+=8;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
          }
    }else if(drink>=70 && drink<90){
    answer =JOptionPane.showConfirmDialog(null,"Deseas que tome agua Charmander?","Drink", 0, JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null,"Charmander ha tomado agua","Drink", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
          play-=2;
          eat-=2;
          drink+=4;
          health++;
          experience+=4;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(drink>=40 && drink<70){
    answer =JOptionPane.showConfirmDialog(null,"Deseas que tome agua Charmander?","Drink", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
            JOptionPane.showInternalMessageDialog(null,"Charmander ha tomado agua","Drink", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
            eat-=3;
            drink+=6;
            health-=0.9;
            experience+=7;
            information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(drink>=20 && drink<40){
        answer =JOptionPane.showConfirmDialog(null,"Deseas que tome agua Charmander?","Drink", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
            JOptionPane.showInternalMessageDialog(null,"Charmander ha tomado agua","Drink", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
            play-=2;
            sleep++;
            eat-=2;
            drink+=10;
            health-=5;
            experience+=10;
            information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
          }
    }else if(drink<20){
        answer =JOptionPane.showConfirmDialog(null,"Deseas que tome agua Charmander?","Drink", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
            JOptionPane.showInternalMessageDialog(null,"Charmander ha tomado agua","Drink", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
            sleep++;
            eat-=2;
            drink+=10;
            health-=5;
            experience+=10;
            information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
          }
    }
  }
//------------------Battle------------------\\
  if (e.getSource().equals(buttons[4])){
    this.reproduce("select.wav");
    if(experience >= 200 && experience <500){
      JOptionPane.showInternalMessageDialog(null, "Bienvenido a la zona de batalla"+
      "Para esto, sera necesario que conozcas los siguientes puntos"+
      "\n1.- Tu Pokegochi puede sufrir daños graves, lo cual, puede llevarlo a la muerte"+
      "\n2.- Dependiendo de la fuerza, resistencia y experiencia que tenga tu pokegochi, será el resultado de la pelea"+
      "\nMucha suerte!","Battle", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
      JOptionPane.showInternalMessageDialog(null, "Un momento, estamos escogiendo tu rival","Battle", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Assistant.png")));
        JOptionPane.showInternalMessageDialog(null, "Lucharas contra Squirtle","Battle", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Squirtle.png")));
        this.reproduce("wrong.wav");
        JOptionPane.showInternalMessageDialog(null, "Lo sentimos, acabas de perder contra Squirtle.\n"
        +"Necesitaras ganar mas experiencia","Battle", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Squirtle.png")));
        experience+=40;
        health-=30;
        drink-=30;
        sleep-=30;
        eat-=30;
        play-=30;
        information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
      }else if(experience >=500 && experience <=800){
        JOptionPane.showInternalMessageDialog(null, "Lucharas contra Bulbasaur","Battle", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        JOptionPane.showInternalMessageDialog(null, "Felicidades! Acabas de ganar la batalla!.\n","Battle", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        this.reproduce("win.wav");
        experience+=200;
        health-=20;
        drink-=20;
        sleep-=30;
        eat-=20;
        play-=20;
        information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
      }else if (experience >=800 && experience <3000){
        JOptionPane.showInternalMessageDialog(null, "Lucharas contra Machoke","Battle", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\boss.jpeg")));
        JOptionPane.showInternalMessageDialog(null, "Lo sentimos, acabas de perder contra Machoke.\n"
        +"Necesitaras ganar mas experiencia","Battle", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\boss.jpeg")));
        this.reproduce("wrong.wav");
        experience+=100;
        health-=50;
        drink-=50;
        sleep-=50;
        eat-=50;
        play-=50;
        information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
      }else if (experience >=3000){
        JOptionPane.showInternalMessageDialog(null, "Lucharas contra Machoke","Battle", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\boss.jpeg")));
        JOptionPane.showInternalMessageDialog(null, "Felicidades! Acabas de ganar la batalla!.\n","Battle", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\boss.jpeg")));
        this.reproduce("win.wav");
        experience+=400;
        health-=20;
        drink-=20;
        sleep-=30;
        eat-=20;
        play-=20;
        information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
      }
    }
}
//------------------Sounds------------------\\
public void reproduce(String tema){
  try {
    BufferedInputStream bis=new 
    BufferedInputStream(getClass().getResourceAsStream("/Sounds/"+tema));
    AudioInputStream audioIn = AudioSystem.getAudioInputStream(bis);
    Clip clip = AudioSystem.getClip();
    clip.open(audioIn);
    clip.start();
    clip.loop(10);
  } catch (UnsupportedAudioFileException e) {
     System.out.println("Audio NO soportado");
  } catch (IOException e) {
     System.out.println("Error de E/S");
  } catch (LineUnavailableException e) {
     System.out.println("Linea No disponible");
  }
}
//------------------Wallpaper------------------\\
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
public void WindowClosing (WindowEvent e){System.exit(0);}
}