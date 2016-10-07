import java.util.Scanner;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
/**
 View.
 */
public class View {
  public static String[] arrayOfMonths = {"Jan", "Feb",  "March", "Apr",
                                          "May", "June", "July",  "Aug",
                                          "Sep", "Oct",  "Nov",   "Dec"};
  public static String[] arrayOfDays = {"Su", "Mo", "Tu", "We",
                                        "Th", "Fr", "Sa"};
  public static
    Scanner cin = new Scanner(System.in);
  /**
   Display main menu.
   */
  public static void displayMainMenu() {
    System.out.println(
        "Select one of the following options:\n[L]oad [V]iew by [C]reate [G]o to [E]vent list [D]elete [Q]uit");
  }

  /**
   Display month calendar.  Mark " on days which have event, mark [] on the day which is today.
   */
  public static void
  displayMonthWithEventHighLighted(Calendar calPara,
                                   List<Event> eventListOfMonth) {
    Calendar cal = (Calendar)calPara.clone();

    int myMonth = cal.get(cal.MONTH);
    cal.set(cal.DAY_OF_MONTH, 1);
    // print month and year
    System.out.print("       ");
    System.out.printf(arrayOfMonths[cal.get(cal.MONTH)]);
    System.out.print("  ");
    System.out.println(cal.get(cal.YEAR));
    // print Su Mo Tu We Th Fr Sa
    for (int i = 0; i < arrayOfDays.length; i++) {
      System.out.printf("%5s", arrayOfDays[i]);
    }
    System.out.println();
    // print body
    for (int j = 1; j < cal.get(cal.DAY_OF_WEEK); j++) {
      System.out.print("     ");
    }
    int i = 0; // tail of eventListOfMonth
    Calendar today = new GregorianCalendar();
    while (myMonth == cal.get(cal.MONTH)) {
      boolean hasEvent = false;
      if (i < eventListOfMonth.size()) {
        Calendar startCal = eventListOfMonth.get(i).startCal;
        if (startCal.get(startCal.DAY_OF_MONTH) == cal.get(cal.DAY_OF_MONTH)) {
          hasEvent = true;
          while (i < eventListOfMonth.size()) {
            startCal = eventListOfMonth.get(i).startCal;
            if (startCal.get(startCal.DAY_OF_MONTH) ==
                cal.get(cal.DAY_OF_MONTH))
              i++;
            else
              break;
          }
        }
      }
      boolean isToday =
          today.get(today.YEAR) == cal.get(cal.YEAR) &&
                  today.get(today.MONTH) == cal.get(cal.MONTH) &&
                  today.get(today.DAY_OF_MONTH) == cal.get(cal.DAY_OF_MONTH)
              ? true
              : false;
      if (isToday && hasEvent) {
        System.out.printf("[%2d]\"", cal.get(cal.DAY_OF_MONTH));
      } else if (hasEvent) {
        System.out.printf("  %2d\"", cal.get(cal.DAY_OF_MONTH));
      } else if (isToday) {
        System.out.printf(" [%2d]", cal.get(cal.DAY_OF_MONTH));
      } else
        System.out.printf("%5d", cal.get(cal.DAY_OF_MONTH));
      if (cal.get(cal.DAY_OF_WEEK) % 7 == 0)
        System.out.println();
      cal.add(cal.DAY_OF_MONTH, 1);
    }
    System.out.println();
  }
  /**
   Display date of a specific day. Display events happend in that day.
   */
  public static void displayDayWithEventList(Calendar cal,
                                             List<Event> eventListOfDay) {
    System.out.println(cal.getTime());
    for (int i = 0; i < eventListOfDay.size(); i++)
      System.out.println(eventListOfDay.get(i));
  }
  /**
   Display list of events.
   */
  public static void displayEventList(List<Event> events) {
    for (int i = 0; i < events.size(); i++) {
      System.out.println(events.get(i));
    }
  }
  /**
   Get input from user.
   */
  public static String getInput() {
    String input = cin.nextLine();
    return input;
  }
  /**
   Display error input msg.
   */
  public static void displayErrorInput() {
    System.out.println("Error input! Please read guideline carefully!");
  }
  /**
   Display first run msg.
   */
  public static void displayFirstRunMsg() {
    System.out.println("First run of calendar app!");
  }
  /**
   Display IO error msg.
   */
  public static void displayIOError() {
    System.out.println("Error loading or writing data!");
  }
  /**
   Display given msg.
   */
  public static void displayMsg(String msg) { System.out.println(msg); }
}
