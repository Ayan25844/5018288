public class SquareAdapter implements PaymentProcessor {

    private Square amount;

    public SquareAdapter() {
        amount = new Square();
    }

    public String processPayment() {
        return amount.sendPayment();
    }

}
