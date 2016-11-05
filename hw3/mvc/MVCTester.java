import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;


public class MVCTester{
  public static void main(String args[]){
    Model model = new Model();
    MiniFrameView miniFrameView = new MiniFrameView(model);
    model.attach(miniFrameView);



  }
}
