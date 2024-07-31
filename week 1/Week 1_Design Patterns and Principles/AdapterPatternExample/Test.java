public class Test {
    public static void main(String[] args) {

        PaymentProcessor payPalProcessor = new PayPalAdapter(new PayPal());
        PaymentProcessor stripeProcessor = new StripeAdapter(new Stripe());
        PaymentProcessor squareProcessor = new SquareAdapter(new Square());

        System.out.println("Using PayPal Adapter:");
        payPalProcessor.processPayment(100.0);

        System.out.println("\nUsing Stripe Adapter:");
        stripeProcessor.processPayment(200.0);

        System.out.println("\nUsing Square Adapter:");
        squareProcessor.processPayment(300.0);
    }
}