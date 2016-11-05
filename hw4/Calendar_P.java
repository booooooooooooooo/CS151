import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.GregorianCalendar;
import java.util.Calendar;

public class Calendar_P extends JPanel {
    private Calendar cal; // Current time of first day of the month being displayed.
    private Object[][] data;// Changed together with calendar
    private final String[] columnNames = {"Su", "Mo", "Tu", "We",
                                          "Th", "Fr", "Sa"};



    public Calendar_P() {
        super(new GridLayout(1,0));
        cal = new GregorianCalendar();//initialize cal as today
        data = makeDayArr();




        final JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
              JTable target = (JTable)e.getSource();
              int row = target.getSelectedRow();
              int column = target.getSelectedColumn();
              System.out.printf("Row %d, Colume %d is clicked! year = %d, month = %d, day = %d\n", row, column, cal.get(cal.YEAR), cal.get(cal.MONTH), table.getModel().getValueAt(row, column));

          }
        });

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    public void nextMonth(){
      //TODO: change cal to first day of next month
      makeDayArr(); // change table content at the same time
      repaint();
    }

    public void prevMonth(){
      //TODO: change cal to first day of previous month
      makeDayArr(); // change table content at the same time
      repaint();
    }


    private Object[][] makeDayArr(){
      Calendar temp = (Calendar)cal.clone();
      temp.set(temp.DAY_OF_MONTH, 1);

      Integer[][] result = new Integer[5][7];
      for(int i = 0; i < 5; i++){
        for(int j = 0; j < 7; j++){
          result[i][j] = 0;
        }
      }
      return result;
    }

}
