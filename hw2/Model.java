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
  private GregorianCalendar greCalToday;

  public Model() {
    events = new ArrayList<Event>();
    greCalToday = new GregorianCalendar(); // capture today
  }

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

  public List<Event> getEventListOfDay(Cal cal) {
    int year = calendar.get(Calendar.YEAR);
    int month = calendar.get(Calendar.MONTH); // 0 - 11
    int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
    int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK); // 1 - 7, sun - saturday
  }

  public void createEvent(String title, int year, int month, int day_of_month,
                          int start_hour_of_day, int start_minute) {
    // TODO
  }

  public void createEvent(String title, int year, int month, int day_of_month,
                          int start_hour_of_day, int start_minute,
                          int end_hour_of_day, int end_minute) {
    // TODO
  }

  public void deleteDayEvent(int year, int month, int day_of_month){
    //TODO
  }

  public void delteAllEvents(){
    events.clear();
  }

  public List<Event> getEventListOfMonth(Cal cal) {
    // TODO
  }

  public List<Event> getWholeEventList() {
    // TODO
  }

  public Calendar getGreCalInstanceOfToday() { return greCalToday; }
  public Calendar getGreCalInstanceOfGivenDay(int year, int month,
                                              int day_in_month) {
    // TODO
  }
}
