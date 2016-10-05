/**
  Represent event.
 */
public class Event implements Comparable<Event> {
  public String title;
  public int year;  // e.g 2016
  public int month; // 0 - 11
  public int dayOfMonth;
  public int dayOfWeek; // 1 - 7
  public int startHourOfDay;
  public int startMinute;
  public int endHourOfDay;
  public int endMinute;
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
}
