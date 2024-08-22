import java.util.ArrayList;

public class StockMarket implements Stock {

    private final ArrayList<Observer> list;

    public StockMarket() {
        list = new ArrayList<>();
    }

    public void register(Observer customer) {
        list.add(customer);
    }

    public void deregister(Observer customer) {
        list.remove(customer);
    }

    public void notifyCustomers() {
        for (Observer customer : list) {
            customer.update();
        }
    }

}
