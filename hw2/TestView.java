import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
public class TestView {
  public static void main(String args[]) {
    GregorianCalendar cal = new GregorianCalendar();
    Model model = new Model();
    model.loadEventsFromFile("/Users/xiaohei/Documents/cs151/hw2/events.txt");
    View.displayMonthWithEventHighLighted(cal, model.getEventListOfMonth(cal));
    View.displayDayWithEvnetList(
        cal, model.getEventListOfDay(new GregorianCalendar(2016, 9, 5)));
  }
}
