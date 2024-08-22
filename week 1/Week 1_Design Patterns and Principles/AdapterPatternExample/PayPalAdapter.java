public class PayPalAdapter implements PaymentProcessor {

    private PayPal amount;

    public PayPalAdapter() {
        amount = new PayPal();
    }

    public String processPayment() {
        return amount.sendPayment();
    }

}
