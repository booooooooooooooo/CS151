/**
  Represent event.
 */

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Event implements java.io.Serializable {
  public String title;
  public Calendar startCal;
  public Calendar endCal;

  public Event(String title, Calendar startCal, Calendar endCal) {
    this.title = title;
    this.startCal = startCal;
    this.endCal = endCal;
  }
  public Event(String title, Calendar startCal) {
    this.title = title;
    this.startCal = startCal;
    this.endCal = startCal;
  }

  @Override
  public String toString() {
    String result = "";
    result += startCal.getTime();
    result += " - ";
    result += endCal.getTime();
    result += "   ";
    result += title;
    return result;
  }
}
