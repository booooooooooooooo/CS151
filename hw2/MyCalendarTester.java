import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;

public class MyCalendarTester {
  private static Model model = new Model();
  public static void main(String args[]) {
    while (true) {
      View.displayMonthWithEventHighLighted(
          new GregorianCalendar(),
          model.getEventListOfMonth(new GregorianCalendar()));
      View.displayMainMenu();
      String input = View.getInput();
      if (input.equals("q") || input.equals("Q")) {
        model.writeEventsToFile(
            "/Users/xiaohei/Documents/cs151/hw2/events.txt");
        break;
      } else {
        callCorrespondingmethod(input);
      }
    }
  }

  public static void callCorrespondingmethod(String input) {
    if (input.equals("l") || input.equals("L")) {
      load();
    } else if (input.equals("v") || input.equals("V")) {
      view();
    } else if (input.equals("c") || input.equals("C")) {
      create();
    } else if (input.equals("g") || input.equals("G")) {
      goTo();
    } else if (input.equals("e") || input.equals("E")) {
      eventList();
    } else if (input.equals("d") || input.equals("D")) {
      delete();
    } else {
      View.displayErrorInput();
    }
  }

  public static void load() {
    model.loadEventsFromFile("/Users/xiaohei/Documents/cs151/hw2/events.txt");
  }

  public static void view() {
    View.displayMsg("[D]ay view or [M]view ? ");
    String input = View.getInput();
    Calendar cal = new GregorianCalendar();
    if (input.equals("D") || input.equals("d")) {
      View.displayDayWithEventList(cal, model.getEventListOfDay(cal));
      proceedDayView(cal);
    } else if (input.equals("M") || input.equals("m")) {
      View.displayMonthWithEventHighLighted(cal,
                                            model.getEventListOfMonth(cal));
      proceedMonthView(cal);
    } else {
      View.displayMsg("Error input! Please read guideline carefully!");
      return;
    }
  }

  public static void proceedDayView(Calendar cal) {
    while (true) {
      View.displayMsg("[P]revious or [N]ext or [M]ain menu ? ");
      String option = View.getInput();
      if (option.equals("M") || option.equals("m"))
        return;
      else if (option.equals("P") || option.equals("p")) {
        cal.add(cal.DAY_OF_MONTH, -1);
        View.displayDayWithEventList(cal, model.getEventListOfDay(cal));
      } else if (option.equals("N") || option.equals("n")) {
        cal.add(cal.DAY_OF_MONTH, 1);
        View.displayDayWithEventList(cal, model.getEventListOfDay(cal));
      } else {
        View.displayMsg("Error input! Please read guideline carefully!");
        return;
      }
    }
  }

  public static void proceedMonthView(Calendar cal) {
    while (true) {
      View.displayMsg("[P]revious or [N]ext or [M]ain menu ? ");
      String option = View.getInput();
      if (option.equals("M") || option.equals("m"))
        return;
      else if (option.equals("P") || option.equals("p")) {

          cal.add(cal.MONTH, -1);
          View.displayMonthWithEventHighLighted(cal,
                                              model.getEventListOfMonth(cal));
      } else if (option.equals("N") || option.equals("n")) {

          cal.add(cal.MONTH, 1);
          View.displayMonthWithEventHighLighted(cal,
                                                model.getEventListOfMonth(cal));
      } else {
        View.displayMsg("Error input! Please read guideline carefully!");
        return;
      }
    }
  }

  public static void create() {
    View.displayMsg("Please enter title:");
    String title = View.getInput();
    View.displayMsg("Please enter date in MM/DD/YYYY format:");
    String date = View.getInput();
    View.displayMsg("Please enter start time in HH:MM 24-hour clock format:");
    String startTime = View.getInput();
    View.displayMsg(
        "Please enter end time in HH:MM 24-hour clock format. If no end time, please leave blank.");
    String endTime = View.getInput();
    if(endTime.equals("")){
      model.createEvent(title, parseToCal(date, startTime) );
    }else model.createEvent(title, parseToCal(date, startTime),
                      parseToCal(date, endTime));
  }

  public static void goTo() {
    View.displayMsg("Please enter date in MM/DD/YYYY format:");
    String date = View.getInput();
    Calendar cal = parseToCal(date);
    View.displayDayWithEventList(cal, model.getEventListOfDay(cal));
  }

  public static void eventList() {
    View.displayEventList(model.getWholeEventList());
  }

  public static void delete() {
    View.displayMsg("[S]elected or [A]ll?");
    String input = View.getInput();
    if (input.equals("S") || input.equals("s")) {
      View.displayMsg("Please enter date in MM/DD/YYYY format:");
      String date = View.getInput();
      model.deleteDayEvent(parseToCal(date));
    } else if (input.equals("A") || input.equals("a")) {
      model.delteAllEvents();
    } else
      View.displayErrorInput();
  }

  public static Calendar parseToCal(String date) {
    String[] parts = date.split("/");
    int month = Integer.parseInt(parts[0]) - 1;
    int day = Integer.parseInt(parts[1]);
    ;
    int year = Integer.parseInt(parts[2]);
    ;
    return new GregorianCalendar(year, month, day);
  }

  public static Calendar parseToCal(String date, String time) {
    String[] parts = date.split("/");
    int month = Integer.parseInt(parts[0]) - 1;
    int day = Integer.parseInt(parts[1]);
    ;
    int year = Integer.parseInt(parts[2]);
    ;

    String[] anotherParts = time.split(":");
    int hour = Integer.parseInt(anotherParts[0]);
    int minute = Integer.parseInt(anotherParts[1]);

    return new GregorianCalendar(year, month, day, hour, minute);
  }
}
