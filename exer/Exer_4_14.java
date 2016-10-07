import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import java.awt.Color;

import javax.swing.*;

public class Exer_4_14 {
  public static void main(String[] args) {
    DrawFrame frame = new DrawFrame();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }
}

class DrawFrame extends JFrame {
  public static final int FRAME_WIDTH = 300;
  public static final int FRAME_HEIGHT = 200;
  public DrawFrame() {
    setSize(FRAME_WIDTH, FRAME_HEIGHT);
    JPanel container = new ContainerPanel();
    container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
    add(container);
  }
}

class ContainerPanel extends JPanel {
  public ContainerPanel() {
    final PicPanel picPanel = new PicPanel();
    final ButtonPanel buttonPanel = new ButtonPanel(picPanel);

    add(picPanel);
    add(buttonPanel);
  }

}
class PicPanel extends JPanel {
  public Color color;
  public PicPanel() { this.color = Color.BLACK; }
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    Graphics2D g2 = (Graphics2D)g ;
    double width = 100;
    double height = 100;
    double leftX = getWidth() / 2 - width / 2;
    double topY = getHeight() / 2 - height / 2;
    Rectangle2D rect = new Rectangle2D.Double(leftX, topY, width, height);

    g2.setColor(color);
    g2.fill(rect);
    g2.draw(rect);
  }
  public void setColor(Color color) {
    this.color = color;
    repaint();
  }
}

class ButtonPanel extends JPanel{
  public ButtonPanel(PicPanel picPanel){
    JButton redButton = new JButton("Red");
    redButton.addActionListener(makeActionListener(picPanel, Color.RED) );
    JButton blueButton = new JButton("Blue");
    blueButton.addActionListener(makeActionListener(picPanel, Color.BLUE));
    JButton greenButton = new JButton("Green");
    greenButton.addActionListener( makeActionListener(picPanel, Color.GREEN) );
    add(redButton);
    add(blueButton);
    add(greenButton);
  }
  public ActionListener makeActionListener(final PicPanel picPanel, final Color color){
    return new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent event) {
        picPanel.setColor(color);
      }
    };
  }
}
