public class StripeAdapter implements PaymentProcessor {

    private Stripe amount;

    public StripeAdapter() {
        amount = new Stripe();
    }

    public String processPayment() {
        return amount.sendPayment();
    }

}
