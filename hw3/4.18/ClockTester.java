import javax.swing.*;
import java.awt.*;
import javax.swing.Timer;
import java.awt.event.*;

public class ClockTester {
  private static final int ICON_WIDTH = 400;
  private static final int ICON_HEIGHT = 400;

  public static void main(String args[]) {
    JFrame frame = new JFrame();
    Clock clock = new Clock(ICON_WIDTH / 2, ICON_HEIGHT / 2, ICON_WIDTH / 3);
    ClockIcon icon = new ClockIcon(ICON_WIDTH, ICON_HEIGHT, clock);
    final JLabel label = new JLabel(icon);

    final int DELAY = 100;
    Timer t = new Timer(DELAY, new ActionListener() {
      public void actionPerformed(ActionEvent event) { label.repaint(); }
    });
    t.start();

    frame.setLayout(new FlowLayout());
    frame.add(label);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);


  }
}
