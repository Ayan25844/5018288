package StrategyPatternExample;

public class CreditCardPayment implements PaymentStrategy {

    public void pay(long amount) {

        System.out.println("Paying an amount of " + amount + " ruppees via credit card.");
    }

}
