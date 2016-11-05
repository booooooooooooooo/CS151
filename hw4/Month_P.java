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

public class Month_P extends MyPanel {

    public Month_P(Model m, View v) {
        // super(new GridLayout(1,0));
        super(m, v);
        final String[] columnNames = {"Su", "Mo", "Tu", "We",
                                              "Th", "Fr", "Sa"};

        final JTable table = new JTable(model.makeTableContent(), columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);
        table.addMouseListener(new MouseAdapter() {
          public void mouseClicked(MouseEvent e) {
              JTable target = (JTable)e.getSource();
              int row = target.getSelectedRow();
              int column = target.getSelectedColumn();
              model.changeHighlightedCalToDay(Integer.parseInt( (String)table.getModel().getValueAt(row, column) ));
              // System.out.printf("Row %d, Colume %d is clicked! year = %d, month = %d, day = %s\n", row, column, cal.get(cal.YEAR), cal.get(cal.MONTH), table.getModel().getValueAt(row, column));

          }
        });
        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);
        //Add the scroll pane to this panel.
        add(scrollPane);



        //TODO: add > button, < button, create button, quit button
    }




}
