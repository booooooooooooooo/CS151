import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
public class CarShape implements DeformableShape {
  private int x;
  private int y;
  private int width;
  private int percent = 50;

  public CarShape(int x, int y, int width) {
    this.x = x;
    this.y = y;
    this.width = width;
  }
  public void translate(int percent) {
    this.percent = percent;
  }
  public void draw(Graphics2D g2) {
    // Create the parts of this car and draw them here.
    Rectangle2D.Double body =
        new Rectangle2D.Double(x, y + width * percent / 100 / 6, width * percent / 100 - 1, width * percent / 100 / 6);
    Ellipse2D.Double frontTire = new Ellipse2D.Double(
        x +  width * percent / 100 / 6, y + width * percent / 100 / 3, width * percent / 100 / 6, width * percent / 100 / 6);
    Ellipse2D.Double endTire = new Ellipse2D.Double(  x + width * percent / 100 * 2 / 3, y + width * percent / 100 / 3, width * percent / 100 / 6, width * percent / 100 / 6);

    g2.draw(body);
    g2.draw(frontTire);
    g2.draw(endTire);
  }
}
