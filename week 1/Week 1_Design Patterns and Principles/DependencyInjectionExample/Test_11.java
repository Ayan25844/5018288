public class Test_11 {

    public static void main(String[] args) {
        CustomerService customer = new CustomerService(new CustomerRepositoryImpl());
        customer.getId(2);
    }

}
