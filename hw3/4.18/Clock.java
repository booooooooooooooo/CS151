import java.util.Calendar;
import java.util.GregorianCalendar;
import java.awt.*;
import java.awt.geom.*;

public class Clock {
  public double x;
  public double y;
  private double d;

  public Clock(double x, double y, double diameter) {
    this.x = x;
    this.y = y;
    this.d = diameter;
  }
  public void draw(Graphics2D g2) {
    Ellipse2D circle = new Ellipse2D.Double();
    circle.setFrameFromCenter(x, y, x + d / 2, y + d / 2);


    GregorianCalendar cal = new GregorianCalendar();
    double hour = (double)cal.get(Calendar.HOUR);
    double mnt = (double)cal.get(Calendar.MINUTE);
    double sec = (double)cal.get(Calendar.SECOND);
    double radiansH = Math.toRadians((hour - 0) / 12 * 360);
    double radiansM = Math.toRadians((mnt - 0) / 60 * 360);
    double radiansS = Math.toRadians((sec - 0) / 60 * 360);
    System.out.printf("hour : %f, minite : %f, second : %f\n", hour, mnt, sec);
    Line2D.Double hourLine = new Line2D.Double(
        x, y, x + d / 3 * Math.sin(radiansH), y - d / 3 * Math.cos(radiansH));
    Line2D.Double mntLine =
        new Line2D.Double(x, y, x + d / 2.5 * Math.sin(radiansM),
                          y - d / 2.5 * Math.cos(radiansM));
    Line2D.Double secLine =
        new Line2D.Double(x, y, x + d / 2.1 * Math.sin(radiansS),
                          y - d / 2.1 * Math.cos(radiansS));

    g2.draw(circle);
    g2.draw(hourLine);
    g2.draw(mntLine);
    g2.draw(secLine);
  }
}
