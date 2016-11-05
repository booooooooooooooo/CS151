import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Event_P extends MyPanel{
  public Event_P(Model m, View v){
    super(m, v);
    JTextArea j = new JTextArea(model.getDayEventsOnHighlightedCal().toString());
    add(j);
  }
}
