import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Month_Event_P extends MyPanel{
  public Month_P m_P;
  public Event_P e_P;
  public Month_Event_P(Model m, View v){
    super(m, v);
    setLayout(new BorderLayout());
    m_P = new Month_P(getModel(), getView());
    e_P = new Event_P(getModel(), getView());
    add( m_P, BorderLayout.LINE_START);
    add( e_P, BorderLayout.LINE_END);

  }
  public void updateData(){
    m_P.updateData();
    e_P.updateData();
  }

}
