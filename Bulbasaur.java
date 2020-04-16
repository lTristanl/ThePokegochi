import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;   
import javax.sound.sampled.*;
public class Bulbasaur extends WindowAdapter implements ActionListener{
  JFrame frame;
  JPanel buttonsPosition, informationPosition;
  JLabel information;
  JPanelBackground back;
  String chain[] = {"Play","Sleep","Eat","Drink","Battle"};
  JButton buttons [], bulbasaurImage;
  JButton buttonsInformation [];
  GridLayout grid;
  int answer;
  short play=90, sleep=90, eat=90, drink=90, health=90, experience=0;

public Bulbasaur(){}

public void Start(){
  frame = new JFrame("Pokegochi");
  back =new JPanelBackground(".\\Image\\fondo\\landscape_1.png");
  bulbasaurImage = new JButton(new ImageIcon(getClass().getResource("\\Image\\Nueva carpeta\\bulba.gif")));
  information = new JLabel();
  informationPosition = new JPanel();
  information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
  grid = new GridLayout(0,5,0,0);
  information.setOpaque(false);
  bulbasaurImage.addActionListener(this);
  buttonsPosition = new JPanel();
  buttons= new JButton [5];
  bulbasaurImage.setContentAreaFilled(false);
  bulbasaurImage.setBorderPainted(false);
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
  back.add(bulbasaurImage, BorderLayout.CENTER);
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

//------------------Actions------------------\\
public void actionPerformed (ActionEvent e){
  if (e.getSource().equals(bulbasaurImage))
    this.reproduce("bulba3.wav"); 
//------------------PLay------------------\\
  if (e.getSource().equals(buttons[0])){
    if(play==100){
      this.reproduce("select.wav");
      JOptionPane.showInternalMessageDialog(null, "No es necesario jugar con Bulbasaur","Play", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
      play--;
      sleep--;
      health--;
      information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
    }else if(play>=90 && play<100){
        answer =JOptionPane.showConfirmDialog(null,"Deseas jugar con Bulbasaurr?","Play", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
        this.reproduce("select.wav");  
        JOptionPane.showInternalMessageDialog(null, "Haz jugado con Bulbasaur","Play", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        sleep--;
        eat-=2;
        drink--;
        health--;
        experience+=7;
        information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(play>=70 && play<90){
        answer =JOptionPane.showConfirmDialog(null,"Deseas jugar con Bulbasaur?","Play",0, JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav"); 
          JOptionPane.showInternalMessageDialog(null, "Haz jugado con Bulbasaur","Play", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
          play+=3;
          sleep-=3;
          eat-=2;
          drink-=3;
          health--;
          experience+=10;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
          }
    }else if(play>=40 && play<70){
        answer =JOptionPane.showConfirmDialog(null,"Deseas jugar con Bulbasaur?","Play", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null, "Haz jugado con Bulbasaur","Play", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
          play++;
          sleep--;
          eat-=4;
          drink-=3;
          health-=2;
          experience+=5;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
          }
    }else if(play>=20 && play<40){
        answer =JOptionPane.showConfirmDialog(null,"Deseas jugar con Bulbasaur?","Play", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");  
          JOptionPane.showInternalMessageDialog(null, "Haz jugado con Bulbasaur","Play", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
          play+=5;
          sleep-=5;
          eat-=8;
          drink-=7;
          health-=4;
          experience+=7;
            information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
          }
    }else if(play<20){
        answer =JOptionPane.showConfirmDialog(null,"Deseas jugar con Bulbasaur?","Play", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");  
          JOptionPane.showInternalMessageDialog(null, "Haz jugado con Bulbasaur","Play", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
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
      JOptionPane.showInternalMessageDialog(null, "No es necesario que duerma Bulbasaur","Sleep", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
      play-=2;
      sleep--;
      eat--;
      drink--;
      health--;
      information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
    }else if(sleep>=90 && sleep<100){
      answer =JOptionPane.showConfirmDialog(null,"Deseas dormir a Bulbasaur?","Sleep", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
        this.reproduce("select.wav"); 
        JOptionPane.showInternalMessageDialog(null, "Haz dormido a Bulbasaur","Sleep", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        sleep++;
        eat-=2;
        drink-=5;
        health++;
        experience+=3;
        information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(sleep>=70 && sleep<90){
      answer =JOptionPane.showConfirmDialog(null,"Deseas dormir a Bulbasaur?","Sleep",0, JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png"))); 
      if(answer== JOptionPane.YES_OPTION){
        this.reproduce("select.wav");
        JOptionPane.showInternalMessageDialog(null,"Haz dormido a Bulbasaur","Sleep", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        sleep+=3;
        eat-=3;
        drink-=6;
        health++;
        experience+=9;
        information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
      }
    }else if(sleep>=40 && sleep<70){
    answer =JOptionPane.showConfirmDialog(null,"Deseas dormir a Bulbasaur?","Sleep", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");  
          JOptionPane.showInternalMessageDialog(null, "Haz dormido a Bulbasaur","Sleep", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
          play-=2;
          sleep+=4;
          eat-=3;
          drink-=4;
          health++;
          experience+=7;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
          }
    }else if(sleep>=20 && sleep<40){
        answer =JOptionPane.showConfirmDialog(null,"Deseas dormir a Bulbasaur?","Sleep", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");  
          JOptionPane.showInternalMessageDialog(null,"Haz dormido a Bulbasaur","Sleep", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
          sleep+=8;
          eat-=10;
          drink-=8;
          health++;
          experience+=6;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
          }
    }else if(sleep<20){
      this.reproduce("select.wav");
      answer =JOptionPane.showConfirmDialog(null,"Haz dormido a Bulbasaur","Sleep", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null, "Haz dormido a Bulbasaur","Sleep", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png"))); 
          sleep+=20;
          eat-=20;
          drink-=10;
          health+=10;
          experience+=20;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }
  }
  //------------------Eat------------------\\
  if (e.getSource().equals(buttons[2])){
    if(eat==100){
      this.reproduce("select.wav");
      JOptionPane.showInternalMessageDialog(null, "No es necesario que coma Bulbasaur","Eat", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
      sleep--;
      eat-=2;
      drink--;
    }else if(eat>=90 && eat<100){
      answer =JOptionPane.showConfirmDialog(null,"Deseas que coma Bulbasaur?","Eat", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
        this.reproduce("select.wav");  
        JOptionPane.showInternalMessageDialog(null, "Ha comido Bulbasaur","Eat", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png"))); 
        sleep--;
        eat++;
        drink--;
        health--;
        experience+=2;
        information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(eat>=70 && eat<90){
      answer =JOptionPane.showConfirmDialog(null,"Deseas que coma Bulbasaur?","Eat",0, JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null,"Ha comido Bulbasaur","Eat", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
          play-=2;
          sleep--;
          eat+=3;
          drink-=4;
          health--;
          experience+=4;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
          }
    }else if(eat>=40 && eat<70){
      answer =JOptionPane.showConfirmDialog(null,"Deseas que coma Bulbasaur?","Eat", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null, "Ha comido Bulbasaur","Eat", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
          play-=2;  
          sleep-=4;
          eat+=7;
          drink-=8;
          health-=0.9;
          experience+=5;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
          }
    }else if(eat>=20 && eat<40){
        answer =JOptionPane.showConfirmDialog(null,"Deseas que coma Bulbasaur?","Eat", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null,"Ha comido Bulbasaur","Eat", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
          play-=2;
          sleep-=7;
          eat+=5;
          drink--;
          health-=8;
          experience+=6;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
          }
    }else if(eat<20){
        answer =JOptionPane.showConfirmDialog(null,"Deseas que coma Bulbasaur?","Eat", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null, "Ha comido Bulbasaur","Eat", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
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
    if(drink==100){
      this.reproduce("select.wav");
      JOptionPane.showInternalMessageDialog(null, "No es necesario que tome agua Bulbasaur","Drink", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
      sleep--;
      eat-=2;
      drink--;
    }else if(drink>=90 && drink<100){
      answer =JOptionPane.showConfirmDialog(null,"Deseas que tome agua Bulbasaur?","Drink", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null,"Bulbasaur ha tomado agua","Drink", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
          eat--;
          drink++;
          play-=2;
          experience+=8;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(drink>=70 && drink<90){
      answer =JOptionPane.showConfirmDialog(null,"Deseas que tome agua Bulbasaur?","Drink", 0, JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null,"Bulbasaur ha tomado agua","Drink", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
          play-=2;
          eat-=2;
          drink+=4;
          health++;
          experience+=4;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
          }
    }else if(drink>=40 && drink<70){
      answer =JOptionPane.showConfirmDialog(null,"Deseas que tome agua Bulbasaur?","Drink", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null,"Bulbasaur ha tomado agua","Drink", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
          eat-=3;
          drink+=6;
          health-=0.9;
          experience+=7;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
          }
    }else if(drink>=20 && drink<40){
        answer =JOptionPane.showConfirmDialog(null,"Deseas que tome agua Bulbasaur?","Drink", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null,"Bulbasaur ha tomado agua","Drink", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
          play-=2;
          sleep++;
          eat-=2;
          drink+=10;
          health-=5;
          experience+=10;
          information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
        }
    }else if(drink<20){
        answer =JOptionPane.showConfirmDialog(null,"Deseas que tome agua Bulbasaur?","Drink", 0,JOptionPane.QUESTION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
        if(answer== JOptionPane.YES_OPTION){
          this.reproduce("select.wav");
          JOptionPane.showInternalMessageDialog(null,"Bulbasaur ha tomado agua","Drink", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Bulbasaur.png")));
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
    if(experience >= 200  && experience <500){
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
        JOptionPane.showInternalMessageDialog(null, "Lucharas contra Charmander","Battle", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        this.reproduce("win.wav");
        JOptionPane.showInternalMessageDialog(null, "Felicidades! Acabas de ganar la batalla!.\n","Battle", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\Charmander.png")));
        experience+=200;
        health-=20;
        drink-=20;
        sleep-=30;
        eat-=20;
        play-=20;
        information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
      }else if (experience >=800 && experience <=1000){
        JOptionPane.showInternalMessageDialog(null, "Lucharas contra Machoke","Battle", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\boss.jpeg")));
        this.reproduce("wrong.wav");
        JOptionPane.showInternalMessageDialog(null, "Lo sentimos, acabas de perder contra Machoke.\n"
        +"Necesitaras ganar mas experiencia","Battle", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\boss.jpeg")));
        experience+=100;
        health-=50;
        drink-=50;
        sleep-=50;
        eat-=50;
        play-=50;
        information.setText("   play: "+play+"%"+"    sleep: "+sleep+"%"+"    eat: "+eat+"%"+"    drink: "+drink+"%"+"    health: "+health+"%"+"    experience: "+experience+"%");
      }else if (experience >=3000){
        JOptionPane.showInternalMessageDialog(null, "Lucharas contra Machoke","Battle", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\boss.jpeg")));
        this.reproduce("win.wav");
        JOptionPane.showInternalMessageDialog(null, "Felicidades! Acabas de ganar la batalla!.\n","Battle", JOptionPane.INFORMATION_MESSAGE,new ImageIcon(getClass().getResource("\\Image\\boss.jpeg")));
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
public void WindowClosing (WindowEvent e){System.exit(0);}
}