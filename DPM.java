import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DPM {
    public void wybierz(String user) throws Exception{
        Scanner scanner = new Scanner(System.in);
        int wybierz;

        System.out.println("Witamy w Alledrogo "+user+"!");

        Display_Menu menu = new Display_Menu();
        List<String> menuOptions = Arrays.asList("Przeglądaj oferty","Dodaj ofertę","Moje oferty","Zamknij program");

        do{
            menu.display_Menu(menuOptions);
            wybierz=scanner.nextInt();

            if(wybierz>5){
                System.out.println("Wybierz dzialanie z listy: ");
            }
            switch(wybierz){
                case 1:
                    PrzegladajOferty oferty = new PrzegladajOferty();
                    oferty.Oferty(user);
                    break;
                case 2:
                    NowaOferta oferta = new NowaOferta();
                    oferta.Dodaj(user);
                    break;
                case 3:
                    Historia historia = new Historia();
                    historia.historia(user);
                    break;
                case 4:
                    ClearScreen.clearScreen();
                    System.out.println("Do zobaczenia! :)");
                    System.exit(0);
            }

        }while(wybierz>5);
        scanner.close();
    }
}
