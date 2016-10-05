/**
  Represent event.
 */
public class Event implements Comparable<Event> {
  public String title;
  public int year;  // e.g 2016
  public int month; // 0 - 11
  public int dayOfMonth;
  public int day_of_week; // 1 - 7
  public int start_hour_of_day;
  public int start_minute;
  public int end_hour_of_day;
  public int end_minute;
  public Evnet(String title, int year, int month, int dayOfMonth,
               int start_hour_of_day, int start_minute, int end_hour_of_day,
               int end_minute) {
    this.title = title;
    this.year = year;
    this.month = month;
    this.dayOfMonth = dayOfMonth;
    this.start_hour_of_day = start_hour_of_day;
    this.start_minute = start_minute;
    this.end_hour_of_day = end_hour_of_day;
    this.end_minute = end_minute;
  }
  public Event(String title, int year, int month, int dayOfMonth,
               int start_hour_of_day, int start_minute) {
    this.title = title;
    this.year = year;
    this.month = month;
    this.dayOfMonth = dayOfMonth;
    this.start_hour_of_day = start_hour_of_day;
    this.start_minute = start_minute;
    this.end_hour_of_day = start_hour_of_day;
    this.end_minute = start_minute;
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

    if (day_in_month < other.day_in_month)
      return -1;
    if (day_in_month > other.day_in_month)
      return 1;

    if (start_hour_of_day < other.start_hour_of_day)
      return -1;
    if (start_hour_of_day > other.start_hour_of_day)
      return 1;

    if (minute < other.minute)
      return -1;
    if (minute > other.minute)
      return 1;

    return 0;
  }
}
