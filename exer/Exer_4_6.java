import java.util.*;

public class Exer_4_6{
  public static void main(String args[]){
    ArrayList<String> a = new ArrayList<String>();
    a.add("x");
    a.add("xxxx");
    a.add("xx");
    a.add("");
    System.out.println(maximun(a, new Comparator<String>(){
      @Override
      public int compare(String x, String y){
        int common = Math.min(x.length(), y.length());
        for(int i = 0; i < common; i++){
          if(x.charAt(i) < y.charAt(i)) return -1;
          else if(x.charAt(i) > y.charAt(i)) return 1;
          else continue;
        }
        if(y.length() > common) return -1;
        else if(x.length() > common) return 1;
        else return 0;
      }
    }) );
  }

  public static String maximun(ArrayList<String> a, Comparator<String> c){
    String result = "";
    for(int i = 0; i < a.size(); i++){
      if(c.compare(a.get(i), result) > 0) result = a.get(i);
    }
    return result;
  }

}
