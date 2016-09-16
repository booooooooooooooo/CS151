package hw1;

import java.util.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Model {
  public Chart firstChart;
  public Chart economyChart;

  public Model(String path)throws IOException, ClassNotFoundException{
    firstChart = new Chart("First");
    economyChart = new Chart("Economy");
    readInOrderInfoFromFile(path);
  }
  private void readInOrderInfoFromFile(String path)throws IOException,
			ClassNotFoundException{
    File f = new File(path);
    if( !f.exists()) {
        return;
    }
    FileInputStream fis = new FileInputStream(path);
		ObjectInputStream ois = new ObjectInputStream(fis);
		firstChart.panel = (List<List<Passenger>>)ois.readObject();
    economyChart.panel = (List<List<Passenger>>)ois.readObject();
		ois.close();
  }

  public void writeOrderInfoToFile(String path)throws IOException{
    FileOutputStream fos = new FileOutputStream(path);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
    try{
      oos.writeObject(firstChart.panel);
      oos.writeObject(economyChart.panel);
    }catch(IOException e){}
		fos.close();
  }
  public String addPassenger(String name, String serviceClass){
    if(serviceClass.equals("First")) return firstChart.addPassenger(name);
    else return economyChart.addPassenger(name);
  }
  public String addPassenger(String name, String serviceClass, String seatPreference){
    if(serviceClass.equals("First")) return firstChart.addPassenger(name, seatPreference);
    else return economyChart.addPassenger(name, seatPreference);
  }
  public String addEcoClassPassenger(String name, String seatPreference){
    return economyChart.addPassenger(name, seatPreference);
  }
  public List<String>  addFirstClasssGroup(String groupName, List<String> names){
    return firstChart.addGroup(groupName, names);
  }
  public List<String>  addEcoClassGroup(String groupName, List<String> names){
    return economyChart.addGroup(groupName, names);
  }
  public boolean cancelPassenger(String name){
    return firstChart.cancelPassenger(name) || economyChart.cancelPassenger(name);
  }
  public boolean cancelGroup(String groupName){
    return firstChart.cancelGroup(groupName) || economyChart.cancelGroup(groupName);
  }
  public boolean isFull(){
    return firstChart.getNumberOfAvailableSeats() == 0 && economyChart.getNumberOfAvailableSeats() == 0;
  }
}
