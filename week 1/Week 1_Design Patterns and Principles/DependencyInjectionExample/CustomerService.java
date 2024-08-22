public class CustomerService {

    private CustomerRepository customer;

    public CustomerService(CustomerRepository customer) {
        this.customer = customer;
    }

    public void getId(int id) {
        this.customer.findCustomerById(id);
    }

}
