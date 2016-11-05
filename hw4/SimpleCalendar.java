import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class SimpleCalendar{
  public static void main(String args[]){
    Model model = new Model("./events.txt");
    View view = new View(model);
    model.attach(view);
  }
}
