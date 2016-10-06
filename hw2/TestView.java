import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
public class TestView {
  public static void main(String args[]) {
    Model model = new Model();
    model.loadEventsFromFile("/Users/xiaohei/Documents/cs151/hw2/events.txt");
    View.displayMonthWithEventHighLighted(
        new GregorianCalendar(),
        model.getEventListOfMonth(new GregorianCalendar()));
    View.displayMainMenu();
    View.displayDayWithEventList(
        new GregorianCalendar(),
        model.getEventListOfDay(new GregorianCalendar()));
    String input = View.getInput();
    System.out.println(input);
  }
}
