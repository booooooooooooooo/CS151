import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class TestParse {
  public static void main(String args[]) {
    Calendar cal = parseToCal("10/03/2016");
    System.out.println(cal.getTime());
    Calendar anotherCal = parseToCal("10/03/2016", "21:20");
    System.out.println(anotherCal.getTime());
  }
  public static Calendar parseToCal(String date) {
    String[] parts = date.split("/");
    int month = Integer.parseInt(parts[0]);
    int day = Integer.parseInt(parts[1]);
    ;
    int year = Integer.parseInt(parts[2]);
    ;
    return new GregorianCalendar(year, month, day);
  }

  public static Calendar parseToCal(String date, String time) {
    String[] parts = date.split("/");
    int month = Integer.parseInt(parts[0]);
    int day = Integer.parseInt(parts[1]);
    ;
    int year = Integer.parseInt(parts[2]);
    ;

    String[] anotherParts = time.split(":");
    int hour = Integer.parseInt(anotherParts[0]);
    int minute = Integer.parseInt(anotherParts[1]);

    return new GregorianCalendar(year, month, day, hour, minute);
  }
}
