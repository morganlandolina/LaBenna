package labenna;

import java.util.ArrayList;
import java.io.*;

public class LaBenna {
    ArrayList<String> cazzate = new ArrayList<>();
    
    public static void main(String[] args) {
        System.out.println(leggiCazzata());
       
       
    }
    
    static public String leggiCazzata(){
        String cazzata = "";
        String file = "src/cazzate.txt";
        String riga;
        
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            if((riga = bufferedReader.readLine()) != null) {
                System.out.println(riga);
            }   
        }catch(Exception e){
            System.out.println("Errore!");
        }
          
        
        return cazzata;
    }
    
}
