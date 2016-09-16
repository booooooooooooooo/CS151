package hw1;
import java.util.*;
public class View{
  Scanner cin ;
  public View(){
    cin = new Scanner(System.in);
  }

  public  String readNextLine(){
    return cin.nextLine();
  }
  public  List<String> readListOfNamesFromNextLine(){
    String nameLine = readNextLine();
    String[] names = nameLine.split(",");
    for(int i = 0; i < names.length; i++){
      names[i] = names[i].trim();
    }
    return  new ArrayList<String>( Arrays.asList(names) );
  }


  public  void printWelcome(){
    System.out.println("\n\n\nWelcome to SJSU airplane System!\n\n\n");
  }
  public  void printPanel(Chart chart, int row, int col){
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
  public  void printAvailability(Model model){
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
  public  void printManifest(Model model){
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

  public  void printOrderedSeat(String seat){
    System.out.println("Order succeeded!\nSeat : ");
    System.out.println(seat);
  }

  public  void printOrderedSeats(List<String> seats){
    System.out.println("Order succeeded!\n Seats : ");
    for(String seat : seats){
      System.out.println(seat);
    }
  }
  public  void printCancelSucceed(){
    System.out.println("Cancelation succeeded!");
  }
  public  void printPassengerDoesNotExist(){
    System.out.println("The Passenger does not exist!");
  }
  public  void printGroupDoesNotExist(){
    System.out.println("The group does not exist!");
  }
  public  void printFailMsg(){
    System.out.println("Request failed!");
  }




  public  void promptEnterOptions(){
    System.out.printf("********************\n********************\nAdd [P]assenger\nAdd [G]roup\n[C]ancel Reservations\nPrint Seating [A]vailability Chart\nPrint [M]anifest\n[Q]uit\nEnter your option: ");
  }

  public  void promptEnterName(){
    System.out.printf("Name: ");
  }


  public  void promptEnterServiceClass(){
    System.out.printf("[First] or [Economy]: ");
  }


  public  void promptEnterSeatPreference(){
    System.out.printf("[W]indow, [C]entor or [A]aisle: ");
  }


  public  void promptEnterChangeSeatPreferenceOption(){
    System.out.println("The seat preference you requested does not exist!");
    System.out.printf("Would you like to change seat position? [Y] or [N]: ");
  }


  public  void promptEnterGroupName(){
    System.out.printf("Group Name: ");
  }


  public  void promptEnterPassengerNames(){
    System.out.printf("Please enter all passenger names seperated by comma: ");
  }


  public  void promptCancelIndividualorGroup(){
    System.out.printf("Cancel [I]ndividual or [G]roup: ");
  }



}
