import java.util.Scanner;
public class View {
  public static displayMainMenu(Calendar now, List<Event> events) {
    displayMonthWithEventHighLighted(now, events);
    // TODO
  }

  public static displayMonthWithEventHighLighted(Calendar anytime, List<Event> events) {
    // TODO
  }

  public static displayDayWithEvnetList(Calendar anytime) {
    // TODO
  }

  public static String getInput() {
    public static Scanner cin = new Scanner(System.in);
    String input = cin.nextLine();
    return input;
  }

  public static void promptFirstRun() {
    System.out.println("First run of calendar app!");
  }
}
