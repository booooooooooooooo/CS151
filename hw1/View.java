package hw1;
import java.util.*;
public class View{
  public static void printPanel(Chart chart, int row, int col){
    List<List<Passenger>> panel = chart.getPanel();
    for(int i = 0; i < row; i++){
      for(int j = 0; j < col; j++){
        System.out.printf("%10s", panel.get(i).get(j));
      }
      System.out.println();
    }
    System.out.println();
  }

  printOptions

  printAvailability

  printManifest

  promptName

  promptServiceClass

  promptSeatPreference

  printRequestFail

  printSeat

  promptChangeSeatPreference
}
