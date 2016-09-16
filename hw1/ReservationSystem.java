package hw1;

import java.util.*;
public class ReservationSystem{
  public static void main(String args[]){
    Model model = new Model(args[0]);
    View.printOptions();
    String option = View.readNextLine();
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
    String name;
    String serviceClass;
    String seatPreference;
    do{
      View.promptName();
      name = View.readNextLine();
      View.promptServiceClass();
      serviceClass = View.readNextLine();
      View.promptSeatPreference();
      seatPreference = View.readNextLine();
    }while( !(serviceClass.equals("First") || serviceClass.equals("Economy")) )
              || !( seatPreference.equals("W") || seatPreference.equals("C") || seatPreference.equals("A")) )

    seat = model.addPassenger(name, serviceClass, eatPreference);

    if(seat == null && !model.isFull()){
      View.promptChangeSeatPreferenceOption();
      String responce = View.readNextLine();
      if(responce.equals("Y")){
        seat = model.addPassenger(name, serviceClass);
      }else if(responce.equals("N")) ;
      else View.promptChangeSeatPreferenceOption();
    }

    if(seat == null) View.printRequestFail();
    else View.printSeat(seat);
  }
  private static void interactAddGroup(Model model){
    String groupName;
    String[] names;
    String serviceClass;
    View.promptEnterGroupName();
    groupName = View.readNextLine();
    View.promptEnterPassengerNames();
    names = View.readListOfNamesFromNextLine();
    do{
      View.promptServiceClass();
      serviceClass = View.readNextLine();
    }while( !serviceClass.equals("First") && !serviceClass.equals("Economy"));

    List<String> seats = model.addGroup(groupName, names, serviceClass);

    if(seats == null) View.printRequestFail();
    else View.printSeats(seats);
  }

  private static void interactCancelReservation(Model model){

  }
}
