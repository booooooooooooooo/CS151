import java.util.Scanner;
import java.util.Calendar;
import java.util.List;
import java.util.ArrayList;
public class View {
  public static String[] arrayOfMonths = {"Jan", "Feb",  "March", "Apr",
                                          "May", "June", "July",  "Aug",
                                          "Sep", "Oct",  "Nov",   "Dec"};
  public static String[] arrayOfDays = {"Su", "Mo", "Tu", "We",
                                        "Th", "Fr", "Sa"};

  public static void displayMainMenu() {
    System.out.println(
        "Select one of the following options:\n[L]oad [V]iew by [C]reate [G]o to [E]vent list [D]elete [Q]uit");
  }

  public static void
  displayMonthWithEventHighLighted(Calendar cal, List<Event> eventListOfMonth) {

    int myMonth = cal.get(cal.MONTH);
    cal.set(cal.DAY_OF_MONTH, 1);

    System.out.print("       ");
    System.out.printf(arrayOfMonths[cal.get(cal.MONTH)]);
    System.out.print("  ");
    System.out.println(cal.get(cal.YEAR));

    for (int i = 0; i < arrayOfDays.length; i++) {
      System.out.printf("%4s", arrayOfDays[i]);
    }
    System.out.println();

    for (int j = 1; j < cal.get(cal.DAY_OF_WEEK); j++) {
      System.out.print("    ");
    }
    int i = 0; // tail of eventListOfMonth
    while (myMonth == cal.get(cal.MONTH)) {
      // Mark " on days which have event, mark [] on the day which is today TODO
      if (i < eventListOfMonth.size() &&
          eventListOfMonth.get(i).dayOfMonth == cal.get(cal.DAY_OF_MONTH)) {
        System.out.printf("%3d\"", cal.get(cal.DAY_OF_MONTH));
        while (i < eventListOfMonth.size() &&
               eventListOfMonth.get(i).dayOfMonth == cal.get(cal.DAY_OF_MONTH))
          i++;
      } else
        System.out.printf("%4d", cal.get(cal.DAY_OF_MONTH));
      if (cal.get(cal.DAY_OF_WEEK) % 7 == 0)
        System.out.println();
      cal.add(cal.DAY_OF_MONTH, 1);
    }
    System.out.println();
  }

  public static void displayDayWithEvnetList(Calendar cal,
                                             List<Event> eventListOfDay) {
    System.out.println(cal.getTime());
    for (int i = 0; i < eventListOfDay.size(); i++)
      System.out.println(eventListOfDay.get(i));
  }
  //
  // public static String getInput() {
  //   public static Scanner cin = new Scanner(System.in);
  //   String input = cin.nextLine();
  //   return input;
  // }
  //
}
