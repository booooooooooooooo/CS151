// Calendar startCal = new GregorianCalendar(year, month, dayOfMonth,
//                                           startHourOfDay, startMinute);
// Calendar endCal =
//     new GregorianCalendar(year, month, dayOfMonth, endHourOfDay, endMinute);
// Event event = new Event(title, startCal, endCal);

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

public class MyCalendarTester{
  private static Model model = new Model();
  public static void main(String args[]){
    while(true){
      View.displayMonthWithEventHighLighted(new GregorianCalendar(), model.getEventListOfMonth(new GregorianCalendar()));
      View.displayMainMenu();
      String input = View.getInput();
      if(input.equals("q") || input.equals("Q")){
        model.writeEventsToFile("/Users/xiaohei/Documents/cs151/hw2/events.txt");
        break;
      }else{
        callCorrespondingmethod(input);
      }
    }
  }

  public static void callCorrespondingmethod(String input){
    if(input.equals("l") || input.equals("L")){
      load();
    }else if(input.equals("v") || input.equals("V")){
      view();
    }else if(input.equals("c") || input.equals("C")){
      create();
    }else if(input.equals("g") || input.equals("G")){
      goTo();
    }else if(input.equals("e") || input.equals("E")){
      eventList();
    }else if(input.equals("d") || input.equals("D")){
      delete();
    }else{
      View.displayErrorInput();
    }
  }

  public static void load(){
    model.loadEventsFromFile("/Users/xiaohei/Documents/cs151/hw2/events.txt");
  }

  public static void view(){
    View.displayMsg("[D]ay view or [M]view ? ");
    String input = View.getInput();
    Calendar cal = new GregorianCalendar();
    if(input.equals("D") || input.equals("d")) View.displayDayWithEventList(cal, model.getEventListOfDay(cal));
    else if(input.equals("M") || input.equals("m")) View.displayMonthWithEventHighLighted(cal, model.getEventListOfMonth(cal));
    else{
      View.displayMsg("Error input! Please read guideline carefully!");
      return;
    }
    while(true){
      View.displayMsg("[P]revious or [N]ext or [M]ain menu ? ");
      String option = View.getInput();
      if(option.equals("M") || option.equals("m")) return;
      else if(option.equals("P") || option.equals("p")){
        if(input.equals("D") || input.equals("d")){
          cal.add(cal.DAY_OF_MONTH, -1);
          View.displayDayWithEventList(cal, model.getEventListOfDay(cal));
        }else{
          cal.add(cal.MONTH, -1);
          View.displayMonthWithEventHighLighted(cal, model.getEventListOfMonth(cal));
        }
      }else if(option.equals("N") || option.equals("n")){
        if(input.equals("D") || input.equals("d")){
          cal.add(cal.DAY_OF_MONTH, 1);
          View.displayDayWithEventList(cal, model.getEventListOfDay(cal));
        }else{
          cal.add(cal.MONTH, 1);
          View.displayMonthWithEventHighLighted(cal, model.getEventListOfMonth(cal));
        }
      }else{
        View.displayMsg("Error input! Please read guideline carefully!");
        return;
      }

    }
  }

  public static void create(){
    //TODO
  }

  public static void goTo(){
    //TODO
  }

  public static void eventList(){
    //TODO
  }

  public static void delete(){
    //TODO
  }

}
