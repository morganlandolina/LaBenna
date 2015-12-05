package labenna;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static labenna.LaBenna.file;

public class Generatore {

    static Scanner scanner;

    public String leggiCazzata() {
        String cazzata = "";

        String riga;
        ArrayList<String> cazzate = new ArrayList<>();

        try (FileReader fileReader = new FileReader(file)) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while ((riga = bufferedReader.readLine()) != null) {
                cazzate.add(riga);
            }

            cazzata = (cazzate.get((int) (Math.random() * cazzate.size())));
        } catch (FileNotFoundException fnfe) {
            System.out.println("File non trovato.");
        } catch (Exception e) {
            System.out.println("Errore!");
        }

        return cazzata;
    }

    public void scriviCazzata(String cazzata) {
        try {
            Writer output = new BufferedWriter(new FileWriter(file, true));
//            output.append(System.getProperty("line.separator"));
            output.append("\n\"" + cazzata + "\"");
            output.close();
        } catch (IOException ex) {
            Logger.getLogger(LaBenna.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
