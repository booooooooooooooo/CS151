import java.util.*;
public class Test{
  public static void main(String args[]){
    Scanner cin = new Scanner(System.in);
    String line = cin.nextLine();
    String[] names=line.split(",");
    for(int i = 0; i < names.length; i++){
      names[i] = names[i].trim();
    }
    System.out.println(line);
    for(String name : names){
      System.out.println(name);
    }
  }
}
