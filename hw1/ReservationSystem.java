package hw1;

import java.util.*;
public class ReservationSystem{
  public static void main(String args[]){
    Model model = new Model(args[0]);
    View.printOptions();
    Scanner cin = new Scanner(System.in);
    String option = cin.nextLine();
    while( !option.equals("Q")){
      if(option.equals("I")) interactAddPassenger(model);
      else if(option.equals("G")) interactAddGroup(model);
      else if(option.equals("C")) interactCancelReservation(model);
      else if(option.equals("A")) View.printAvailability(model);
      else if(option.equals("M")) View.printManifest(model);
      else View.printOptions();
    }
  }

  private static void interactAddPassenger(Model model){
    String seat = null;
    Scanner cin = new Scanner(System.in);
    String name;
    String serviceClass;
    String seatPreference;
    do{
      View.promptName();
      name = cin.nextLine();
      View.promptServiceClass();
      serviceClass = cin.nextLine();
      View.promptSeatPreference();
      seatPreference = cin.nextLine();
    }while( !(serviceClass.equals("First") || serviceClass.equals("Economy")) )
              || !( seatPreference.equals("W") || seatPreference.equals("C") || seatPreference.equals("A")) )

    seat = model.addPassenger(name, serviceClass, eatPreference);

    if(seat == null && !model.isFull()){
      View.promptChangeSeatPreference();
      String responce = cin.nextLine();
      if(responce.equals("Y")){
        seat = model.addPassenger(name, serviceClass);
      }else if(responce.equals("N")) ;
      else View.promptChangeSeatPreference();
    }

    if(seat == null) View.printRequestFail();
    else View.printSeat(seat);
  }
  private static void interactAddGroup(Model model){

  }
  private static void interactCancelReservation(Model model){

  }
}
