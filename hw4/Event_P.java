import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Event_P extends MyPanel {
  private JTextArea j;
  /**
    Constructor
    */
  public Event_P(Model m, View v) {
    super(m, v);
    j = new JTextArea(getModel().getDayEventsOnHighlightedCal().toString(), 10,
                      40);
    j.setLineWrap(true);
    add(j);
  }

  /**
    update all data in GUI tree branch in depth first order.
    */
  @Override
  public void updateData() {
    j.setText(getModel().getDayEventsOnHighlightedCal().toString());
  }
}
