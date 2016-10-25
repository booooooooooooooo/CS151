import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AnimationTester {
  private static final int ICON_WIDTH = 400;
  private static final int ICON_HEIGHT = 100;
  private static final int CAR_WIDTH = 100;
  public static void main(String[] args) {
    JFrame frame = new JFrame();
    final MoveableShape shape = new CarShape(0, 0, CAR_WIDTH, frame);
    ShapeIcon icon = new ShapeIcon(shape, ICON_WIDTH, ICON_HEIGHT);
    final JLabel label = new JLabel(icon);
    frame.setLayout(new FlowLayout());
    frame.add(label);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
    final int DELAY = 100;
    // Milliseconds between timer ticks
    Timer t = new Timer(DELAY, new ActionListener() {
      public void actionPerformed(ActionEvent event) {
        shape.translate(5, 0);
        label.repaint();
      }
    });
    t.start();
  }
}
