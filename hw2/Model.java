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
/**
 Model.
 */
public class Model {
  public List<Event> events; // acsending order

  public Model() { events = new ArrayList<Event>(); }
  /**
   Load events info from file.
   */
  public void loadEventsFromFile(String path) {
    File f = new File(path);
    if (!f.exists() && !f.isDirectory()) {
      View.displayFirstRunMsg();
    } else {
      try {
        FileInputStream fis = new FileInputStream(path);
        ObjectInputStream ois = new ObjectInputStream(fis);
        events = (List<Event>)ois.readObject();
        ois.close();
        fis.close();
      } catch (IOException e1) {
        View.displayIOError();
      } catch (ClassNotFoundException e2) {
        View.displayIOError();
      }
    }
  }
  /**
   Write events infor to file.
   */
  public void writeEventsToFile(String path) {
    try {
      FileOutputStream fos = new FileOutputStream(path);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(events);
      oos.close();
      fos.close();
    } catch (IOException e) {
      View.displayIOError();
    }
  }
  /**
   Get list of events of given day.
   */
  public List<Event> getEventListOfDay(Calendar cal) {
    List<Event> eventListOfDay = new ArrayList<Event>();
    for (int i = 0; i < events.size(); i++) {
      Calendar startCal = events.get(i).startCal;
      if (startCal.get(startCal.YEAR) == cal.get(cal.YEAR) &&
          startCal.get(startCal.MONTH) == cal.get(cal.MONTH) &&
          startCal.get(startCal.DAY_OF_MONTH) == cal.get(cal.DAY_OF_MONTH)) {
        eventListOfDay.add(events.get(i));
      }
    }
    return eventListOfDay;
  }
  /**
   Get list of events of given month.
   */
  public List<Event> getEventListOfMonth(Calendar cal) {
    List<Event> eventListOfMonth = new ArrayList<Event>();
    for (int i = 0; i < events.size(); i++) {
      Calendar startCal = events.get(i).startCal;
      if (startCal.get(startCal.YEAR) == cal.get(cal.YEAR) &&
          startCal.get(startCal.MONTH) == cal.get(cal.MONTH)) {
        eventListOfMonth.add(events.get(i));
      }
    }
    return eventListOfMonth;
  }
  /**
   Get list of all events.
   */
  public List<Event> getWholeEventList() { return events; }

  /**
   Create event. Add it to evnets list.
   */
  public void createEvent(String title, Calendar startCal, Calendar endCal) {
    Event event = new Event(title, startCal, endCal);
    insert(event);
  }
  /**
   Create event without end time. Add it to evnets list.
   */
  public void createEvent(String title, Calendar startCal) {
    Event event = new Event(title, startCal);
    insert(event);
  }
  /**
   Insert event to events list. Keep acsending order.
   */
  private void insert(Event event) {
    int i = 0;
    for (i = 0; i < events.size(); i++) {
      if (events.get(i).startCal.compareTo(event.startCal) < 0)
        continue;
      else
        break;
    }
    events.add(null); // increase size of events list by 1
    for (int j = events.size() - 1; j > i; j--) {
      events.set(j, events.get(j - 1));
    }
    events.set(i, event);
  }
  /**
   Delete all events in the specific day.
   */
  public void deleteDayEvent(Calendar cal) {
    int start = -1;
    int end = -1; // [start, end]
    for (int i = 0; i < events.size(); i++) {
      Calendar startCal = events.get(i).startCal;
      if (startCal.get(startCal.YEAR) == cal.get(cal.YEAR) &&
          startCal.get(startCal.MONTH) == cal.get(cal.MONTH) &&
          startCal.get(startCal.DAY_OF_MONTH) == cal.get(cal.DAY_OF_MONTH)) {
        if (start == -1)
          start = i;
        end = i;
      }
    }
    if (start == -1 && end == -1)
      return;

    for (int i = end + 1; i < events.size(); i++) {
      events.set(start, events.get(i));
      start++;
    }
    for (int i = events.size() - 1; i >= start; i--) {
      events.remove(i);
    }
  }
  /**
   Delete all events.
   */
  public void delteAllEvents() { events.clear(); }
}
