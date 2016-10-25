import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;
public class SliderTester {

  private  static final int ICON_WIDTH = 400;
  private  static final int ICON_HEIGHT = 100;
  private  static final int CAR_WIDTH = 100;

  public static void main(String args[]) {
    JFrame frame = new JFrame();

    JPanel container = new JPanel();

    JPanel carPanel = new JPanel();
    DeformableShape car = new CarShape(0, 0, CAR_WIDTH);
    ShapeIcon icon = new ShapeIcon(car, ICON_WIDTH, ICON_HEIGHT);
    JLabel label = new JLabel(icon);
    carPanel.add(label);


    JPanel sliderPanel = new JPanel();
    final JSlider slider = new JSlider();
    slider.addChangeListener(new ChangeListener() {
      @Override
      public void stateChanged(ChangeEvent e) {
        JSlider s = (JSlider)e.getSource();
        car.translate(s.getValue());
        frame.repaint();
      }
    });
    sliderPanel.add(slider);


    container.add(sliderPanel);
    container.add(carPanel);
    frame.add(container);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}
