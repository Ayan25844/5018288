package StrategyPatternExample;

public class Test_8 {

    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        context.setStrategy(new PayPalPayment());
        context.processPayment(1000);
    }

}
