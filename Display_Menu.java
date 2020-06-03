import java.util.List;

public class Display_Menu{
    public void display_Menu(List<String> menuOptions){
        int i =1;
        for (String string : menuOptions) {
          System.out.println(i+":"+string);
          i++;
    }
  }
}