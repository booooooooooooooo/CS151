package hw1;

import java.util.*;

import java.io.IOException;
public class ReservationSystem{
  public static void main(String args[])throws IOException, ClassNotFoundException{
    View.printWelcome();
    Model model = new Model(args[0]);
    while( true ){
      View.promptEnterOptions();
      String option = View.readNextLine();
      if(option.equals("P")) interactAddPassenger(model);
      else if(option.equals("G")) interactAddGroup(model);
      else if(option.equals("C")) interactCancelReservation(model);
      else if(option.equals("A")) View.printAvailability(model);
      else if(option.equals("M")) View.printManifest(model);
      else if(option.equals("Q")) break;
      else continue;
    }
  }

  private static void interactAddPassenger(Model model){
    String seat = null;
    String name;
    String serviceClass;
    String seatPreference;
    do{
      View.promptEnterName();
      name = View.readNextLine();
      View.promptEnterServiceClass();
      serviceClass = View.readNextLine();
      View.promptEnterSeatPreference();
      seatPreference = View.readNextLine();
    }while( !( serviceClass.equals("First") || serviceClass.equals("Economy") )
              || !( seatPreference.equals("W") || seatPreference.equals("C") || seatPreference.equals("A")) );

    seat = model.addPassenger(name, serviceClass, seatPreference);

    if(seat == null && !model.isFull()){
      View.promptEnterChangeSeatPreferenceOption();
      String responce = View.readNextLine();
      if(responce.equals("Y")){
        seat = model.addPassenger(name, serviceClass);
      }else if(responce.equals("N")) ;
      else View.promptEnterChangeSeatPreferenceOption();
    }

    if(seat == null) View.printFailMsg();
    else View.printOrderedSeat(seat);
  }
  private static void interactAddGroup(Model model){
    String groupName;
    List<String> names;
    String serviceClass;
    View.promptEnterGroupName();
    groupName = View.readNextLine();
    View.promptEnterPassengerNames();
    names = View.readListOfNamesFromNextLine();
    do{
      View.promptEnterServiceClass();
      serviceClass = View.readNextLine();
    }while( !serviceClass.equals("First") && !serviceClass.equals("Economy"));

    List<String> seats = model.addGroup(groupName, names, serviceClass);

    if(seats == null) View.printFailMsg();
    else View.printOrderedSeats(seats);
  }

  private static void interactCancelReservation(Model model){
    String iOrG;
    do{
      View.promptCancelIndividualorGroup();
      iOrG = View.readNextLine();
    }while( !iOrG.equals("I") && !iOrG.equals("G"));

    if(iOrG.equals("I")){
      View.promptEnterName();
      String name = View.readNextLine();
      boolean succeed = model.cancelPassenger(name);
      if(succeed) View.printCancelSucceed();
      else View.printPassengerDoesNotExist();
    }else{
      View.promptEnterGroupName();
      String groupName = View.readNextLine();
      boolean succeed = model.cancelGroup(groupName);
      if(succeed) View.printCancelSucceed();
      else View.printGroupDoesNotExist();
    }
  }
}
