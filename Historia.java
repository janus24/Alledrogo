import java.io.File;
import java.util.Scanner;

public class Historia {
    public void historia(String userH) throws Exception {
        ClearScreen.clearScreen();
        File file=new File("C:\\Users\\jansw\\Desktop\\Projekt\\Projekt\\UserHistory\\"+userH+".txt");
        Scanner in = new Scanner(file);
        while(in.hasNext()){
            String line = in.nextLine();
            System.out.println(line);
            }
            in.close();
            System.out.println("Wybierz co chcesz zrobic: ");
            System.out.println("1. Wroc do menu");
            System.out.println("2. Zamknij program");
            Scanner czyn = new Scanner(System.in);
            int czynn;
            czynn = czyn.nextInt();
            switch(czynn){
                case 1:
                    ClearScreen.clearScreen();
                    DPM dpm = new DPM();
                    dpm.wybierz(userH);
                    break;
                case 2:
                ClearScreen.clearScreen();
                System.out.println("Do zobaczenia! :)");
                System.exit(0);
            }
            czyn.close();
    }
}