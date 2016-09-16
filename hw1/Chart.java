package hw1;

import java.util.*;

public class Chart{
  public List<List<Passenger>> panel;
  public List<List<String>> seatName;
  public List<String> rowName;
  public List<String> colName;
  public int row;
  public int col;

  public Chart(String serviceClass){
    if(serviceClass.equals("First")){
      row = 2;
      col = 2;
    }else if(serviceClass.equals("Economy")){
      row = 20;
      col = 6;
    }else{
      System.out.println("Invalid Input!");
      return;
    }
    panel = new ArrayList<List<Passenger>>(row);
    for(int i = 0; i < row; i++){
      List<Passenger> temp = new ArrayList<Passenger>();
      for(int j = 0 ; j < col; j++){
        temp.add(null);
      }
      panel.add(temp);
    }
    assignSeatNumber(serviceClass);
  }
  /*
  Called by constructer
  */
  private void assignSeatNumber(String serviceClass){
    seatName = new ArrayList<List<String>>(row);
    rowName = new ArrayList<String>();
    colName = new ArrayList<String>();

    int startRow;
    char startCol = 'A';
    if(serviceClass.equals("First")){
      startRow = 1;
    }else{ // serviceClass.equals("Economy")
      startRow = 10;
    }

    for(int i = 0; i < row; i++){
      List<String> temp = new ArrayList<String>(col);
      for(int j = 0; j < col; j++){
        temp.add( String.valueOf(startRow + i) + (char)(startCol + j));
      }
      seatName.add(temp);
    }

    for(int i = 0; i < row; i++){
      rowName.add(String.valueOf(i + 1));
    }

    for(int j = 0; j < col; j++){
      colName.add("" + (char)(startCol + j));
    }

  }

  /*
  Add passenger to arbitary available seat
  */
  public String addPassenger(String name){
    for(int i = 0; i < row; i++){
      for(int j = 0 ; j < col; j++){
        if(panel.get(i).get(j) == null ){
          panel.get(i).set(j, new Passenger(name) );
          return seatName.get(i).get(j);
        }
      }
    }
    return null;
  }
  /**
  Add passenger to specific seat preference
  if succeed, update panel and return seat number
  else return null
  */
  public String addPassenger(String name, String seatPreference){
    if(seatPreference.equals("W")){
      for(int i = 0; i < row; i++){
        if(panel.get(i).get(0) == null){
          panel.get(i).set(0, new Passenger(name) );
          return seatName.get(i).get(0);
        }
        if(panel.get(i).get(col - 1) == null){
          panel.get(i).set(col - 1, new Passenger(name));
          return seatName.get(i).get(col - 1);
        }
      }
      return null;
    }
    if(seatPreference.equals("C")){
      for(int i = 0; i < row; i++){
        for(int j = 0 ; j < col; j++){
          if( j != 0 && j != col - 1 && j != col / 2 - 1 && j != col / 2 && panel.get(i).get(j) == null ){
            panel.get(i).set(j, new Passenger(name) );
            return seatName.get(i).get(j);
          }
        }
      }
      return null;
    }
    if(seatPreference.equals("A")){
      for(int i = 0; i < row; i++){
        if(panel.get(i).get(col / 2 - 1) == null){
          panel.get(i).set(col / 2 - 1, new Passenger(name) );
          return seatName.get(i).get(col / 2 - 1);
        }
        if(panel.get(i).get(col / 2) == null){
          panel.get(i).set(col / 2, new Passenger(name) );
          return seatName.get(i).get(col / 2);
        }
      }
      return null;
    }
    return null;
  }
  /**
  Add group.
  if succeed update panel and return List of seat numbers
  else return null
  */
  public List<String> addGroup(String groupName, List<String> names){
    if(getNumberOfAvailableSeats() < names.size()) return null;
    List<String> seats = new ArrayList<String>(names.size());
    int count = 0;
    while( count < names.size()){
      int[] next = findLargestAdjList();
      System.out.println(Arrays.toString(next));
      int len = next[0];
      int i = next[1];
      int j = next[2];
      for(int k = 0; k < len && count < names.size(); k++){
        panel.get(i).set(j + k, new Passenger(names.get(count), groupName));
        seats.add(seatName.get(i).get(j + k));
        count++;
      }
    }
    return seats;
  }
  /**
  Cancel a individual Passenger
  if succeed update panel and return true
  else return false
  */
  public boolean cancelPassenger(String name){
    for(int i = 0; i < row; i++){
      for(int j = 0; j < col; j++){
        if(panel.get(i).get(j) == null) continue;
        else if(panel.get(i).get(j).getName().equals(name)){
          panel.get(i).set(j, null);
          return true;
        }else continue;
      }
    }
    return false;
  }
  /**
  Cancel Group
  if succeed update panel and return true
  else return false
  */
  public boolean cancelGroup(String groupName){
    boolean groupExistence = false;
    for(int i = 0; i < row; i++){
      for(int j = 0; j < col; j++){
        if(panel.get(i).get(j) == null) continue;
        else if(panel.get(i).get(j).getGroupName().equals(groupName)){
          panel.get(i).set(j, null);
          groupExistence = true;
        }else continue;
      }
    }
    return groupExistence;
  }
  /*
  Below are Utilities
  */

  /*
  Get number of available seats
  */
  public int getNumberOfAvailableSeats(){
    int count = 0;
    for(int i = 0; i < row; i++){
      for(int j = 0; j < col; j++){
        if(panel.get(i).get(j) == null) count++;
      }
    }
    return count;
  }
  /*
  Find the length of largest adjacency list as long as its start row index and colume index
  Store results in array
  Didn't consider reducing complexity.
  */
  private int[] findLargestAdjList(){
    int[] next = {0, -1, -1}; // len, rowIndex, colIndex
    for(int i = 0; i < row; i++){
      int tempLen = 0;
      int j = 0;
      while( j < col){
        if(panel.get(i).get(j) == null && j != col - 1){
          tempLen++;
        }else if(panel.get(i).get(j) == null && j == col - 1){
          tempLen++;
          if(tempLen > next[0]){
            next[0] = tempLen;
            next[1] = i;
            next[2] = j + 1 - tempLen;
          }
          tempLen = 0;
        }else{
          if(tempLen > next[0]){
            next[0] = tempLen;
            next[1] = i;
            next[2] = j - tempLen;
          }
          tempLen = 0;
        }
        j++;
      }
    }
    return next;
  }
  /*
  Get row
  */
  public int getRow(){
    return this.row;
  }
  /*
  Get colume
  */
  public int getCol(){
    return this.col;
  }
  /*
  Get panel
  */
  public List<List<Passenger>> getPanel(){
    return this.panel;
  }

}
