
//import java.util.List;
//import java.util.Scanner;


public class Main {
  public static void main(String[] args) {
  ClearScreen.clearScreen();
  LoginRejestracja loginRejestracja = new LoginRejestracja();
  loginRejestracja.loginRejestracja();
  }
//Display_Menu menu = new Display_Menu();
//List<String> menuOptions = Arrays.asList("Przeglądaj oferty","Dodaj ofertę","Moje oferty","Historia zakupów","Zamknij program");
//Zamknij_program zamknij_program = new Zamknij_program();
//    menu.display_Menu(menuOptions);


  











  //public static void display_Menu(){
    //List<String> menuOptions = Arrays.asList("Sklep","Historia","Lista posiadanych pupili","Umówienie pupila na spotkanko","Zamknij program");
    //String[] menuoptions = {"Sklep","Historia","Lista posiadanych pupili","Umówienie pupila na spotkanko","Zamknij program"};
  //  int i =1;
  //  for (String string : menuOptions) {
  //    System.out.println(i+":"+string);
  //    i++;
  //  }
  //}
  public static void clearScreen() {
    try {
      new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
    } catch (Exception e) {
      System.out.println(e);
    }
  }

}