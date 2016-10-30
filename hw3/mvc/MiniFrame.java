import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;

public class MiniFrame extends JFrame implements View{
  private Model model;
  private JTextField textField;
  private JTextArea textArea;
  private JButton button;

  public MiniFrame(Model model){
    this.model = model;
    this.textField = new JTextField();
    this.textArea = new JTextArea("Message displayed here:");
    this.button = new JButton("Add");

    button.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        model.pushToMessageArr(textField.getText() + "\n");
      }
    });


    JPanel panel = new JPanel(new GridBagLayout());
    panel.add(button);
    panel.add(textArea);
    panel.add(textField);
    add(panel);
    pack();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setVisible(true);


  }

  @Override
  public void stateChanged(){
    String s = "";
    for(int i = 0; i < model.getMessageArr().size(); i++){
      s = s + model.getMessageArr().get(i);
    }
    textArea.setText(s);
    textArea.repaint();
  }
}
