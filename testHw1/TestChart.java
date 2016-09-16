import hw1.*;
import java.util.*;
class TestChart{
  public static void main(String[] args){
    Chart chart = new Chart("Economy");
    View.printPanel(chart, chart.getRow(), chart.getCol());
    chart.addPassenger("xiaohei", "W");
    View.printPanel(chart, chart.getRow(), chart.getCol());
    List<String> names = new ArrayList<String>();
    names.add("Bo");
    names.add("Tong");
    names.add("Bo");
    names.add("Tong");
    names.add("Bo");
    names.add("Tong");
    names.add("Bo");
    names.add("Tong");
    chart.addGroup("15", names);
    View.printPanel(chart, chart.getRow(), chart.getCol());
    chart.cancelPassenger("xiaohei");
    View.printPanel(chart, chart.getRow(), chart.getCol());
    chart.cancelGroup("15");
    View.printPanel(chart, chart.getRow(), chart.getCol());

  }
}
