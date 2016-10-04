import java.util.Scanner;
public class View {
  public static displayMainMenu(Calendar today) {
    displayMonthWithEventHighLighted(today);
    // TODO
  }

  public static displayMonthWithEventHighLighted(Calendar anyDay) {
    // TODO
  }

  public static displayDayWithEvnetList(Calendar anyDay) {
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
