import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Rejestracja {
     private Scanner x;

        public void Register(){
        Scanner scan = new Scanner(System.in);
        ClearScreen.clearScreen();
        System.out.println("Rejestracja!");
        System.out.println("Podaj login: ");
        String username = scan.nextLine();
        System.out.println("Podaj hasło: ");
        String password = scan.nextLine();
        //String username="Marek";
        //String password="Krzymowski";
        final String filePath="C:\\Users\\jansw\\Desktop\\Projekt\\Projekt\\loginy.txt";
        Register(username, password, filePath);
        scan.close();

    }
    
    
    public void Register(String username, String password, String filePath)
    {
    
        boolean found = false;
        String tempUsername="";
        
        try{
            x=new Scanner(new File(filePath));
            x.useDelimiter("[,\n]");

            while(x.hasNext() && !found){
                tempUsername = x.next();
                if(tempUsername.trim().equals(username.trim())){
                    ClearScreen.clearScreen();
                    System.out.println("Taka nazwa już istnieje podaj inną!");
                    found=true;
                    Register();
                    
                }
            }
            if(!found){

                try{
                    String Zapis=username+","+password+"\n";

                    File file=new File(filePath);
                    FileWriter plik= new FileWriter(file.getAbsoluteFile(), true);
                    BufferedWriter bw= new BufferedWriter(plik);
                    bw.write(Zapis);
                    bw.close();
                    ClearScreen.clearScreen();
                    System.out.println("Pomyślnie utworzono konto!");
                    DPM wybierz = new DPM();
                    wybierz.wybierz(username);
                    
                }catch(IOException e){
                    e.printStackTrace();
                }
            }
        }catch(final Exception e){
            System.out.println("Error");

        }
        x.close();
    }

}

