import java.util.Calendar;
import java.util.GregorianCalendar;
public class TestModelAndView {
  public static void main(String args[]){
    GregorianCalendar cal = new GregorianCalendar(2016, 7, 2);
    View.displayMonthWithEventHighLighted(cal, null);
  }
}
