import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.ArrayList;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;

public class Model {
  public List<Event> events;

  public Model() { events = new ArrayList<Event>(); }

  public void loadEventsFromFile(String path) {
    File f = new File(path);
    if (!f.exists() && !f.isDirectory()) {
      View.promptFirstRun();
    } else {
      try {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        events = (List<Event>)ois.readObject();
        ois.close();
        fis.close();
      } catch (IOException e1) {
        System.out.println("Error loading data!" + e1);
      } catch (ClassNotFoundException e2) {
        System.out.println("Class not found!" + e2);
      }
    }
  }

  public void writeEventsToFile(String path) {
    try {
      FileOutputStream fos = new FileOutputStream(path);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(events);
      oos.close();
      fos.close();
    } catch (IOException e) {
      System.out.println("Error writing data!" + e);
    }
  }

  public List<Event> getEventListOfDay(Calendar cal) {
    List<Event> eventListOfDay = new ArrayList<Event>();
    int year = cal.get(cal.YEAR);
    int month = cal.get(cal.MONTH); // 0 - 11
    int dayOfMonth = cal.get(cal.DAY_OF_MONTH);
    int dayOfWeek = cal.get(cal.DAY_OF_WEEK); // 1 - 7, sun - saturday
    for (int i = 0; i < events.size(); i++) {
      Event cur = events.get(i);
      if (cur.year == year && cur.month == month &&
          cur.dayOfMonth == dayOfMonth) {
        eventListOfDay.add(cur);
      }
    }
    return eventListOfDay;
  }

  public List<Event> getEventListOfMonth(Calendar cal) {
    List<Event> eventListOfMonth = new ArrayList<Event>();
    int year = cal.get(cal.YEAR);
    int month = cal.get(cal.MONTH); // 0 - 11
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
                          int startHourOfDay, int startMinute) {

    Event event =
        new Event(title, year, month, dayOfMonth, startHourOfDay, startMinute);
    events.add(event);
    // int i = 0;
    // for (i = 0; i < events.size(); i++) {
    //   Event cur = events.get(i);
    //   if (event.compareTo(cur) < 0)
    //     i++;
    //   else
    //     break;
    // }
    // events.add(null);
    // for (int j = events.size() - 1; j > i; j--) {
    //   events.set(j, events.get(j - 1));
    // }
    // events.set(i, event);
  }

  public void createEvent(String title, int year, int month, int dayOfMonth,
                          int startHourOfDay, int startMinute, int endHourOfDay,
                          int endMinute) {
    Event event = new Event(title, year, month, dayOfMonth, startHourOfDay,
                            startMinute, endHourOfDay, endMinute);
    int i = 0;
    for (i = 0; i < events.size(); i++) {
      Event cur = events.get(i);
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
    for (int i = events.size() - 1; i >= start; i--) {
      events.remove(i);
    }
  }

  public void delteAllEvents() { events.clear(); }

  // TODO: keep or delete
  public Calendar getGreCalOfNow() {
    return new GregorianCalendar(); // capture today
  }
  // TODO: keep or delete
  public Calendar getGreCalInstanceOfGivenTime(int year, int month,
                                               int dayOfMonth) {
    return new GregorianCalendar(year, month, dayOfMonth);
  }
}
