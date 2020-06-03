import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

class Dane{
    String nazwa;
    String opis;
    int cena;
    String imie;
    String nazwisko;
}

public class NowaOferta extends Dane{
    private Scanner x;
        public String Dodaj(String userD){
            Scanner sc = new Scanner(System.in);
            System.out.println("Podaj nazwe swojej oferty: ");
            nazwa = sc.nextLine();
            System.out.println("Podaj imie: ");
            imie=sc.nextLine();
            System.out.println("Podaj nazwisko: ");
            nazwisko=sc.nextLine();
            System.out.println("Wpisz opis swojej oferty: ");
            opis = sc.nextLine();
            System.out.println("Podaj cene swojej oferty: ");
            cena = sc.nextInt();

            String filePath = "C:\\Users\\jansw\\Desktop\\Projekt\\Projekt\\Oferty\\"+nazwa+".txt";
            String filePath2 = "C:\\Users\\jansw\\Desktop\\Projekt\\Projekt\\oferty.txt";
            Dodaj(nazwa, opis, cena, imie, nazwisko, filePath, filePath2, userD);
            sc.close();
            String okej="Pomyślnie dodano oferte!";
            return okej;

        }

        public void Dodaj(String nazwa, String opis, int cena, String imie, String nazwisko, String filePath, String filePath2, String userD2){
            boolean found = false;
            String tempNazwa = "";

            try{
                x=new Scanner(new File(filePath2));
                x.useDelimiter("['\n]");

                while(x.hasNext() && !found){
                    tempNazwa = x.next();
                    if(tempNazwa.trim().equals(nazwa.trim())){
                        ClearScreen.clearScreen();
                        found=true;
                        x.close();
                    }
                }
                if(!found){
                    x.close();
                    try{
                        String Zapis=nazwa+"\n"+"Opis oferty: "+opis+"\n"+"Cena: "+cena+"\n"+"Dane sprzedajacego: "+imie+" "+nazwisko;
                        String Zapis2="'"+nazwa+"'\n";
                        File pliczek=new File(filePath);
                        if(!pliczek.exists()){
                            pliczek.createNewFile();
                        }

                        File file=new File(filePath);
                        FileWriter plik=new FileWriter(file.getAbsoluteFile(), true);
                        BufferedWriter bw=new BufferedWriter(plik);

                        File file2=new File(filePath2);
                        FileWriter plik2=new FileWriter(file2.getAbsoluteFile(), true);
                        BufferedWriter bw2=new BufferedWriter(plik2);

                        bw.write(Zapis);
                        bw2.write(Zapis2);

                        bw.close();
                        bw2.close();

                        ClearScreen.clearScreen();
                        System.out.println("Pomyslnie dodano oferte!");
                        DPM dpm = new DPM();
                        dpm.wybierz(userD2);

                    }catch(IOException e){
                        e.printStackTrace();
                    }
                }
            }catch(final Exception e){
                System.out.println("Taka oferta juz istnieje!");
                System.out.println("Podaj inna nazwe");
                Dodaj(userD2);
            }
        }  
        

}

