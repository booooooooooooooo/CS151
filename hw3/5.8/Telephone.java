import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
   Presents a phone GUI for the voice mail system.  When multiple Telephones
   are created, closing the last one will exit the program.
*/
public class Telephone
{
  private JTextArea speakerField;
  private Connection connect;
  private static int numberOfPhones = 0;
   /**
      Constructs a telephone with a speaker, keypad, and microphone.
   */
   public Telephone()
   {

      numberOfPhones = numberOfPhones + 1;

      //Create speakerPanel
      JPanel speakerPanel = new JPanel();
      speakerPanel.setLayout(new BorderLayout());
      speakerPanel.add(new JLabel("Speaker:"),
         BorderLayout.NORTH);
      speakerField = new JTextArea(10, 25);
      speakerPanel.add(new JScrollPane(speakerField),
         BorderLayout.CENTER);

      //Create keyPanel
      JPanel keyPanel = new JPanel();
      String keyLabels = "123456789*0#";
      keyPanel.setLayout(new GridLayout(4, 3));
      for (int i = 0; i < keyLabels.length(); i++)
      {
         final String label = keyLabels.substring(i, i + 1);
         JButton keyButton = new JButton(label);
         keyPanel.add(keyButton);
         keyButton.addActionListener(new
            ActionListener()
            {
               public void actionPerformed(ActionEvent event)
               {
                  connect.dial(label);
               }
            });
      }

      //Create microphone Panel
      final JTextArea microField = new JTextArea(10, 25);
      JScrollPane microPane = new JScrollPane(microField);

      JButton speechButton = new JButton("Send speech");
      speechButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               connect.record(microField.getText());
               microField.setText("");
            }
         });
      JButton hangupButton = new JButton("Hangup");
      hangupButton.addActionListener(new
         ActionListener()
         {
            public void actionPerformed(ActionEvent event)
            {
               connect.hangup();
            }
         });
      JPanel buttonPanel = new JPanel();
      buttonPanel.add(speechButton);
      buttonPanel.add(hangupButton);

      JPanel microphonePanel = new JPanel();
      microphonePanel.setLayout(new BorderLayout());
      microphonePanel.add(new JLabel("Microphone:"),
         BorderLayout.NORTH);
      microphonePanel.add(microPane, BorderLayout.CENTER);
      microphonePanel.add(buttonPanel,
         BorderLayout.SOUTH);

      //create jframe. Add speakerPanel, keyPanel and microPane to it.
      final JFrame frame = new JFrame();
      frame.add(speakerPanel,
         BorderLayout.NORTH);
      frame.add(keyPanel,
         BorderLayout.CENTER);
      frame.add(microphonePanel, BorderLayout.SOUTH);
      // Replace the default close operation with a window event listener.
      frame.addWindowListener(new
         WindowAdapter()
         {
            public void windowClosing(WindowEvent event)
            {
               if (numberOfPhones == 1)
                  System.exit(0);
               else
               {
                  numberOfPhones = numberOfPhones - 1;
                  frame.dispose();
               }
            }
         });
      frame.pack();
      frame.setVisible(true);
   }

   /**
      Give instructions to the mail system user.
   */
   public void speak(String output)
   {
      speakerField.setText(output);
   }

   public void run(Connection c)
   {
      connect = c;
   }


}
