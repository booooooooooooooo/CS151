import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Model {
  private List<Event> events;

  public Model() { events = new ArrayList<Event>(); }

  public void loadEventsFromFile(String path) {
    File f = new File(filePathString);
    if (!f.exists() && !f.isDirectory()) {
      View.promptFirstRun();
    } else {
      try {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        events = (List<Event>)ois.readObject();
      } catch (IOException e1, ClassNotFoundException e2) {
        System.out.println("Error loading data!");
      }
      ois.close();
      fis.close();
    }
  }

  public void writeEventsToFile(String path) {
    File f = new File(filePathString);
    try {
      FileOutputStream fos = new FileOutputStream(path);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(events);
    } catch (IOException e) {
      System.out.println("Error writing data!");
    }
    oos.close();
    fos.close();
  }

  public List<Event> getEventListOfDay(Calendar calendar) {
    List<Event> eventListOfDay = new ArrayList<Event>();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH); // 0 - 11
    int dayOfMonth = calendar.get(Calendar.dayOfMonth);
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // 1 - 7, sun - saturday
    for (int i = 0; i < events.size(); i++) {
      Event cur = events.get(i);
      if (cur.year == year && cur.month == month &&
          cur.dayOfMonth == dayOfMonth) {
        eventListOfDay.add(cur);
      }
    }
    return eventListOfDay;
  }

  public List<Event> getEventListOfMonth(Calendar calendar) {
    List<Event> eventListOfMonth = new ArrayList<Event>();
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH); // 0 - 11
    for (int i = 0; i < events.size(); i++) {
      Event cur = events.get(i);
      if (cur.year == year && cur.month == month) {
        eventListOfMonth.add(cur);
      }
    }
    return eventListOfMonth;
  }

  public List<Event> getWholeEventList() { return events; }

  public void createEvent(String title, int year, int month, int dayOfMonth,
                          int start_hour_of_day, int start_minute) {

    Event event = new Event(title, year, month, dayOfMonth, start_hour_of_day,
                            start_minute);
    int i = 0;
    for (i = 0; i < events.size(); i++) {
      Evnet cur = events.get(i);
      if (event.compareTo(cur) < 0)
        i++;
      else
        break;
    }
    events.add(null);
    for (int j = events.size() - 1; j > i; j--) {
      events.set(j, events.get(j - 1));
    }
    events.set(i, event);
  }

  public void createEvent(String title, int year, int month, int dayOfMonth,
                          int start_hour_of_day, int start_minute,
                          int end_hour_of_day, int end_minute) {
    Event event = new Event(title, year, month, dayOfMonth, start_hour_of_day,
                            start_minute, end_hour_of_day, end_minute);
    int i = 0;
    for (i = 0; i < events.size(); i++) {
      Evnet cur = events.get(i);
      if (event.compareTo(cur) < 0)
        i++;
      else
        break;
    }
    events.add(null);
    for (int j = events.size() - 1; j > i; j--) {
      events.set(j, events.get(j - 1));
    }
    events.set(i, event);
  }

  public void deleteDayEvent(int year, int month, int dayOfMonth) {
    int start = -1;
    int end = -1; // [start, end)
    for (int i = 0; i < events.size(); i++) {
      Event cur = events.get(i);
      if (cur.year == year && cur.month == month &&
          cur.dayOfMonth == dayOfMonth) {
        if (start == -1)
          start = i;
      } else {
        if (start != -1 && end == -1)
          end = i;
      }

      if (start != -1 && end != -1)
        break;
    }
    for (int i = end; i < events.size(); i++) {
      events.set(start, events.get(end));
      end++;
      start++;
    }
    events.removeRange(start, events.size());
  }

  public void delteAllEvents() { events.clear(); }

  //TODO: keep or delete
  public Calendar getGreCalOfNow() {
    return new GregorianCalendar(); // capture today
  }
  //TODO: keep or delete
  public Calendar getGreCalInstanceOfGivenTime(int year, int month,
                                              int dayOfMonth) {
    return new GregorianCalendar(year, month, dayOfMonth);
  }
}
