import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public abstract class MyPanel extends JPanel {
  protected Model model;
  protected View view;
  /**
    Constructor
    */
  public MyPanel(Model m, View v) {
    this.model = m;
    this.view = v;
  }

  public Model getModel() { return model; }

  public View getView() { return view; }

  /**
    update all data in GUI tree branch in depth first order.
    to be overrided when needed.
    */
  public void updateData(){};
}
