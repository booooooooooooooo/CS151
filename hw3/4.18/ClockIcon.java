import java.awt.*;
import java.util.*;
import javax.swing.*;

public class ClockIcon implements Icon {
  private int width;
  private int height;
  private Clock clock;

  public ClockIcon(int width, int height, Clock clock) {
    this.width = width;
    this.height = height;
    this.clock = clock;
  }

  @Override
  public int getIconWidth() {
    return this.width;
  }
  @Override
  public int getIconHeight() {
    return this.height;
  }
  @Override
  public void paintIcon(Component c, Graphics g, int x, int y) {
    Graphics2D g2 = (Graphics2D)g;
    clock.draw(g2);
  }
}
