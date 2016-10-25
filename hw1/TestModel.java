import hw1.*;
import java.util.*;
public class TestModel{
  public static void main(String args[]) throws Exception{
    Model model = new Model("/Users/xiaohei/Downloads/cs151/hw1/orderInfo");

    View.printPanel(model.firstChart, model.firstChart.getRow(), model.firstChart.getCol());
    View.printPanel(model.economyChart, model.economyChart.getRow(), model.economyChart.getCol());
    model.writeOrderInfoToFile("/Users/xiaohei/Downloads/cs151/hw1/orderInfo");

  }
}
