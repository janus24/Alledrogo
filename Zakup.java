import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Zakup {

    public static void zakupki(String userZ) throws Exception {
        String oferta;
        System.out.println("Podaj nazwę oferty która Cię interesuje: ");
        System.out.println(userZ);
        Scanner scan =new  Scanner(System.in);
        oferta = scan.nextLine();
        ClearScreen.clearScreen();
        File file=new File("C:\\Users\\jansw\\Desktop\\Projekt\\Projekt\\Oferty\\"+oferta+".txt");
        Scanner in = new Scanner(file);
        while(in.hasNext()){
        String line = in.nextLine();
        System.out.println(line);
        }
        in.close();
        System.out.println("Wybierz co dalej:");
        System.out.println("1. Kup.");
        System.out.println("2. Wróć do przeglądania.");
        int wybor;
        wybor=scan.nextInt();
        switch(wybor){
            case 1:
            Zakup zakup=new Zakup();
            zakup.zakup(oferta, userZ);
            DPM dpm=new DPM();
            dpm.wybierz(userZ);
            case 2:
            PrzegladajOferty przegladajofert=new PrzegladajOferty();
            przegladajofert.Oferty(userZ);
        }
        scan.close();
    }
    public void zakup(String oferta, String userZA){
        System.out.println(userZA);
        String lineToRemove = "'"+oferta+"'";
        String inputFileName = "C:\\Users\\jansw\\Desktop\\Projekt\\Projekt\\oferty.txt";
        String outputFileName = "C:\\Users\\jansw\\Desktop\\Projekt\\Projekt\\Temp0.txt";
        String delFileName = "C:\\Users\\jansw\\Desktop\\Projekt\\Projekt\\Oferty\\" + oferta+ ".txt";
        String HistoryFileUser = "C:\\Users\\jansw\\Desktop\\Projekt\\Projekt\\UserHistory\\" + userZA+ ".txt";
try {
    File inputFile = new File(inputFileName);
    File outputFile = new File(outputFileName);
    File delFile = new File(delFileName);
    File historyFile = new File(HistoryFileUser);
    try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
        String line = null;
        if(delFile.exists()){
        while ((line = reader.readLine()) != null) {
            
            if (!line.equals(lineToRemove)) {
                writer.write(line);
                writer.newLine();
            }
        }
        delFile.delete();
        if(!historyFile.exists()){
            historyFile.createNewFile();
        }
        DateTimeFormatter dmy = DateTimeFormatter.ofPattern("dd/mm/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String Zapis="Dnia " + dmy.format(now) + " zakupiles przedmiot: "+oferta;
        File file = new File(HistoryFileUser);
        FileWriter plik = new FileWriter(historyFile.getAbsolutePath(), true);
        BufferedWriter bw = new BufferedWriter(plik);
        bw.write(Zapis);
        bw.close();
        ClearScreen.clearScreen();
        System.out.println("Pomyślnie zakupiono przedmiot "+oferta+"!");
    }
    }
    if (inputFile.delete()) {
        if (!outputFile.renameTo(inputFile)) {
            throw new IOException("Nie mozna zmienic nazwy z " + outputFileName + " na " + inputFileName);
        }
    } else {
        throw new IOException("Nie mozna usunac oryginalnego pliku " + inputFileName);
    }
} catch (IOException ex) {
    ex.printStackTrace();
}
}
}