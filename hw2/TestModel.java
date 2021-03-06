import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
public class TestModel {
  public static void main(String args[]) {
    GregorianCalendar cal = new GregorianCalendar();
    Model model = new Model();
    model.loadEventsFromFile("./events.txt");
    for(int i = 0; i < model.events.size(); i++){
    System.out.println(model.events.get(i));
    }
    // model.createEvent("Create first event", 2016, 10, 7,22, 30);
    // for(int i = 0; i < model.events.size(); i++){
    // System.out.println(model.events.get(i));
    // }
    List<Event> eventListOfDay = model.getEventListOfDay(cal);
    System.out.println("===eventListOfDay===");
    for (int i = 0; i < eventListOfDay.size(); i++) {
      System.out.println(eventListOfDay.get(i));
    }

    List<Event> eventListOfMonth = model.getEventListOfMonth(cal);
    System.out.println("===eventListOfMonth===");
    for (int i = 0; i < eventListOfMonth.size(); i++) {
      System.out.println(eventListOfMonth.get(i));
    }

    List<Event> wholeEventList = model.getWholeEventList();
    System.out.println("===wholeEventList===");
    for (int i = 0; i < wholeEventList.size(); i++) {
      System.out.println(wholeEventList.get(i));
    }

    model.createEvent("Finish hw2 this evening",
                      new GregorianCalendar(2016, 9, 13, 17, 34),
                      new GregorianCalendar(2016, 9, 13, 22, 00));
    System.out.printf("\n\nAfter deletion\n\n");

    eventListOfDay = model.getEventListOfDay(cal);
    System.out.println("===eventListOfDay===");
    for (int i = 0; i < eventListOfDay.size(); i++) {
      System.out.println(eventListOfDay.get(i));
    }

    eventListOfMonth = model.getEventListOfMonth(cal);
    System.out.println("===eventListOfMonth===");
    for (int i = 0; i < eventListOfMonth.size(); i++) {
      System.out.println(eventListOfMonth.get(i));
    }

    wholeEventList = model.getWholeEventList();
    System.out.println("===wholeEventList===");
    for (int i = 0; i < wholeEventList.size(); i++) {
      System.out.println(wholeEventList.get(i));
    }

    // model.writeEventsToFile("./events.txt");
    // View.displayMonthWithEventHighLighted(cal, null);
  }
}
