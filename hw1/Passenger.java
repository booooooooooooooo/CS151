package hw1;

import java.io.Serializable;
class Passenger implements Serializable{
  String name;
  String group;
  public Passenger(String name){
    this.name = name;
    this.group = "";
  }
  public Passenger(String name, String group){
    this.name = name;
    this.group = group;
  }
  public String getName(){
    return this.name;
  }
  public String getGroupName(){
    return this.group;
  }
  @Override
  public String toString(){
    return this.name;
  }
}
