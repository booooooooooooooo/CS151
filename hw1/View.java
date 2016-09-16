package hw1;
import java.util.*;
public class View{

  public static String readNextLine(){
    Scanner cin = new Scanner(System.in);
    return cin.nextLine();
  }
  public static List<String> readListOfNamesFromNextLine(){
    String nameLine = readNextLine();
    String[] names = nameLine.split(",");
    for(int i = 0; i < names.length; i++){
      names[i] = names[i].trim();
    }
    return  new ArrayList<String>( Arrays.asList(names) );
  }


  public static void printWelcome(){
    System.out.println("\n\n\nWelcome to SJSU airplane System!\n\n\n");
  }
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
  //TODO: remove last comma
  /*
   A seat availability chart shows the available seats of each row of each class
   */
  public static void printAvailability(Model model){
    System.out.println("First");
    Chart firstChart = model.firstChart;
    for(int i = 0; i < firstChart.row; i++){
      System.out.printf("%d: ", i + 1);
      for(int j = 0; j < firstChart.col; j++){
        if(firstChart.panel.get(i).get(j) == null)
          System.out.printf(" %s,", firstChart.colName.get(j));
      }
      System.out.println("\n");
    }

    System.out.println("Economy");
    Chart economyChart = model.economyChart;
    for(int i = 0; i < economyChart.row; i++){
      System.out.printf("%d: ", i + 1);
      for(int j = 0; j < economyChart.col; j++){
        if(economyChart.panel.get(i).get(j) == null)
          System.out.printf(" %s,", economyChart.colName.get(j));
      }
      System.out.println("\n");
    }
  }
  /*
  A manifest lists the occupied seats and the passengers seated in them
  */
  public static void printManifest(Model model){
    System.out.println("First");
    Chart firstChart = model.firstChart;
    for(int i = 0; i < firstChart.row; i++){
      for(int j = 0; j < firstChart.col; j++){
        if( !(firstChart.panel.get(i).get(j) == null))
          System.out.printf("%s : %s\n", firstChart.seatName.get(i).get(j), firstChart.panel.get(i).get(j)  );
      }
    }
    System.out.println("Economy");
    Chart economyChart = model.economyChart;
    for(int i = 0; i < economyChart.row; i++){
      for(int j = 0; j < economyChart.col; j++){
        if( !(economyChart.panel.get(i).get(j) == null))
          System.out.printf("%s : %s\n", economyChart.seatName.get(i).get(j), economyChart.panel.get(i).get(j)  );
      }
    }
  }

  public static void printOrderedSeat(String seat){
    System.out.println("Order succeeded!\nSeat : ");
    System.out.println(seat);
  }

  public static void printOrderedSeats(List<String> seats){
    System.out.println("Order succeeded!\n Seats : ");
    for(String seat : seats){
      System.out.println(seat);
    }
  }
  public static void printCancelSucceed(){
    System.out.println("Cancelation succeeded!");
  }
  public static void printPassengerDoesNotExist(){
    System.out.println("The Passenger does not exist!");
  }
  public static void printGroupDoesNotExist(){
    System.out.println("The group does not exist!");
  }
  public static void printFailMsg(){
    System.out.println("Request failed!");
  }




  public static void promptEnterOptions(){
    System.out.printf("********************\n********************\nAdd [P]assenger\nAdd [G]roup\n[C]ancel Reservations\nPrint Seating [A]vailability Chart\nPrint [M]anifest\n[Q]uit\nEnter your option: ");
  }

  public static void promptEnterName(){
    System.out.printf("Name: ");
  }


  public static void promptEnterServiceClass(){
    System.out.printf("[First] or [Economy]: ");
  }


  public static void promptEnterSeatPreference(){
    System.out.printf("[W]indow, [C]entor or [A]aisle: ");
  }


  public static void promptEnterChangeSeatPreferenceOption(){
    System.out.println("The seat preference you requested does not exist!");
    System.out.printf("Would you like to change seat position? [Y] or [N]: ");
  }


  public static void promptEnterGroupName(){
    System.out.printf("Group Name: ");
  }


  public static void promptEnterPassengerNames(){
    System.out.printf("Please enter all passenger names seperated by comma: ");
  }


  public static void promptCancelIndividualorGroup(){
    System.out.printf("Cancel [I]ndividual or [G]roup: ");
  }



}
