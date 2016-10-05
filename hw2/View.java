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

  // public static void displayMainMenu(Calendar now, List<Event> events) {
  //   displayMonthWithEventHighLighted(now, events);
  //   // TODO
  // }

  public static void displayMonthWithEventHighLighted(Calendar cal,
                                                      List<Event> events) {
    System.out.print("         ");
    System.out.printf(arrayOfMonths[cal.get(cal.MONTH)]);
    System.out.print("  ");
    System.out.println(cal.get(cal.YEAR));
    for (int i = 0; i < arrayOfDays.length; i++) {
      System.out.printf("%4s", arrayOfDays[i]);
    }
    System.out.println();

    cal.set(cal.DAY_OF_MONTH, 1);
    int myMonth = cal.get(cal.MONTH);
    int startDayOfWeek = cal.get(cal.DAY_OF_WEEK);

    int dayOfWeek = startDayOfWeek;
    for (int j = 0; j <= startDayOfWeek; j++) {
      System.out.print("    ");
    }

    while (myMonth == cal.get(cal.MONTH)) {
      // TODO: hightlight day which has event
      System.out.printf("%4d", cal.get(cal.DAY_OF_MONTH));
      cal.add(cal.DAY_OF_MONTH, 1);
      dayOfWeek++;
      if ((dayOfWeek + 1) % 7 == 0)
        System.out.println();
    }
    System.out.println();
  }
  //
  // public static void displayDayWithEvnetList(Calendar anytime, List<Event>
  // events) {
  //   // TODO
  // }
  //
  // public static String getInput() {
  //   public static Scanner cin = new Scanner(System.in);
  //   String input = cin.nextLine();
  //   return input;
  // }
  //
  public static void promptFirstRun() {
    System.out.println("First run of calendar app!");
  }
}
