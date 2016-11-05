import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Month_Event_P extends MyPanel{
  public Month_Event_P(Model m, View v){
    super(m, v);
    
    add( new Month_P(model, view));
    add( new Event_P(model, view));
  }
}
