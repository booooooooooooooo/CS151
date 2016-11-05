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

public class Model{
  private Calendar highlightedCal;
  private List<Event> events; // in order of time
  private View view;

  public Model(String filePath){
    highlightedCal = new GregorianCalendar();
    events = loadEvents(filePath);
  }

  public void attach(View v){
    this.view = v;
  }

  private List<Event> loadEvents(String filePath){
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
        //TODO
      } catch (ClassNotFoundException e2) {
        //TODO
      }
    }
    return result;
  }

  public void writeEventsToFile(String filePath) {
    try {
      FileOutputStream fos = new FileOutputStream(filePath);
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(events);
      oos.close();
      fos.close();
    } catch (IOException e) {
      //TODO
    }
  }



  public List<Event> getDayEventsOnHighlightedCal(){
    List<Event> result = new ArrayList<Event>();
    for (int i = 0; i < events.size(); i++) {
      Calendar startCal = events.get(i).startCal;
      if (startCal.get(startCal.YEAR) == highlightedCal.get(highlightedCal.YEAR) &&
          startCal.get(startCal.MONTH) == highlightedCal.get(highlightedCal.MONTH) &&
          startCal.get(startCal.DAY_OF_MONTH) == highlightedCal.get(highlightedCal.DAY_OF_MONTH)) {
        result.add(events.get(i));
      }
    }
    return result;
  }


  public Calendar getHighlightedCal(){
    return highlightedCal;
  }

  /**
   Mutatorssssssss
   */
  public void createEventOnHighlightedCal(String startHM, String endHM, String title){
    Event event = new Event(title, parseToCal(startHM), parseToCal(endHM));
    insert(event);
    view.repaint();

  }
  public void changeHighlightedCalToDay(int day){
    highlightedCal.set(highlightedCal.DAY_OF_MONTH, day);
    view.repaint();
  }
  public void changeHighlightedCalToNextMonth(){
    highlightedCal.add(highlightedCal.MONTH, 1);
    highlightedCal.set(highlightedCal.DAY_OF_MONTH, 1);
    view.repaint();
  }
  public void changeHighlightedCalToPrevMonth(){
    highlightedCal.add(highlightedCal.MONTH, -1);
    highlightedCal.set(highlightedCal.DAY_OF_MONTH, 1);
    view.repaint();
  }




  /**
   Utility. Parse string to Calendar instance.
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
     Insert event to events list. Keep acsending order.
     */
    private void insert(Event event) {
      //TODO: handle time conflict
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

    public Object[][] makeTableContent(){
      Calendar temp = (Calendar)getHighlightedCal().clone();
      // System.out.println(temp.get(temp.DAY_OF_WEEK));
      temp.set(temp.DAY_OF_MONTH, 1);
      int month = temp.get(temp.MONTH);

      String[][] result = new String[5][7];
      for(int i = 0; i < 5; i++){
        for(int j = 0; j < 7; j++){
          if(temp.get(temp.MONTH) != month) result[i][j] = "";
          else if(i == 0 && temp.get(temp.DAY_OF_WEEK) -1 > j) result[i][j] = "";
          else{
            result[i][j] = "" + temp.get(temp.DAY_OF_MONTH);
            temp.add(temp.DAY_OF_MONTH, 1);
          }
        }
      }
      return result;
    }

}
