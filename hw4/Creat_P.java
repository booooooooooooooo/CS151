import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;

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

public class Creat_P extends MyPanel {

  public Creat_P(Model m, View v) {
    super(m, v);

    JTextField title_textField = new JTextField("Untitled Event");
    JTextArea date_textField = new JTextArea(model.getMMDDYYYY());
    JTextField startTime_textField = new JTextField("HH:MM");
    JLabel to_lable = new JLabel("to");
    JTextField endTime_textField = new JTextField("HH:MM");

    JButton save_B = new JButton("save");
    save_B.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO: save new event to model,
        String startHM = startTime_textField.getText();
        String endHM = endTime_textField.getText();
        String title = title_textField.getText();
        model.createEventOnHighlightedCal(startHM, endHM, title);
        view.displayMonthEventPanel();
      }
    });

    add(title_textField);
    add(date_textField);
    add(startTime_textField);
    add(to_lable);
    add(endTime_textField);
    add(save_B);
  }
}
