public interface Stock {

    public void notifyCustomers();

    public void register(Observer customer);

    public void deregister(Observer Customer);

}
