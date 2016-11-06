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
    final String[] columnNames = {"Su", "Mo", "Tu", "We",
                                        "Th", "Fr", "Sa"};
    final JTable table;

    public Month_P(Model m, View v) {
        super(m, v);


        table = new JTable(makeTableContent(), columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(300, 100));//TODO: SIZE TABLE BY JFRAME SIZE
        table.setFillsViewportHeight(true);
        table.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
              JTable target = (JTable)e.getSource();
              int row = target.getSelectedRow();
              int column = target.getSelectedColumn();
              //TODO: check wheter (row, colume) is ""
              getModel().changeHighlightedCalToDay(Integer.parseInt( (String)table.getModel().getValueAt(row, column) ));
          }
        });
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        //Add the scroll pane to this panel.

        JButton prev_B = new JButton("<");
        prev_B.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
            getModel().changeHighlightedCalToPrevMonth();
          }
        });

        JButton next_B = new JButton(">");
        next_B.addActionListener(new ActionListener(){
          @Override
          public void actionPerformed(ActionEvent e){
            getModel().changeHighlightedCalToNextMonth();
          }
        });



        add(scrollPane);
        add(prev_B);
        add(next_B);
        setLayout(new GridLayout(1,0));

        //TODO: add > button, < button, create button, quit button
    }
    @Override
    public void react(){
      String[][] result = makeTableContent();
      for(int i = 0; i < 5; i++){
        for(int j = 0; j < 7; j++){
          table.getModel().setValueAt(result[i][j], i, j);
        }
      }

    }

    public String[][] makeTableContent(){
      Calendar temp = (Calendar)getModel().getHighlightedCal().clone();
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
