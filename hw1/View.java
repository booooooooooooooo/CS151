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

  readNextLine

  printOptions

  printAvailability

  printManifest

  promptName

  promptServiceClass

  promptSeatPreference

  printRequestFail

  printSeat

  promptChangeSeatPreferenceOption

  promptEnterGroupName

  promptEnterPassengerNames

  public static String[] readListOfNamesFromNextLine(){
    String nameLine = readNextLine();
    String[] names = nameLine.split(",");
    for(int i = 0; i < names.length; i++){
      names[i] = names[i].trim();
    }
    return names;
  }

  public static void printSeats(List<String> seats){
    //TODO
  }
}
