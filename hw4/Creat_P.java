import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

import java.util.GregorianCalendar;
import java.util.Calendar;

public class Creat_P extends MyPanel{

  public Creat_P(Model m, View v){
    super(m, v);

    JTextArea  date = new JTextArea("TO display date");

    JButton save_B = new JButton("save");
    save_B.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        //TODO: save new event to model,
        view.displayMonthEventPanel();
      }
    });


    add(date);
    add(save_B);
  }

}
