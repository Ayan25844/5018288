public class Test_7 {

    public static void main(String[] args) {

        Stock stock = new StockMarket();

        Observer webApp = new WebApp("ayan25844@gmail.com");
        Observer mobileApp = new MobileApp("ayan25844@gmail.com");

        stock.register(webApp);
        stock.register(mobileApp);
        stock.deregister(mobileApp);

        stock.notifyCustomers();

    }

}
