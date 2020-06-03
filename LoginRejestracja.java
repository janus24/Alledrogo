import java.util.Scanner;

public class LoginRejestracja {
    public void loginRejestracja() {
        System.out.println("Login czy rejestracja");
        System.out.println("Jeżeli rejestracja wybierz 1");
        System.out.println("Jeżeli login wybierz 2");
        Scanner scanner = new Scanner(System.in);
        String wybor = "";
        boolean valid = true;
        do  {
            wybor = scanner.nextLine();
            if (wybor.equals("1")){
                valid=false;
            }else if(wybor.equals("2")){
                valid=false;
            }
            if(valid){
                System.out.println("Proszę podać \"1\" albo \"2\"");
            }
        } while (valid);


        if (wybor.equals("1")) {
            ClearScreen.clearScreen();
            Rejestracja rejestracja = new Rejestracja();
            rejestracja.Register();
        } else if (wybor.equals("2")) {
            ClearScreen.clearScreen();
            Logowanie logowanie = new Logowanie();
            logowanie.login();
        } else {
            System.out.println("Proszę wprowadzić liczby jeszcze raz");
            loginRejestracja();
        }
        scanner.close();
    }
}
