import java.util.Scanner;
import java.io.*;

public class PrzegladajOferty {
    public void Oferty(String user0)throws Exception{
        File file = new File ("C:\\Users\\jansw\\Desktop\\Projekt\\Projekt\\oferty.txt");
        Scanner in = new Scanner(file);
        while(in.hasNext()){
            String line = in.nextLine();
            System.out.println(line);
        }
        in.close();
        System.out.println("Wybierz co chcesz zrobic: ");
        System.out.println("1. Podglad oferty");
        System.out.println("2. Wroc do menu");
        Scanner czyn = new Scanner(System.in);
        int czynn;
        czynn = czyn.nextInt();
        switch(czynn){
            case 1:
                Zakup.zakupki(user0);
                break;
            case 2:
                ClearScreen.clearScreen();
                DPM dpm = new DPM();
                dpm.wybierz(user0);
                break;

        }
        czyn.close();
    }
}