package StrategyPatternExample;

public class PayPalPayment implements PaymentStrategy {

    public void pay(long amount) {

        System.out.println("Paying an amount of " + amount + " ruppees via pay pal card.");
    }

}
