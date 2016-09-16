package hw1;

import java.util.*;

import java.io.IOException;
public class ReservationSystem{
  public static void main(String args[])throws IOException, ClassNotFoundException{
    View view = new View();
    Model model = new Model(args[0]);
    view.printWelcome();
    while( true ){
      view.promptEnterOptions();
      String option = view.readNextLine();
      if(option.equals("P")) interactAddPassenger(model, view);
      else if(option.equals("G")) interactAddGroup(model, view);
      else if(option.equals("C")) interactCancelReservation(model, view);
      else if(option.equals("A")) view.printAvailability(model);
      else if(option.equals("M")) view.printManifest(model);
      else if(option.equals("Q")) break;
      else continue;
    }
  }

  private static void interactAddPassenger(Model model, View view){
    String seat = null;
    String name;
    String serviceClass;
    String seatPreference;
    do{
      view.promptEnterName();
      name = view.readNextLine();
      view.promptEnterServiceClass();
      serviceClass = view.readNextLine();
      view.promptEnterSeatPreference();
      seatPreference = view.readNextLine();
    }while( !( serviceClass.equals("First") || serviceClass.equals("Economy") )
              || !( seatPreference.equals("W") || seatPreference.equals("C") || seatPreference.equals("A")) );

    seat = model.addPassenger(name, serviceClass, seatPreference);

    if(seat == null && !model.isFull()){
      view.promptEnterChangeSeatPreferenceOption();
      String responce = view.readNextLine();
      if(responce.equals("Y")){
        seat = model.addPassenger(name, serviceClass);
      }else if(responce.equals("N")) ;
      else view.promptEnterChangeSeatPreferenceOption();
    }

    if(seat == null) view.printFailMsg();
    else view.printOrderedSeat(seat);
  }
  private static void interactAddGroup(Model model, View view){
    String groupName;
    List<String> names;
    String serviceClass;
    view.promptEnterGroupName();
    groupName = view.readNextLine();
    view.promptEnterPassengerNames();
    names = view.readListOfNamesFromNextLine();
    do{
      view.promptEnterServiceClass();
      serviceClass = view.readNextLine();
    }while( !serviceClass.equals("First") && !serviceClass.equals("Economy"));

    List<String> seats = model.addGroup(groupName, names, serviceClass);

    if(seats == null) view.printFailMsg();
    else view.printOrderedSeats(seats);
  }

  private static void interactCancelReservation(Model model, View view){
    String iOrG;
    do{
      view.promptCancelIndividualorGroup();
      iOrG = view.readNextLine();
    }while( !iOrG.equals("I") && !iOrG.equals("G"));

    if(iOrG.equals("I")){
      view.promptEnterName();
      String name = view.readNextLine();
      boolean succeed = model.cancelPassenger(name);
      if(succeed) view.printCancelSucceed();
      else view.printPassengerDoesNotExist();
    }else{
      view.promptEnterGroupName();
      String groupName = view.readNextLine();
      boolean succeed = model.cancelGroup(groupName);
      if(succeed) view.printCancelSucceed();
      else view.printGroupDoesNotExist();
    }
  }
}
