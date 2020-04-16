import java.awt.*;
public class Energy{
int energy[] = {100,200,300,400};
String array []={"Colonia1","Colonia2"};

public Energy(){

for (int i=0; i<array.length; i++){
  System.out.println(array[i]);
}
for(int j=0; j<energy.length; j++){
  System.out.println(energy[j]);
}

}

public static void main (String []args){
Energy energy = new Energy();
}
}
