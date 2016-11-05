import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class Run {

  public static void main(String args[]){
    JFrame frame = new JFrame();
    frame.setSize(500, 500);
    frame.add(new Calendar_P());
    frame.setLayout(new FlowLayout());
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
