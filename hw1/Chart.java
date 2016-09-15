import java.util.*;
class Chart{
  private List<List<Passenger>> panel;
  private List<List<String>> seatName;
  private int row;
  private int col;

  public Chart(String serviceClass){
    if(serviceClass.equals("First")){
      row = 2;
      col = 2;
    }else if(serviceClass.equals("Economy")){
      row = 20;
      col = 6;
    }else{
      System.out.println("Invalid Input!");
      returnl
    }
    panel = new ArrayList<List<Passenger>>(row);
    for(int i = 0; i < row; i++){
      List<Passenger> temp = new ArrayList<Passenger>();
      for(int j = 0 ; j < col; j++){
        temp.add(null);
      }
      panel.add(temp);
    }
    seatName = new ArrayList<List<String>>(row);
    assignSeatNumber(serviceClass);
  }
  /*
  Called by constructer
  */
  private void assignSeatNumber(serviceClass){
    char[] colLetter;
    char[] rowLetter;
    if(serviceClass.equals("First")){
      char[] colLetter = {'A', 'B', 'C', 'D'};
      char[] rowLetter = {'1', '2'};
    }else if(serviceClass.equals("Economy")){
      char[] colLetter = {'A', 'B', 'C', 'D', 'E', 'F'};
      char[] rowLetter = {'10', '11', '12', '13', '14', '15', '16', '17', '18', '19', '20', '21', '22', '23', '24', '25', '26', '27', '28', '29'};
    }
    for(int i = 0; i < row; i++){
      List<String> temp = new ArrayList<String>(col);
      for(int j = 0; j < col; j++){
        temp.add(rowLetter[i].toString() + colLetter[i]);
      }
      seatName.add(temp);
    }
  }
  /**
  if succeed, update panel and return seat number
  else return null
  */
  public String addPassenger(String name, String seatPreference){
    if(seatPreference.equals("W")){
      for(int i = 0; i < row; i++){
        if(panel[i][0] == null){
          panel[i][0] = new Passenger(name);
          return seatName[i][0];
        }
        if(panel[i][col - 1] == null){
          panel[i]][col - 1] = new Passenger(name);
          return seatName[i][col - 1];
        }
      }
      return null;
    }
    if(seatPreference.equals("C")){
      for(int i = 0; i < row; i++){
        for(int j = 0 ; j < col; j++){
          if(j != 0 && j != col - 1 && j != col / 2 - 1 && j != col / 2 && panel[i][j] == null){
            panel[i][j] = new Passenger(name);
            return seatName[i][j];
          }
        }
      }
      return null;
    }
    if(seatPreference.equals("A")){
      for(int i = 0; i < row; i++){
        if(panel[i][col / 2 - 1] == null){
          panel[i][col / 2 - 1] = new Passenger(name);
          return seatName[i][col / 2 - 1];
        }
        if(panel[i][col / 2] == null){
          panel[i]][col / 2] = new Passenger(name);
          return seatName[i][col / 2];
        }
      }
      return null;
    }
  }
  /**
  if succeed update panel and return List of seat numbers
  else return null
  */
  public List<String> addGroup(String groupName, List<String> names){
    if(getNumberOfAvailableSeats() < names.size()) return null;
    List<String> seats = new ArrayList<String>(names.size());
    int count = 0;
    while( count < names.size()){
      int[] next = findLargestAdjList();
      int i = next[0];
      int j = next[1];
      int len = next[2];
      for(int k = 0; k < len; k++){
        panel.get(i).set(j + k, new Passenger(groupName, names.get(count)));
        seats.add(seatName.get(i).get(j + k));
        count++;
      }
    }
  }
  /**
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
  Get number of available seats
  */
  private int getNumberOfAvailableSeats(){
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
  */
  private int[] findLargestAdjList(){
    int[] next = {0, -1, -1}; // len, rowIndex, colIndex
    for(int i = 0; i < row; i++){
      int tempLen = 0;
      int j = 0;
      while( j < col){
        if(panel.get(i).get(j) == null)
          tempLen++;
        else{
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
