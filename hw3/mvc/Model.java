import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.*;


public class Model{
  private ArrayList<String> messageArr;
  private ArrayList<View> viewArr;

  public Model(){
    this.messageArr = new ArrayList<String>();
    this.viewArr = new ArrayList<View>();
  }
  /**
   * Accessor
   */
  public ArrayList<String> getMessageArr(){
    return messageArr;
  }

  public void pushToMessageArr(String s){
    messageArr.add(s);
    for(int i = 0; i < viewArr.size(); i++){
      viewArr.get(i).stateChanged();
    }
  }

  public void attach(View view){
    viewArr.add(view);
  }

}
