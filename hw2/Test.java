import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
public class Test {
  public static void main(String args[]) {
    Calendar cal = new GregorianCalendar();
    System.out.println(cal.getTime());
    cal.add(cal.MONTH, -1);
    System.out.println(cal.getTime());
    cal.add(cal.MONTH, 1);
    System.out.println(cal.getTime());
  }
}
