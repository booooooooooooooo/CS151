import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Event_P extends MyPanel {
  private JTextArea j;
  public Event_P(Model m, View v) {
    super(m, v);
    j = new JTextArea(getModel().getDayEventsOnHighlightedCal().toString(), 10,
                      10); // TODO: size j by size of jframe
    j.setLineWrap(true);
    add(j);
  }
  // To delete
  // public void setText(String s){
  //   j.setText(s);
  //   repaint();
  // }

  @Override
  public void updateData() {
    j.setText(getModel().getDayEventsOnHighlightedCal().toString());
  }
}
