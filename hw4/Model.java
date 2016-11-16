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
  private final String[] monthNames = {"January", "Febrary", "March", "April", "May", "June", "July", "Auguest", "September", "October", "November", "December"};
  private Calendar highlightedCal; // the current date used by view
  private String filePath;
  private List<Event> events; // in order of start time
  private View view;
  /**
    Constructor
    */
  public Model(String fp) {
    highlightedCal = new GregorianCalendar();
    this.filePath = fp;
    events = loadEvents();
  }

  /**
    one of IO. Called by Constructor only.
    */
  private List<Event> loadEvents() {
    List<Event> result = new ArrayList<Event>();
    File f = new File(filePath);
    if (!f.exists() && !f.isDirectory()) {
      result = new ArrayList<Event>();
    } else {
      try {
        FileInputStream fis = new FileInputStream(filePath);
        ObjectInputStream ois = new ObjectInputStream(fis);
        result = (List<Event>)ois.readObject();
        ois.close();
        fis.close();
      } catch (IOException e1) {
        // TODO
      } catch (ClassNotFoundException e2) {
        // TODO
      }
    }
    return result;
  }
  /**
    one of IO. Called when user quit calendar.
    */
  public void writeEventsToFile() {
    try {
      FileOutputStream fos = new FileOutputStream(filePath);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(events);
      oos.close();
      fos.close();
    } catch (IOException e) {
      // TODO
    }
  }

  /**
    Attach view to model
    */
  public void attach(View v) { this.view = v; }

  /**
    one of accessors.
    */
  public List<Event> getDayEventsOnHighlightedCal() {
    List<Event> result = new ArrayList<Event>();
    for (int i = 0; i < events.size(); i++) {
      Calendar startCal = events.get(i).startCal;
      if (startCal.get(startCal.YEAR) ==
              highlightedCal.get(highlightedCal.YEAR) &&
          startCal.get(startCal.MONTH) ==
              highlightedCal.get(highlightedCal.MONTH) &&
          startCal.get(startCal.DAY_OF_MONTH) ==
              highlightedCal.get(highlightedCal.DAY_OF_MONTH)) {
        result.add(events.get(i));
      }
    }
    return result;
  }
  /**
    one of accessors.
    */
  public Calendar getHighlightedCal() { return highlightedCal; }

  /**
   one of Mutators
   */
  public boolean createEventOnHighlightedCal(String startHM, String endHM,
                                          String title) {
    Event event = new Event(title, parseToCal(startHM), parseToCal(endHM));
    boolean suceessInsertion =  insert(event);
    view.drawOnUpdatedData();
    return suceessInsertion;

  }
  /**
   one of Mutators
   */
  public void changeHighlightedCalToDay(int day) {
    highlightedCal.set(highlightedCal.DAY_OF_MONTH, day);
    view.drawOnUpdatedData();
  }
  /**
   one of Mutators
   */
  public void changeHighlightedCalToNextMonth() {
    highlightedCal.add(highlightedCal.MONTH, 1);
    highlightedCal.set(highlightedCal.DAY_OF_MONTH, 1);
    view.drawOnUpdatedData();
  }
  /**
   one of Mutators
   */
  public void changeHighlightedCalToPrevMonth() {
    highlightedCal.add(highlightedCal.MONTH, -1);
    highlightedCal.set(highlightedCal.DAY_OF_MONTH, 1);
    view.drawOnUpdatedData();
  }

  /**
   one of Utilities. Parse string to Calendar instance.
   */
  public Calendar parseToCal(String hm) {
    int month = highlightedCal.get(highlightedCal.MONTH);
    int day = highlightedCal.get(highlightedCal.DAY_OF_MONTH);
    int year = highlightedCal.get(highlightedCal.YEAR);

    String[] parts = hm.split(":");
    int hour = Integer.parseInt(parts[0]);
    int minute = Integer.parseInt(parts[1]);

    return new GregorianCalendar(year, month, day, hour, minute);
  }
  /**
   one of Utilities. Convert Calendar instance to string "mm/dd/yyyy".
   */
  public String getMMDDYYYY(){
    int month = highlightedCal.get(highlightedCal.MONTH) ;
    int day = highlightedCal.get(highlightedCal.DAY_OF_MONTH);
    int year = highlightedCal.get(highlightedCal.YEAR);
    String result = "";
    result += month + 1;
    result += "/";
    result += day;
    result += "/";
    result += year;
    return result;
  }
  /**
   one of Utilities. Convert Calendar instance to string "month yyyy".
   */
  public String getMonthYYYY(){
    int month = highlightedCal.get(highlightedCal.MONTH);
    int year = highlightedCal.get(highlightedCal.YEAR);
    String result = "";
    result += monthNames[month];
    result += " ";
    result += year;
    return result;
  }

  /**
   one of Utilities. Insert event to events list. Keep acsending order.
   */
  private boolean insert(Event event) {
    int i = 0;
    for (i = 0; i < events.size(); i++) {
      if (events.get(i).endCal.compareTo(event.startCal) < 0 && ( i == events.size() - 1 || events.get(i + 1).startCal.compareTo(event.endCal) > 0 ) )
        break;
    }
    if(i == events.size() ) return false;

    //insert in position i + 1
    events.add(null); // increase size of events list by 1
    for (int j = events.size() - 1; j > i + 1; j--) {
      events.set(j, events.get(j - 1));
    }
    events.set(i + 1, event);
    return true;
  }
}
