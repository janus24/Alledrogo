import java.io.File;
import java.util.Scanner;

public class Logowanie {
        private Scanner x;
        public void login(){
        Scanner scan = new Scanner(System.in);
        
        System.out.println("Logowanie!");
        System.out.println("Podaj login: ");
        String username = scan.nextLine();
        System.out.println("Podaj hasło: ");
        String password = scan.nextLine();
        String filePath="C:\\Users\\jansw\\Desktop\\Projekt\\Projekt\\loginy.txt";
        Login(username, password, filePath);
        scan.close();
        }

    
    
    
    public void Login(String username, String password, String filePath)
    {
        boolean found = false;
        String tempUsername="";
        String tempPassword="";

        try{
            x=new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");

            while(x.hasNext() && !found){
                tempUsername = x.next();
                tempPassword = x.next();
                if(tempUsername.trim().equals(username.trim()) && tempPassword.trim().equals(password.trim())){
                    ClearScreen.clearScreen();
                    System.out.println("Zalogowano!");
                    found=true;
                    DPM wybierz = new DPM();
                    wybierz.wybierz(username);
                    
                }
            }
            if(!found){
                ClearScreen.clearScreen();
                System.out.println("Błędne dane!");
                login();
            }
            x.close();
        }catch(Exception e){

        }
    }

}
