import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class View extends JFrame {
  private Model model;
  private final int FRAME_WIDTH = 1000;
  private final int FRAME_HEIGHT = 600;
  private MyPanel cur_P;
  /**
    Constructor
    */
  public View(Model m) {
    this.model = m;

    cur_P = new Month_Event_P(model, this);
    getContentPane().add(cur_P);

    setSize(FRAME_WIDTH, FRAME_HEIGHT);
    add(cur_P);
    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);
  }
  /**
    switch to Creat_P
    */
  public void displayCreatePanel() {
    getContentPane().removeAll();
    cur_P = new Creat_P(model, this);
    getContentPane().add(cur_P);
    revalidate();
  }
  /**
    switch to Month_Event_P
    */
  public void displayMonthEventPanel() {
    getContentPane().removeAll();
    cur_P = new Month_Event_P(model, this);
    getContentPane().add(cur_P);
    revalidate();
  }
  /**
    Update all data in GUI tree in depth first order then repaint GUI tree.
    Model mutators must call this.
    GUI methods call this when necessary.
    */
  public void drawOnUpdatedData() {
    cur_P.updateData();
    repaint();
  }
}
