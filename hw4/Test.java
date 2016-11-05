import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class Test {

  public static void main(String args[]){
    // JFrame frame = new JFrame();
    // frame.setSize(500, 500);
    // frame.add(new Calendar_P());
    // frame.setLayout(new FlowLayout());
    // frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    // frame.setVisible(true);

    // model.createEventOnHighlightedCal("18:30", "10:00","fellowship");
    // model.createEventOnHighlightedCal("9:00", "10:00","morning");
    // model.createEventOnHighlightedCal("12:00", "13:00","lunch");
    // model.writeEventsToFile("./events.txt");


    Model model = new Model("./events.txt");

    List<Event> result = model.getDayEventsOnHighlightedCal();
    for(int i = 0; i < result.size(); i++){
      System.out.println(result.get(i));
    }

    log(model.getHighlightedCal().getTime());
    model.changeHighlightedCalToDay(10);
    log(model.getHighlightedCal().getTime());
    model.changeHighlightedCalToNextMonth();
    log(model.getHighlightedCal().getTime());
    model.changeHighlightedCalToPrevMonth();
    log(model.getHighlightedCal().getTime());

  }

  public static void log(Object obj){
    System.out.println(obj);
  }
}
