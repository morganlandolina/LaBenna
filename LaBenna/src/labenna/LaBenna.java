package labenna;

import java.util.ArrayList;
import java.io.*;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LaBenna {
    static String file = "src/cazzate.txt";
    static Scanner scanner = new Scanner(System.in);        
    
    public static void main(String[] args){
        
    
        
        System.out.println("Cosa vuoi fare?\n1) leggi una cazzata random\n2) SIMONE NE HA SPARATA UN'ALTRA, FAMMELA INSERIRE!!");
        String scelta = scanner.next();
        
        switch(scelta){
            case "1":
                System.out.println("La massima di oggi di Simone è:");
                System.out.println(leggiCazzata());
                break;
            case "2":
                scriviCazzata();
                break;
            default: break;
        }
       
    }
    
    public static String leggiCazzata(){
        String cazzata = "";
        
        String riga;
        ArrayList<String> cazzate = new ArrayList<>();
        
        try{
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            while((riga = bufferedReader.readLine()) != null) {
                cazzate.add(riga);
            }   
            
            cazzata =(cazzate.get((int) (Math.random() * cazzate.size())));
            fileReader.close();
        }catch(Exception e){
            System.out.println("Errore!");
        }
          
        
        return cazzata;
    }
    
    public static void scriviCazzata(){
        try {
            Writer output = new BufferedWriter(new FileWriter(file, true));
            System.out.println("Che cosa ha detto?");
            scanner = new Scanner(System.in);
            String cazzata = scanner.nextLine();
            output.append(System.getProperty("line.separator"));
            output.append("\n" + cazzata);
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(LaBenna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
