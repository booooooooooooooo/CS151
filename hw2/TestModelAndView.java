import java.util.Calendar;
import java.util.GregorianCalendar;
public class TestModelAndView {
  public static void main(String args[]) {
    GregorianCalendar cal = new GregorianCalendar();
    Model model = new Model();
    model.loadEventsFromFile("/Users/xiaohei/Documents/cs151/hw2/events.txt");
    for(int i = 0; i < model.events.size(); i++){
      // System.out.println(model.events.get(i));
    }
    model.createEvent("Create first event", 2016, 9, 4,21, 30);
    for(int i = 0; i < model.events.size(); i++){
      System.out.println(model.events.get(i));
    }
    model.writeEventsToFile("/Users/xiaohei/Documents/cs151/hw2/events.txt");
    // View.displayMonthWithEventHighLighted(cal, null);
  }
}
