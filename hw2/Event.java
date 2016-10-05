/**
  Represent event.
 */
public class Event implements Comparable<Event>, java.io.Serializable{
  public String title;
  public int year;  // e.g 2016
  public int month; // 0 - 11
  public int dayOfMonth;
  public int dayOfWeek; // 1 - 7
  public int startHourOfDay;
  public int startMinute;
  public int endHourOfDay;
  public int endMinute;

  public String[] arrayOfMonths = {"Jan",  "Feb", "March", "Apr", "May", "June",
                                   "July", "Aug", "Sep",   "Oct", "Nov", "Dec"};
  public String[] arrayOfDays = {"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};

  public Event(String title, int year, int month, int dayOfMonth,
               int startHourOfDay, int startMinute, int endHourOfDay,
               int endMinute) {
    this.title = title;
    this.year = year;
    this.month = month;
    this.dayOfMonth = dayOfMonth;
    this.startHourOfDay = startHourOfDay;
    this.startMinute = startMinute;
    this.endHourOfDay = endHourOfDay;
    this.endMinute = endMinute;
  }
  public Event(String title, int year, int month, int dayOfMonth,
               int startHourOfDay, int startMinute) {
    this.title = title;
    this.year = year;
    this.month = month;
    this.dayOfMonth = dayOfMonth;
    this.startHourOfDay = startHourOfDay;
    this.startMinute = startMinute;
    this.endHourOfDay = startHourOfDay;
    this.endMinute = startMinute;
  }
  @Override
  public int compareTo(Event other) {
    if (year < other.year)
      return -1;
    if (year > other.year)
      return 1;

    if (month < other.month)
      return -1;
    if (month > other.month)
      return 1;

    if (dayOfMonth < other.dayOfMonth)
      return -1;
    if (dayOfMonth > other.dayOfMonth)
      return 1;

    if (startHourOfDay < other.startHourOfDay)
      return -1;
    if (startHourOfDay > other.startHourOfDay)
      return 1;

    if (startMinute < other.startMinute)
      return -1;
    if (startMinute > other.startMinute)
      return 1;

    return 0;
  }

  @Override
  public String toString() {
    String result = "";

    result += arrayOfMonths[month];
    result += "/";
    result += dayOfMonth;
    result += "/";
    result += year;
    result += "/";
    result += " ";
    result += arrayOfDays[dayOfWeek];
    result += " ";
    result += startHourOfDay;
    result += ":";
    result += startMinute;
    result += " - ";
    result += endHourOfDay;
    result += ":";
    result += endMinute;
    result += " ";
    result += title;

    return result;
  }
}
