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

public class Month_P extends MyPanel {
  private final String[] columnNames = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
  private final JTable table;
  /**
    Constructor
    */
  public Month_P(Model m, View v) {
    super(m, v);

    table = new JTable(makeTableContent(), columnNames);
    table.setCellSelectionEnabled(true);
    table.setPreferredScrollableViewportSize(
        new Dimension(300, 100)); // TODO: SIZE TABLE BY JFRAME SIZE
    table.setFillsViewportHeight(true);
    // highlight cell of defualt highlighted day
    highlightHighlightedDay();
    // highlight clicked day
    table.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent e) {
        JTable target = (JTable)e.getSource();
        int row = target.getSelectedRow();
        int column = target.getSelectedColumn();
        // TODO: check wheter (row, colume) is ""
        String entry = (String)table.getModel().getValueAt(row, column);
        if (entry == "") {
          // not a valid day. Keep highlighting the current highlighted day.
          highlightHighlightedDay();
        } else
          getModel().changeHighlightedCalToDay(Integer.parseInt(entry));
      }
    });
    // Create the scroll pane and add the table to it.
    JScrollPane scrollPane = new JScrollPane(table);
    // Add the scroll pane to this panel.

    JButton prev_B = new JButton("<");
    prev_B.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        getModel().changeHighlightedCalToPrevMonth();
      }
    });

    JButton next_B = new JButton(">");
    next_B.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        getModel().changeHighlightedCalToNextMonth();
      }
    });
    JButton create_B = new JButton("CREATE");
    create_B.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        view.displayCreatePanel();
      }
    });
    JButton quit_B = new JButton("QUIT");
    quit_B.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        // TODO
        model.writeEventsToFile();
        view.dispatchEvent(new WindowEvent(view, WindowEvent.WINDOW_CLOSING));
      }
    });

    setLayout(new GridBagLayout());
    GridBagConstraints c = new GridBagConstraints();
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 0;
    c.gridwidth = 1;
    add(create_B, c);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 1;
    c.gridy = 0;
    c.gridwidth = 1;
    add(prev_B, c);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 2;
    c.gridy = 0;
    c.gridwidth = 1;
    add(next_B, c);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 3;
    c.gridy = 0;
    c.gridwidth = 1;
    add(quit_B, c);
    c.fill = GridBagConstraints.HORIZONTAL;
    c.gridx = 0;
    c.gridy = 1;
    c.gridwidth = 4;
    add(scrollPane, c);

  }
  /**
    Mark the active day.
    */
  private void highlightHighlightedDay() {
    int[] cell = getCellOfHighlightedDay();
    table.setRowSelectionInterval(cell[0], cell[0]);
    table.setColumnSelectionInterval(cell[1], cell[1]);
  }
  /**
    One of utilities. Get table array based on active date.
    */
  private String[][] makeTableContent() {
    Calendar temp = (Calendar)getModel().getHighlightedCal().clone();
    // System.out.println(temp.get(temp.DAY_OF_WEEK));
    temp.set(temp.DAY_OF_MONTH, 1);
    int month = temp.get(temp.MONTH);

    String[][] result = new String[5][7];
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 7; j++) {
        if (temp.get(temp.MONTH) != month)
          result[i][j] = "";
        else if (i == 0 && temp.get(temp.DAY_OF_WEEK) - 1 > j)
          result[i][j] = "";
        else {
          result[i][j] = "" + temp.get(temp.DAY_OF_MONTH);
          temp.add(temp.DAY_OF_MONTH, 1);
        }
      }
    }
    return result;
  }
  /**
    One of utilities. get row and column of active day in JTable
    */
  private int[] getCellOfHighlightedDay() {
    int[] cell = new int[2];

    Calendar highlightedCal = getModel().getHighlightedCal();
    Calendar temp = (Calendar)highlightedCal.clone();
    temp.set(temp.DAY_OF_MONTH, 1);
    int month = temp.get(temp.MONTH);

    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 7; j++) {
        if (i == 0 && temp.get(temp.DAY_OF_WEEK) - 1 > j)
          continue;
        else {
          if (highlightedCal.get(highlightedCal.MONTH) ==
                  temp.get(temp.MONTH) &&
              highlightedCal.get(highlightedCal.DAY_OF_MONTH) ==
                  temp.get(temp.DAY_OF_MONTH)) {
            cell[0] = i;
            cell[1] = j;
            // break for for loop
            i = 100;
            j = 100;
          }
          temp.add(temp.DAY_OF_MONTH, 1);
        }
      }
    }
    return cell;
  }
  /**
    update all data in GUI tree branch in depth first order.
    */
  @Override
  public void updateData() {
    String[][] result = makeTableContent();
    for (int i = 0; i < 5; i++) {
      for (int j = 0; j < 7; j++) {
        table.getModel().setValueAt(result[i][j], i, j);
      }
    }
    highlightHighlightedDay();
  }
}
